package de.conciso.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BestellungenService implements Bestellungen {

    private static final Logger logger = LogManager.getLogger(BestellungenService.class);

    private final BestellungDAO bestellungDAO;

    public BestellungenService(BestellungDAO bestellungDAO) {
        this.bestellungDAO = bestellungDAO;
    }

    @Override
    public Bestellung bestelle(String kunde, int produktId, int anzahl, Bestellstatus status) {
        var bestellung = new Bestellung(produktId, anzahl, status);
        logger.info("create Bestellung: " + bestellung.getProduktId() + " for " + kunde);
        return bestellungDAO.save(bestellung);
    }

    @Override
    public Optional<Bestellung> findById(int id) {
        logger.info("looking for bestellung with id: " + id);
        var found = bestellungDAO.findById(id);
        if (found.isEmpty()) {
            logger.warn("no bestellung found with id: " + id);
        }
        return found;
    }
}