package de.conciso.starter;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produkt {

  @Id
  private int id;
  String name;
  long preis;
  @ManyToMany(cascade = CascadeType.ALL)
  Collection<Zutat> zutaten;

  public void addZutaten(Zutat zutat){
    zutaten.add(zutat);
  }

}
