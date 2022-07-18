package de.conciso.starter;

import java.util.Collection;
import java.util.Optional;

public interface Produkte {

  Produkt erzeuge(int id, String name, long preis, Collection<Zutat> zutaten);

  Optional<Produkt> findById(int id);
}
