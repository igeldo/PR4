package de.conciso.auftrag;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit5.ScenarioTest;
import de.conciso.auftrag.steps.GivenStatement;
import de.conciso.auftrag.steps.ThenOutcome;
import de.conciso.auftrag.steps.WhenAction;
import org.junit.jupiter.api.Test;

class AuftragControllerTest extends ScenarioTest<GivenStatement, WhenAction, ThenOutcome>{

    static final String BESTELL_NUMMER = "69420";
    static final int ID = 42;

    @Test
    public void given_Auftrag_can_be_created_when_calling_create() {
        given().auftragRepresentation(ID, BESTELL_NUMMER)
                .and().auftrag(ID,BESTELL_NUMMER)
                .and().auftrag_can_be_created();
        when().creating_Controller()
                .and().calling_create();
        then().auftraegeService_is_called()
                .and().status_is_OK()
                .and().body_is_correct();
    }

    @Test
    public void given_Auftrag_can_be_found_when_calling_findById(){
        given().auftragRepresentation(ID,BESTELL_NUMMER)
                .and().auftrag(ID,BESTELL_NUMMER)
                .and().auftrag_can_be_found();
        when().creating_Controller()
                .and().calling_findById(ID);
        then().auftraegeService_is_called_findById(ID)
                .and().status_is_OK()
                .and().body_is_correct();
    }

    @Test
    public void given_Auftrag_cannot_be_found_when_calling_findById(){
        given().auftragRepresentation(ID,BESTELL_NUMMER)
                .and().auftrag(ID,BESTELL_NUMMER)
                .and().auftrag_cannot_be_found();
        when().creating_Controller()
                .and().calling_findById(ID);
        then().auftraegeService_is_called_findById(ID)
                .and().status_is_NOT_FOUND()
                .and().body_is_empty();
    }
}
