package de.conciso.starter;

import lombok.Data;

@Data
public class Rohstoff {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  String name;
  char code;
  String gebinde;

  public Rohstoff (String name, char code, String gebinde){
    setName(name);
    setCode(code);
    setGebinde(gebinde);
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
