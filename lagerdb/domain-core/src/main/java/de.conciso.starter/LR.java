package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(LRID.class)
public class LR {
    @Id
    private int lagerId;
    @Id
    private int rohstoffId;

    private int menge;
//    private double bwert;
}