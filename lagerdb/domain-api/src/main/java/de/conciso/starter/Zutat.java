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
@Entity
@IdClass(ZutatId.class)
public class Zutat implements Serializable {
  //composite key in jpa
  // https://www.baeldung.com/jpa-composite-primary-keys
  @Id
  int rohstoffId;
  @Id
  int produktId;
  int menge;

}
