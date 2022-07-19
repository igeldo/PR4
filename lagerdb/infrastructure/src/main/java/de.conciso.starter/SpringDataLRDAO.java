package de.conciso.starter;

import org.springframework.data.repository.CrudRepository;

public interface SpringDataLRDAO extends LRDAO, CrudRepository<LR, Integer> {
}