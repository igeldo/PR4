package de.conciso.starter;

import java.util.Collection;

import lombok.Data;

@Data
public class Produkt {

  int id;
  String name;
  long preis;
  Collection<Zutat> zutaten;

  public Produkt(Produkt produkt) {
    this = produkt;
  }

  public Produkt(int id, String name, long preis, Collection<Zutat> zutaten) {
    setId(id);
    setName(name);
    setPreis(preis);
    setZutaten(zutaten);
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPreis(long preis) {
    this.preis = preis;
  }

  public void setZutaten(Collection<Zutat> zutaten) {
    this.zutaten = zutaten;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public long getPreis() {
    return preis;
  }

  public Collection<Zutat> getZutaten() {
    return zutaten;
  }
}
