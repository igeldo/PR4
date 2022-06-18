package de.conciso.starter;

import java.util.Optional;

public interface RohstoffDAO {
    Rohstoff save(Rohstoff rohstoff);
    Optional<Rohstoff> findById(int id);
}