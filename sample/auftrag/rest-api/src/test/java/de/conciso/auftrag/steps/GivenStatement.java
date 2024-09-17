package de.conciso.auftrag.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import de.conciso.auftrag.*;
import org.mockito.BDDMockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GivenStatement extends Stage<GivenStatement> {

    @ProvidedScenarioState
    Auftraege auftraege = mock(Auftraege.class);

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    Auftrag testAuftragWithId;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    Auftrag testAuftrag;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    AuftragRepresentation testAuftragRepresentation;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    AuftragRepresentation expectedAuftragRepresentation;


    public GivenStatement auftrag_can_be_created() {
        BDDMockito.given(auftraege.create(any(Auftrag.class))).willReturn(testAuftrag);
        return self();
    }

    public GivenStatement auftrag_can_be_found() {
        BDDMockito.given(auftraege.findById(anyInt())).willReturn(Optional.of(testAuftrag));
        return self();
    }

    public GivenStatement auftrag_cannot_be_found() {
        BDDMockito.given(auftraege.findById(anyInt())).willReturn(Optional.empty());
        return self();
    }

    public GivenStatement auftrag(int id, String bestellnummer) {
        testAuftrag = new Auftrag(id, bestellnummer);
        return self();
    }

    public GivenStatement auftragRepresentation(int id, String bestellnummer) {
        testAuftragRepresentation = AuftragRepresentation.builder().id(id).bestellNummer(bestellnummer).build();
        expectedAuftragRepresentation = AuftragRepresentation.builder().id(id).bestellNummer(bestellnummer).artikel(List.of()).build();
        return self();
    }
}