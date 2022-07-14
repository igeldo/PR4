package de.conciso.starter;

import java.util.Optional;

public interface Rohstoffe {

  Rohstoff erzeuge(int id, String name, char code, String gebinde);

  Optional<Rohstoff> findById(int id);
}
