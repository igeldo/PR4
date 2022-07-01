package de.conciso.starter;

import lombok.Data;

@Data
public class Bestellung {

  int id;
  Produkt produkt;
  int anzahl;
  Bestellstatus status;

  public Bestellung (int id, Produkt produkt, int anzahl, Bestellstatus status) {
      setId(id);
      setProdukt(produkt);
      setAnzahl(anzahl);
      setStatus(status);
  }

  public void setId(int id) {
    this.id = id;
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
