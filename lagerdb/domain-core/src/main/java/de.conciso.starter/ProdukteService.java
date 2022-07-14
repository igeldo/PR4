package de.conciso.starter;

import java.util.Collection;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ProdukteService implements Produkte {

    private static final Logger logger = LogManager.getLogger(ProdukteService.class);

    private final ProduktDAO produktDAO;

    public ProdukteService(ProduktDAO produktDAO) {
        this.produktDAO = produktDAO;
    }

    @Override
    public Produkt erzeuge(int id, String name, long preis, Collection<Zutat> zutaten) {
        var produkt = new Produkt(id, name, preis, zutaten);
        logger.info("create produkt " + produkt.getName());
        return produktDAO.save(produkt);
    }

    @Override
    public Optional<Produkt> findById(int id) {
        logger.info("looking for lager with id: " + id);
        var found = produktDAO.findById(id);
        if (found.isEmpty()) {
            logger.warn("no lager found with id: " + id);
        }
        return found;
    }
}