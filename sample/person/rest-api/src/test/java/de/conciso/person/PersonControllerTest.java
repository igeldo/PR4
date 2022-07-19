package de.conciso.person;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PersonControllerTest extends ScenarioTest<PersonControllerTest.GivenStatement, PersonControllerTest.WhenAction, PersonControllerTest.ThenOutcome>{

    private static final int ID = 42;
    private static final String VORNAME = "someVorname";
    private static final String NAME = "someName";
    private static final String STRASSE = "someStrasse";
    private static final int PLZ = 12345;
    private static final String ORT = "someOrt";

    @Test
    public void given_Person_can_be_created_when_calling_create(){
        given().personRepresentation()
                .and().person()
                .and().person_can_be_created();
        when().creating_Controller()
                .and().calling_create();
        then().personenService_is_called()
                .and().status_is_OK()
                .and().body_is_correct();
    }

    @Test
    public void given_create_person_throws_exception(){
        given().personRepresentation()
                .and().person()
                .and().create_person_throws_exception();
        when().creating_Controller()
                .and().calling_create();
        then().personenService_is_called()
                .and().status_is_INTERNAL_SERVER_ERROR()
                .and().body_is_empty();
    }

    @Test
    public void given_person_can_be_found(){
        given().personRepresentation()
                .and().person()
                .and().person_can_be_found();
        when().creating_Controller()
                .and().calling_findById();
        then().personenService_is_called_findById()
                .and().status_is_OK()
                .and().body_is_correct();
    }

    @Test
    public void given_person_cannot_be_found(){
        given().personRepresentation()
                .and().person()
                .and().person_cannot_be_found();
        when().creating_Controller()
                .and().calling_findById();
        then().personenService_is_called_findById()
                .and().status_is_NOT_FOUND()
                .and().body_is_empty();
    }

    @Test
    public void given_find_person_throws_exception(){
        given().personRepresentation()
                .and().person()
                .and().find_person_throws_exception();
        when().creating_Controller()
                .and().calling_findById();
        then().personenService_is_called_findById()
                .and().status_is_INTERNAL_SERVER_ERROR()
                .and().body_is_empty();
    }

    @Test
    public void given_address_can_be_added_when_calling_addAddress(){
        given().personRepresentation()
                .and().person()
                .and().address_can_be_added();
        when().creating_Controller()
                .and().calling_addAddress();
        then().personenservice_is_called_addAddress()
                .and().status_is_OK()
                .and().body_is_correct();
    }

    @Test
    public void given_address_cannot_be_added(){
        given().address_cannot_be_added();
        when().creating_Controller()
                .and().calling_addAddress();
        then().personenservice_is_called_addAddress()
                .and().status_is_NOT_FOUND()
                .and().body_is_empty();
    }

    @Test
    public void given_addAddress_throws_exception(){
        given().addAddress_throws_exception();
        when().creating_Controller()
                .and().calling_addAddress();
        then().personenservice_is_called_addAddress()
                .and().status_is_INTERNAL_SERVER_ERROR()
                .and().body_is_empty();
    }

    protected static class GivenStatement extends Stage<GivenStatement>{

        @ProvidedScenarioState
        Personen personen = mock(Personen.class);

        @ProvidedScenarioState
        Person person;

        @ProvidedScenarioState
        PersonRepresentation personRepresentation;

        GivenStatement person_can_be_created(){
            BDDMockito.given(personen.create(any(Person.class))).willReturn(new Person(ID, VORNAME, NAME));
            return self();
        }

        GivenStatement create_person_throws_exception(){
            BDDMockito.given(personen.create(any(Person.class))).willThrow(IllegalStateException.class);
            return self();
        }

        GivenStatement person_can_be_found(){
            BDDMockito.given(personen.findById(anyInt())).willReturn(Optional.of(new Person(ID, VORNAME, NAME)));
            return self();
        }

        GivenStatement person_cannot_be_found(){
            BDDMockito.given(personen.findById(anyInt())).willReturn(Optional.empty());
            return self();
        }

        GivenStatement find_person_throws_exception(){
            BDDMockito.given(personen.findById(anyInt())).willThrow(IllegalStateException.class);
            return self();
        }

        GivenStatement person(){
            person = new Person(ID,VORNAME,NAME);
            return self();
        }

        GivenStatement personRepresentation(){
            personRepresentation = PersonRepresentation.builder().id(ID).vorname(VORNAME).name(NAME).addresses(List.of()).build();
            return self();
        }



        GivenStatement address_can_be_added(){
            BDDMockito.given(personen.addAddress(anyInt(), any(Address.class))).willReturn(Optional.of(person));
            return self();
        }

        GivenStatement address_cannot_be_added(){
            BDDMockito.given(personen.addAddress(anyInt(), any(Address.class))).willReturn(Optional.empty());
            return self();
        }

        GivenStatement addAddress_throws_exception(){
            BDDMockito.given(personen.addAddress(anyInt(), any(Address.class))).willThrow(IllegalStateException.class);
            return self();
        }

    }

    protected static class WhenAction extends Stage<WhenAction>{

        @ExpectedScenarioState
        Personen personen;
        @ProvidedScenarioState
        ResponseEntity<PersonRepresentation> result;
        PersonController cut;

        WhenAction creating_Controller(){
            cut = new PersonController(personen);
            return self();
        }
        WhenAction calling_create(){
            var personRepresentation = PersonRepresentation.builder()
                    .name(NAME)
                    .vorname(VORNAME)
                    .addresses(List.of())
                    .build();
            result = cut.create(personRepresentation);
            return self();
        }

        WhenAction calling_findById(){
            result = cut.findById(ID);
            return self();
        }

        WhenAction calling_addAddress(){
            var addressRepresentation = AddressRepresentation.builder()
                    .strasse(STRASSE)
                    .plz(PLZ)
                    .ort(ORT)
                    .build();
            result = cut.addAddress(ID, addressRepresentation);
            return self();
        }

    }

    protected static class ThenOutcome extends Stage<ThenOutcome>{

        @ExpectedScenarioState
        Personen personen;

        @ExpectedScenarioState
        ResponseEntity<PersonRepresentation> result;

        ThenOutcome personenService_is_called(){
            verify(personen).create(new Person(VORNAME, NAME));
            return self();
        }

        ThenOutcome personenService_is_called_findById() {
            verify(personen).findById(ID);
            return self();
        }

        ThenOutcome status_is_OK() {
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
            return self();
        }

        ThenOutcome status_is_INTERNAL_SERVER_ERROR(){
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
            return self();
        }

        ThenOutcome status_is_NOT_FOUND() {
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
            return self();
        }

        ThenOutcome body_is_correct() {
            var expected = PersonRepresentation.builder()
                    .id(ID)
                    .vorname(VORNAME)
                    .name(NAME)
                    .addresses(List.of())
                    .build();
            assertThat(result.getBody()).isEqualTo(expected);
            return self();
        }

        ThenOutcome body_is_empty() {
            assertThat(result.hasBody()).isFalse();
            return self();
        }



        ThenOutcome personenservice_is_called_addAddress(){
            verify(personen).addAddress(ID, new Address(STRASSE, PLZ, ORT));
            return self();
        }

    }
}
