package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class ZutatId implements Serializable {
    int produktId;
    int rohstoffId;
}
