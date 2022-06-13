package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.Auftraege;
import de.conciso.auftrag.Auftrag;
import de.conciso.auftrag.AuftragController;
import de.conciso.auftrag.AuftragRepresentation;
import org.mockito.BDDMockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GivenStatement extends Stage<GivenStatement>{

    @ProvidedScenarioState
    private static final String BESTELL_NUMMER = "4711";

    @ProvidedScenarioState
    private static final int ID = 42;

    @ProvidedScenarioState
    Auftraege auftraege = mock(Auftraege.class);

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Auftrag testAuftragWithId;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Auftrag testAuftrag;

    @ProvidedScenarioState
    AuftragRepresentation testAuftragRepresentation;




    public GivenStatement auftrag_can_be_created(){
        BDDMockito.given(auftraege.create(any(Auftrag.class))).willReturn(testAuftrag);
        return self();
    }

    public GivenStatement auftrag(int id, String bestellnummer){
        testAuftrag = new Auftrag(id, bestellnummer);
        return self();
    }

    public GivenStatement auftragRepresentation(int id, String bestellnummer){
        testAuftragRepresentation = AuftragRepresentation.builder().id(id).bestellNummer(bestellnummer).build();
        return self();
    }
}