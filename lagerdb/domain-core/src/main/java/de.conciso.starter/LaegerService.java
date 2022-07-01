package de.conciso.starter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaegerService implements Laeger {

    private static final Logger logger = LogManager.getLogger(LaegerService.class);

    private final LagerDAO lagerDAO;

    public LagerService(LagerDAO lagerDAO) {
        this.lagerDAO = lagerDAO;
    }

    @Override
    public Lager create(Lager lager) {
        logger.info("create lager " + lager.getName());
        return lagerDAO.save(Lager);
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
}