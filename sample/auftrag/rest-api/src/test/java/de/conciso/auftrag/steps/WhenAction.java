package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.AuftragController;
import de.conciso.auftrag.AuftragRepresentation;
import org.springframework.http.ResponseEntity;


public class WhenAction extends Stage<WhenAction>{

    @ExpectedScenarioState
    Auftraege auftraege;

    @ExpectedScenarioState
    AuftragController cut = new AuftragController(auftraege);

    private AuftragRepresentation testAuftragRepresentation;


    public WhenAction calling_create(){
        ResponseEntity<AuftragRepresentation> result;
        result = cut.create(testAuftragRepresentation);

        return self();
    }
}