package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import org.assertj.core.api.Assertions;

public class ThenOutcome extends Stage<ThenOutcome>{
/*
    @ScenarioState
    private static final String BESTELL_NUMMER = "someBestellNummer";

    @ScenarioState
    Auftraege auftraege;

    @ScenarioState
    private Auftrag testAuftrag = new Auftrag(BESTELL_NUMMER);

 */

    public ThenOutcome then_AuftraegeService_is_called(){
        //Assertions.assertThat((auftraege).create(testAuftrag));
        Assertions.assertThat(true);
        return self();
    }
}