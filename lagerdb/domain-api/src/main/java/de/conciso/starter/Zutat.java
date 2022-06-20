package de.conciso.starter;

import lombok.Data;

@Data
@Entity
public class Zutat {
  int rohstoffId;
  int menge;

  public Zutat(Object zutat) {
    if (zutat instanceof Zutat) {
      this = zutat;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public Zutat(int rohstoffId, int menge) {
    this.setRohstoffId(rohstoffId);
    this.setMenge(menge);
  }

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
