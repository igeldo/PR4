package de.conciso.starter;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produkt {

  @Id
  private int id;
  String name;
  long preis;
  Collection<Zutat> zutaten;

}
