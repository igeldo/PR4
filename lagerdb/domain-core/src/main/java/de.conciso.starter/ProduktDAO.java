package de.conciso.starter;

import java.util.Optional;

public interface ProduktDAO {
    Produkt save(Produkt produkt);
    Optional<Produkt> findById(int id);
}
