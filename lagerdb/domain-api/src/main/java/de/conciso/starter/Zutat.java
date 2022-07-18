package de.conciso.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zutat implements Serializable {
  //composite key in jpa
  // https://www.baeldung.com/jpa-composite-primary-keys
  int rohstoffId;
  int produktId;
  int menge;

}
