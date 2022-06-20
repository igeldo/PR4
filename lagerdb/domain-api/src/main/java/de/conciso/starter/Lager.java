package de.conciso.starter;

import lombok.Data;

@Data
@Entity
public class Lager {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  int id;

  String ort;
  char code;
  int kapazitaet;

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public String getOrt() {
    return this.ort;
  }

  public void setCode(char code) {
    this.code = code;
  }

  public char getCode() {
    return this.code;
  }

  public void setKapazitaet(int kapazitaet) {
    this.kapazitaet = kapazitaet;
  }

  public int getKapazitaet() {
    return this.kapazitaet;
  }

  public int getId() {
    return this.id;
  }
}
