package de.conciso.starter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LaegerService implements Laeger {

    private static final Logger logger = LogManager.getLogger(LaegerService.class);

    private final LagerDAO lagerDAO;

    private final LRDAO lrDAO;

    public LaegerService(LagerDAO lagerDAO, LRDAO lrDAO) {
        this.lrDAO = lrDAO;
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
        logger.info("looking for relation: " + lagerId + " to " + rohstoffId);
        var found = lrDAO.findById(lagerId, rohstoffId);
        if (found.isEmpty()) {
            logger.info("New relation created");
            lrDAO.save(new LR(lagerId, rohstoffId, menge));
        } else {
            logger.info("Relation does exist, updating");
            found.setMenge(found.getMenge() + menge);
        }
    }
}