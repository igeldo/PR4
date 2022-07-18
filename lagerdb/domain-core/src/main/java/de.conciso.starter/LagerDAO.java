package de.conciso.starter;

import java.util.Optional;

public interface LagerDAO {
    Lager save(Lager lager);
    Optional<Lager> findById(int id);
}
