package de.conciso.auftrag;

import com.tngtech.jgiven.junit.ScenarioTest;
import de.conciso.auftrag.steps.GivenStatement;
import de.conciso.auftrag.steps.ThenOutcome;
import de.conciso.auftrag.steps.WhenAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AuftragControllerTest extends ScenarioTest<GivenStatement, WhenAction, ThenOutcome>{




/*

    private static String BESTELL_NUMMER;

    private static int ID;

    Auftraege auftraege;

    AuftragController cut;

    private Auftrag testAuftragWithId;

    private Auftrag testAuftrag;



    private AuftragRepresentation testAuftragRepresentation;
    private Auftrag testAuftrag;
    private AuftragRepresentation expectedAuftragRepresentation;

    @BeforeEach
    void arrange() {
        testAuftragRepresentation = AuftragRepresentation.builder()
                .bestellNummer(BESTELL_NUMMER)
                .build();
        testAuftrag = new Auftrag(BESTELL_NUMMER);
        testAuftragWithId = new Auftrag(ID, BESTELL_NUMMER);
        expectedAuftragRepresentation = AuftragRepresentation.builder()
                .id(ID)
                .bestellNummer(BESTELL_NUMMER)
                .artikel(List.of())
                .build();
    }

 */


    @Test
    public void Given_Auftrag_can_be_created_When_calling_create_then_AuftraegeService_is_called() {
        given().Auftrag_can_be_created();
        when().calling_create();
        then().AuftraegeService_is_called();
    }
}