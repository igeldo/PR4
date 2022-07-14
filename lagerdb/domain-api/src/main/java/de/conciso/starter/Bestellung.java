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
public class Bestellung {

  @Id
  private int id;
  Produkt produkt;
  int anzahl;
  Bestellstatus status;

}
