package de.conciso.starter;

import java.util.Collection;

import lombok.Data;

@Data
@Entity
public class Produkt {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  int id;

  String name;
  long preis;
  Collection<Zutat> zutaten;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setPreis(long preis) {
    this.preis = preis;
  }

  public long getPreis() {
    return this.preis;
  }

  public void setZutaten(Collection<Zutat> zutaten) {
    this.zutaten = zutaten;
  }

  public Collection<Zutat> getZutaten() {
    //return this.zutaten;
    return Collections.unmodifiableList(zutaten);
  }
}
