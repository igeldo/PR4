package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zutat  {
  //composite key in jpa
  // https://www.baeldung.com/jpa-composite-primary-keys
  int rohstoffId;
  int produktId;
  int menge;
}
