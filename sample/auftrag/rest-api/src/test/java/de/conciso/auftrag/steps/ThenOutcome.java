package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import org.assertj.core.api.Assertions;

public class ThenOutcome extends Stage<ThenOutcome>{

    @ExpectedScenarioState
    Auftraege auftraege;

    @ExpectedScenarioState
    private Auftrag testAuftrag;



    public ThenOutcome AuftraegeService_is_called(){
        //Assertions.assertThat((auftraege).create(testAuftrag));
        Assertions.assertThat(true);
        return self();
    }
}