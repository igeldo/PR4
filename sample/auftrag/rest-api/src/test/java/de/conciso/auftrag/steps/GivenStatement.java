package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import de.conciso.auftrag.AuftragController;

public class GivenStatement extends Stage<GivenStatement>{

    @ProvidedScenarioState
    private static String BESTELL_NUMMER = "someBestellNummer";

    @ProvidedScenarioState
    private static int ID = 42;

    @ProvidedScenarioState
    Auftraege auftraege;

    @ProvidedScenarioState
    AuftragController cut;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    Auftrag testAuftragWithId;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    Auftrag testAuftrag;




    public GivenStatement Auftrag_can_be_created(){
        testAuftrag = new Auftrag(BESTELL_NUMMER);
        testAuftragWithId = new Auftrag(ID, BESTELL_NUMMER);
        auftraege.create(testAuftragWithId);
        return self();
    }
}