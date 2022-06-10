package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import de.conciso.auftrag.AuftragController;

public class GivenStatement extends Stage<GivenStatement>{
    /*
    @ScenarioState
    private static final String BESTELL_NUMMER = "someBestellNummer";
    private static final int ID = 42;
    @ScenarioState
    Auftraege auftraege;

    @ScenarioState
    AuftragController cut;

    private Auftrag testAuftragWithId;

     */

    public GivenStatement Given_Auftrag_can_be_created(){
        /*
        testAuftragWithId = new Auftrag(ID, BESTELL_NUMMER);
                //auftraege.create(any(Auftrag.class)).willReturn(testAuftragWithId);
        auftraege.create(testAuftragWithId);

         */
        return self();
    }
}