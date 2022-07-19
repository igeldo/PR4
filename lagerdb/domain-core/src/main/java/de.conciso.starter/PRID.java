package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PRID implements Serializable {

    @Column(name = "produkt_id")
    private int produktId;

    @Column(name = "rohstoff_id")
    private int rohstoffId;
}