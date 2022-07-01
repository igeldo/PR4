package de.conciso.starter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RohstoffeService implements Rohstoffe {

    private static final Logger logger = LogManager.getLogger(RohstoffeService.class);

    private final RohstoffDAO rohstoffDAO;

    public RohstoffeService(RohstoffDAO rohstoffDAO) {
        this.rohstoffDAO = rohstoffDAO;
    }

    @Override
    public Rohstoff create(Rohstoff rohstoff) {
        logger.info("create rohstoff: " + rohstoff.getName());
        return produktDAO.save(produkt);
    }

    @Override
    public Optional<Produkt> findById(int id) {
        logger.info("looking for person with id: " + id);
        var found = produktDAO.findById(id);
        if (found.isEmpty()) {
            logger.warn("no person found with id: " + id);
        }
        return found;
    }
}