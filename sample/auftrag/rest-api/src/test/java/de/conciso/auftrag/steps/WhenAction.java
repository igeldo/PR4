package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.AuftragController;
import de.conciso.auftrag.AuftragRepresentation;
import org.springframework.http.ResponseEntity;

public class WhenAction extends Stage<WhenAction>{
    /*
    @ScenarioState
    AuftragController cut;

    @ScenarioState
    private static final String BESTELL_NUMMER = "someBestellNummer";

    private AuftragRepresentation testAuftragRepresentation;

*/
    public WhenAction When_calling_create(){
        /*testAuftragRepresentation = AuftragRepresentation.builder()
                .bestellNummer(BESTELL_NUMMER)
                .build();
        ResponseEntity<AuftragRepresentation> result;
        result = cut.create(testAuftragRepresentation);
         */
        return self();
    }
}