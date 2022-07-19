package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class LRID implements Serializable {
    private int lagerId;
    private int rohstoffId;
}