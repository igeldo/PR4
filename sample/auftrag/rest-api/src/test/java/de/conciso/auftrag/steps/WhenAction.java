package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.AuftragController;
import de.conciso.auftrag.AuftragRepresentation;
import org.springframework.http.ResponseEntity;


public class WhenAction extends Stage<WhenAction>{

    @ExpectedScenarioState
    Auftraege auftraege;

    AuftragController cut;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    AuftragRepresentation testAuftragRepresentation;

    @ProvidedScenarioState
    ResponseEntity<AuftragRepresentation> result;

    public WhenAction calling_create(){
        result = cut.create(testAuftragRepresentation);
        return self();
    }

    public WhenAction calling_findById(int id){
        result = cut.findById(id);
        return self();
    }

    public WhenAction creating_Controller(){
        cut = new AuftragController(auftraege);
        return self();
    }
}