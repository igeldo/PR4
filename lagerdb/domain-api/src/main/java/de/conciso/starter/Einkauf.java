package de.conciso.starter;

public class Einkauf {

  Rohstoff rohstoff;
  int menge;

  public Einkauf (Rohstoff rohstoff, int menge) {
    setRohstoff(rohstoff);
    setMenge(menge);
  }

  public void setRohstoff(Rohstoff rohstoff) {
    this.rohstoff = rohstoff;
  }

  public Rohstoff getRohstoff() {
    return rohstoff;
  }

  public void setMenge(int menge) {
    this.menge = menge;
  }

  public int getMenge() {
    return menge;
  }
}
