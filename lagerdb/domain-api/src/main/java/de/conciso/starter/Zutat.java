package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Zutat  {
  //composite key in jpa
  // https://www.baeldung.com/jpa-composite-primary-keys
  @EmbeddedId
  PRID prid;

  @ManyToOne
  @MapsId("produkt")
  @JoinColumn(name = "produkt_id")
  Produkt produkt;

  @ManyToOne
  @MapsId("rohstoff")
  @JoinColumn(name = "rohstoff_id")
  Rohstoff rohstoff;

  int menge;
}
