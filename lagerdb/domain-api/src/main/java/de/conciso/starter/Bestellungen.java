package de.conciso.starter;

import java.util.Optional;

public interface Bestellungen {

  Bestellung bestelle(String kunde, int produktId, int anzahl, Bestellstatus status);

  Optional<Bestellung> findById(int id);
}
