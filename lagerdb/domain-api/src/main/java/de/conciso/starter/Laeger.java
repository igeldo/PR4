package de.conciso.starter;

import java.util.Optional;

public interface Laeger {

  Lager erzeuge(int id, String ort, char code, int kapazitaet);

  Optional<Lager> findById(int id);

  // um ins Lager hinzuzufügen nach LagerId
  void lagereEin(int lagerId, int rohstoffId, int menge);
}
