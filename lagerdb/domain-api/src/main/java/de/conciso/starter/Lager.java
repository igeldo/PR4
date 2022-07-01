package de.conciso.starter;

import lombok.Data;

@Data
public class Lager {

  int id;
  String ort;
  char code;
  int kapazitaet;

  public Lager(Lager lager) {
    this = lager;
  }

  public Lager(int id, String ort, char code, int kapazitaet) {
    setId(id);
    setOrt(ort);
    setCode(code);
    setKapazitaet(kapazitaet);
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public void setCode(char code) {
    this.code = code;
  }

  public void setKapazitaet(int kapazitaet) {
    this.kapazitaet = kapazitaet;
  }

  public int getId() {
    return id;
  }

  public String getOrt() {
    return ort;
  }

  public char getCode() {
    return code;
  }

  public int getKapazitaet() {
    return kapazitaet;
  }
}
