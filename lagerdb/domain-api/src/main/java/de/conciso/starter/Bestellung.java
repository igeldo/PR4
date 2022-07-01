package de.conciso.starter;

import lombok.Data;

@Data
public class Bestellung {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  Produkt produkt;
  int anzahl;
  Bestellstatus status;

  public Bestellung (Produkt produkt, int anzahl, Bestellstatus status) {
      setProdukt(produkt);
      setAnzahl(anzahl);
      setStatus(status);
  }

  public int getId() {
    return id;
  }

  public void setProdukt(Produkt produkt) {
    this.produkt = produkt;
  }

  public Produkt getProdukt() {
    return produkt;
  }

  public void setAnzahl(int anzahl) {
    this.anzahl = anzahl;
  }

  public int getAnzahl() {
    return anzahl;
  }

  public void setStatus(Bestellstatus status) {
    this.status = status;
  }

  public Bestellstatus getStatus() {
    return status;
  }
}
