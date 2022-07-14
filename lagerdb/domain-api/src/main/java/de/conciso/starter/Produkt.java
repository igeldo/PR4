package de.conciso.starter;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produkt {

  @Id
  private int id;
  String name;
  long preis;
  @OneToMany
  @JoinColumn(name="produktId", referencedColumnName = "id")
  Collection<Zutat> zutaten;

}
