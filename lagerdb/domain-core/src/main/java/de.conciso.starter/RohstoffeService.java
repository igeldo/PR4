package de.conciso.starter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class RohstoffeService implements Rohstoffe {

    private static final Logger logger = LogManager.getLogger(RohstoffeService.class);

    private final RohstoffDAO rohstoffDAO;

    public RohstoffeService(RohstoffDAO rohstoffDAO) {
        this.rohstoffDAO = rohstoffDAO;
    }

    @Override
    public Rohstoff erzeuge(int id, String name, char code, String gebinde) {
        var rohstoff = new Rohstoff(id, name, code, gebinde);
        logger.info("create rohstoff: " + rohstoff.getName());
        return rohstoffDAO.save(rohstoff);
    }

    @Override
    public Optional<Rohstoff> findById(int id) {
        logger.info("looking for person with id: " + id);
        var found = rohstoffDAO.findById(id);
        if (found.isEmpty()) {
            logger.warn("no rohstoff found with id: " + id);
        }
        return found;
    }
}