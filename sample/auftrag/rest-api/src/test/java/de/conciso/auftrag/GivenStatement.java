package de.conciso.auftrag;

import com.tngtech.jgiven.Stage;

public class GivenStatement extends Stage<GivenStatement>{
    public GivenStatement statement(){
        return self();
    }
}