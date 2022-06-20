package de.conciso.starter;

import lombok.Data;

@Data
@Entity
public class Zutat {
  int rohstoffId;
  int menge;

  public void setRohstoffId(int rohstoffId) {
    this.rohstoffId = rohstoffId;
  }

  public int getRohstoffId() {
    return this.rohstoffId;
  }

  public void setMenge(int menge) {
    this.menge = menge;
  }

  public int getMenge() {
    return this.menge;
  }
}
