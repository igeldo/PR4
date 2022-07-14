package de.conciso.starter;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataRohstoffDAO extends RohstoffDAO, CrudRepository<Rohstoff, Integer> {
}
