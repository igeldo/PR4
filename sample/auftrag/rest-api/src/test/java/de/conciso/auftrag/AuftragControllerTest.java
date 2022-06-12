package de.conciso.auftrag;

import com.tngtech.jgiven.junit5.ScenarioTest;
import de.conciso.auftrag.steps.GivenStatement;
import de.conciso.auftrag.steps.ThenOutcome;
import de.conciso.auftrag.steps.WhenAction;
import org.junit.jupiter.api.Test;

class AuftragControllerTest extends ScenarioTest<GivenStatement, WhenAction, ThenOutcome>{

    @Test
    public void given_Auftrag_can_be_created_When_calling_create_then_AuftraegeService_is_called() {
        given().auftrag_can_be_created();
        when().calling_create();
        then().auftraegeService_is_called();
    }
}
