package de.conciso.starter;

import lombok.Data;

@Data
@Entity
public class Rohstoff {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  String name;
  char code;
  String gebinde;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setCode(char code) {
    this.code = code;
  }

  public char getCode(){
    return this.code;
  }

  public void setGebinde(String gebinde) {
    this.gebinde = gebinde;
  }

  public String getGebinde() {
    return this.gebinde;
  }

  public int getId() {
    return this.id;
  }
}
