package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import de.conciso.auftrag.AuftragRepresentation;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class ThenOutcome extends Stage<ThenOutcome> {

    @ExpectedScenarioState
    Auftraege auftraege;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    Auftrag testAuftrag;

    @ExpectedScenarioState
    ResponseEntity<AuftragRepresentation> result;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    AuftragRepresentation expectedAuftragRepresentation;


    public ThenOutcome auftraegeService_is_called() {
        verify(auftraege).create(testAuftrag);
        return self();
    }

    public ThenOutcome status_is_OK() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        return self();
    }

    public ThenOutcome status_is_NOT_FOUND() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        return self();
    }

    public ThenOutcome body_is_correct() {
        assertThat(result.getBody()).isEqualTo(expectedAuftragRepresentation);
        return self();
    }

    public ThenOutcome body_is_empty() {
        assertThat(result.hasBody()).isFalse();
        return self();
    }

    public ThenOutcome auftraegeService_is_called_findById(int id) {
        verify(auftraege).findById(id);
        return self();
    }

}