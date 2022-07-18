package de.conciso.starter;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataProduktDAO extends ProduktDAO, CrudRepository<Produkt, Integer> {
}
