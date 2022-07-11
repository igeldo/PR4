package de.conciso.starter;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataLagerDAO extends LagerDAO, CrudRepository<Lager, Integer> {
    //
}