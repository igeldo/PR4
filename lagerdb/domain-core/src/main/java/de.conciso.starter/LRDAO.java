package de.conciso.starter;

import java.util.Optional;

public interface LRDAO {
    LR save(LR lr);
    Optional<LR> findById(int lagerId, int rohstoffId);
}
