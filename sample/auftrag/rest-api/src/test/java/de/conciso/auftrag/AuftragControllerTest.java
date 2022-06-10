package de.conciso.auftrag;

import com.tngtech.jgiven.junit.ScenarioTest;
import de.conciso.auftrag.steps.GivenStatement;
import de.conciso.auftrag.steps.ThenOutcome;
import de.conciso.auftrag.steps.WhenAction;
import org.junit.jupiter.api.Test;

class AuftragControllerTest extends ScenarioTest<GivenStatement, WhenAction, ThenOutcome>{
    /*
    private static final String BESTELL_NUMMER = "someBestellNummer";

    private static final int ID = 42;

    @ProvidedScenarioState
    Auftraege auftraege;

    @ProvidedScenarioState
    AuftragController cut;

     */
    @Test
    public void Given_Auftrag_can_be_created_When_calling_create_then_AuftraegeService_is_called() {
        given().Given_Auftrag_can_be_created();
        when().When_calling_create();
        then().then_AuftraegeService_is_called();
    }
}


