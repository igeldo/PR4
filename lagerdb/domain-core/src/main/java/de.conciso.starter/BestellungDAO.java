package de.conciso.starter;

import java.util.Optional;

public interface BestellungDAO {
    Bestellung save(Bestellung bestellung);
    Optional<Bestellung> findById(int id);
}
