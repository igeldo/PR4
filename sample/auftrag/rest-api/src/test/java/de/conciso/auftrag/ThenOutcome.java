package de.conciso.auftrag;

import com.tngtech.jgiven.Stage;

public class ThenOutcome extends Stage<ThenOutcome>{
    public ThenOutcome outcome(){
        return self();
    }
}