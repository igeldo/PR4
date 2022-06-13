package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import de.conciso.auftrag.AuftragRepresentation;
import org.assertj.core.api.Assertions;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;

public class ThenOutcome extends Stage<ThenOutcome>{

    @ExpectedScenarioState
    Auftraege auftraege;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Auftrag testAuftrag;

    @ExpectedScenarioState
    ResponseEntity<AuftragRepresentation> result;

    public ThenOutcome auftraegeService_is_called(){
        verify(auftraege).create(testAuftrag);
        return self();
    }
}