package de.conciso.shop;

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

public class ShopControllerTest extends ScenarioTest<ShopControllerTest.GivenStatement, ShopControllerTest.WhenAction, ShopControllerTest.ThenOutcome> {

    private static final int ID = 42;
    private static final String VORNAME = "someVorname";
    private static final String NAME = "someName";
    private static final String STRASSE = "someStrasse";
    private static final int PLZ = 12345;
    private static final String ORT = "someOrt";


    @Test
    public void given_Person_can_be_created_when_calling_create() {
        given().personRepresentation()
                .and().person()
                .and().person_can_be_created();
        when().creating_Controller()
                .and().calling_create();
        then().personenService_is_called()
                .and().status_is_ok()
                .and().body_is_correct();
    }

    @Test
    public void given_create_Person_throws_exception() {
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
    public void given_Person_can_be_found() {
        given().person()
                .and().person_can_be_found();
        when().creating_Controller()
                .and().calling_find_person();
        then().personenservice_is_called()
                .and().status_is_ok()
                .and().body_is_correct();
    }

    @Test
    public void given_Person_cannot_be_found() {
        given().person_cannot_be_found();
        when().creating_Controller()
                .and().calling_find_person();
        then().personenservice_is_called()
                .and().status_is_NOT_FOUND()
                .and().body_is_empty();
    }

    @Test
    public void given_find_Person_throws_exception() {
        given().find_person_throws_exception();
        when().creating_Controller()
                .and().calling_find_person();
        then().personenservice_is_called()
                .and().status_is_INTERNAL_SERVER_ERROR()
                .and().body_is_empty();
    }


    protected static class GivenStatement extends Stage<GivenStatement> {

        @ProvidedScenarioState
        Shop shop = mock(Shop.class);

        @ProvidedScenarioState
        Person person;

        @ProvidedScenarioState
        PersonRepresentation personRepresentation;

        GivenStatement person_can_be_created() {
            BDDMockito.given(shop.createPerson(any(Person.class))).willReturn(person);
            return self();
        }

        GivenStatement person() {
            person = Person.builder().id(ID).vorname(VORNAME).name(NAME).adresses(List.of()).build();
            return self();
        }

        GivenStatement personRepresentation() {
            personRepresentation = PersonRepresentation.builder()
                    .vorname(VORNAME)
                    .name(NAME)
                    .build();
            return self();
        }

        GivenStatement create_person_throws_exception() {
            BDDMockito.given(shop.createPerson(any(Person.class))).willThrow(IllegalStateException.class);
            return self();
        }

        GivenStatement person_can_be_found() {
            BDDMockito.given(shop.findPerson(anyInt())).willReturn(Optional.of(person));
            return self();
        }

        GivenStatement person_cannot_be_found() {
            BDDMockito.given(shop.findPerson(anyInt())).willReturn(Optional.empty());
            return self();
        }

        GivenStatement find_person_throws_exception() {
            BDDMockito.given(shop.findPerson(anyInt())).willThrow(IllegalStateException.class);
            return self();
        }
    }

    protected static class WhenAction extends Stage<WhenAction> {

        @ProvidedScenarioState
        ResponseEntity<PersonRepresentation> result;
        @ExpectedScenarioState
        Shop shop;

        @ExpectedScenarioState
        PersonRepresentation personRepresentation;

        ShopController cut;

        WhenAction creating_Controller() {
            cut = new ShopController(shop);
            return self();
        }

        WhenAction calling_create() {
            result = cut.create(personRepresentation);
            return self();
        }

        WhenAction calling_find_person() {
            result = cut.findPerson(ID);
            return self();
        }

    }

    protected static class ThenOutcome extends Stage<ThenOutcome> {

        @ExpectedScenarioState
        Shop shop;

        @ExpectedScenarioState
        ResponseEntity<PersonRepresentation> result;

        @ExpectedScenarioState
        Person person;

        ThenOutcome personenService_is_called() {
            var person = Person.builder()
                    .vorname(VORNAME)
                    .name(NAME)
                    .build();
            verify(shop).createPerson(person);
            return self();
        }

        ThenOutcome status_is_ok() {
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
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

        ThenOutcome status_is_INTERNAL_SERVER_ERROR() {
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
            return self();
        }

        ThenOutcome status_is_NOT_FOUND() {
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
            return self();
        }

        ThenOutcome body_is_empty() {
            assertThat(result.hasBody()).isFalse();
            return self();
        }

        ThenOutcome personenservice_is_called() {
            verify(shop).findPerson(ID);
            return self();
        }

    }
}
