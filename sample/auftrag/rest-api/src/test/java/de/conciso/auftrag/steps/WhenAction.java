package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.AuftragController;
import de.conciso.auftrag.AuftragRepresentation;
import org.springframework.http.ResponseEntity;


public class WhenAction extends Stage<WhenAction>{

    @ExpectedScenarioState
    Auftraege auftraege;

    AuftragController cut = new AuftragController(auftraege);

    @ExpectedScenarioState
    private AuftragRepresentation testAuftragRepresentation;

    @ProvidedScenarioState
    ResponseEntity<AuftragRepresentation> result;

    public WhenAction calling_create(){
        cut = new AuftragController(auftraege);
        result = cut.create(testAuftragRepresentation);

        return self();
    }
}