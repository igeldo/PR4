package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bestellung {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  @OneToOne
  Produkt produkt;
  //int produktId;
  int anzahl;
  Bestellstatus status;

  public Bestellung(Produkt produkt, int anzahl) {
    //this.produktId = produktId;
    this.produkt = produkt;
    this.anzahl = anzahl;
    this.status = Bestellstatus.WARTEN_AUF_ROHSTOFFE;
  }
}
