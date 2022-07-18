package de.conciso.starter;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataBestellungDAO extends BestellungDAO, CrudRepository<Bestellung, Integer> {
}