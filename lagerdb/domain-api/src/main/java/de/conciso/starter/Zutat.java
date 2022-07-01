package de.conciso.starter;

import lombok.Data;

@Data
public class Zutat {
  int rohstoffId;
  int menge;

  public Zutat(Zutat zutat) {
    this = zutat;
  }

  public Zutat(int rohstoffId, int menge) {
    setRohstoffId(rohstoffId);
    setMenge(menge);
  }

  public void setRohstoffId(int rohstoffId) {
    this.rohstoffId = rohstoffId;
  }

  public void setMenge(int menge) {
    this.menge = menge;
  }

  public int getRohstoffId() {
    return rohstoffId;
  }

  public int getMenge() {
    return menge;
  }
}
