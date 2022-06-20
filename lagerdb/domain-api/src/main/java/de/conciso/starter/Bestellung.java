package de.conciso.starter;

import lombok.Data;

@Data
public class Bestellung {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  int id;

  Produkt produkt;
  int anzahl;
  Bestellstatus status;

  public Bestellung(Produkt produkt, int anzahl, Bestellstatus status) {
    this.setProdukt(produkt);
    this.setAnzahl(anzahl);
    this.setStatus(status);
  }

  public int getId() {
    return this.id;
  }

  public void setProdukt(Produkt produkt) {
    this.produkt = produkt;
  }

  public int getProduktId() {
    return this.produkt.getId();
  }

  public void setAnzahl(int anzahl) {
    this.anzahl = anzahl;
  }

  public int getAnzahl() {
    return this.anzahl;
  }

  public void setStatus(Bestellstatus status) {
    this.status = status;
  }

  public Bestellstatus getStatus() {
    return this.status;
  }
}
