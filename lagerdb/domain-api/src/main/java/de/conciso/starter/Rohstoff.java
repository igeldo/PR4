package de.conciso.starter;

import lombok.Data;

@Data
public class Rohstoff {

  int id;
  String name;
  char code;
  String gebinde;

  public Rohstoff (int id, String name, char code, String gebinde){
    setId(id);
    setName(name);
    setCode(code);
    setGebinde(gebinde);
  }
  public void setId (int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setCode(char code) {
    this.code = code;
  }

  public char getCode() {
    return code;
  }

  public String getGebinde() {
    return gebinde;
  }

  public void setGebinde(String gebinde) {
    this.gebinde = gebinde;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
