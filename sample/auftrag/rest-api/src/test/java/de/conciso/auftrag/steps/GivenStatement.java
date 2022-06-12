package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import de.conciso.auftrag.AuftragController;

import java.util.Optional;

public class GivenStatement extends Stage<GivenStatement>{

    @ProvidedScenarioState
    private static final String BESTELL_NUMMER = "4711";

    @ProvidedScenarioState
    private static final int ID = 42;

    @ProvidedScenarioState
    Auftraege auftraege = new Auftraege() {
        @Override
        public Auftrag create(Auftrag auftrag) {
            return auftrag;
        }

        @Override
        public Optional<Auftrag> findById(int id) {
            return Optional.empty();
        }
    };

    @ProvidedScenarioState
    AuftragController cut;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Auftrag testAuftragWithId;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Auftrag testAuftrag;




    public GivenStatement auftrag_can_be_created(){

        testAuftrag = new Auftrag(BESTELL_NUMMER);
        testAuftragWithId = new Auftrag(ID, BESTELL_NUMMER);
        auftraege.create(testAuftragWithId);
        return self();
    }
}