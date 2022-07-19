package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "pr")
@NoArgsConstructor
@AllArgsConstructor
public class Zutat  {
  //composite key in jpa
  // https://www.baeldung.com/jpa-composite-primary-keys
  @EmbeddedId
  PRID prid;

  @ManyToOne
  @MapsId("produktId")
  @JoinColumn(name = "produkt_id")
  Produkt produkt;

  @ManyToOne
  @MapsId("rohstoffId")
  @JoinColumn(name = "rohstoff_id")
  Rohstoff rohstoff;

  int menge;
}
