package de.conciso.starter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LaegerService implements Laeger {

    private static final Logger logger = LogManager.getLogger(LaegerService.class);

    private final LagerDAO lagerDAO;

    public LaegerService(LagerDAO lagerDAO) {
        this.lagerDAO = lagerDAO;
    }

    @Override
    public Lager erzeuge(int id, String ort, char code, int kapazitaet) {
        var lager = new Lager(id, ort,code, kapazitaet);
        logger.info("create lager " + lager.getCode());
        return lagerDAO.save(lager);
    }

    @Override
    public Optional<Lager> findById(int id) {
        logger.info("looking for lager with id: " + id);
        var found = lagerDAO.findById(id);
        if (found.isEmpty()) {
            logger.warn("no lager found with id: " + id);
        }
        return found;
    }

    @Override
    public void lagereEin(int lagerId, int rohstoffId, int menge){

    }
}