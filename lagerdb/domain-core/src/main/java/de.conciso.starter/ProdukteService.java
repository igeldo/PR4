package de.conciso.starter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdukteService implements Produkte {

    private static final Logger logger = LogManager.getLogger(ProdukteService.class);

    private final ProduktDAO produktDAO;

    public ProdukteService(ProduktDAO produktDAO) {
        this.personDAO = produktDAO;
    }

    @Override
    public Produkt create(Person person) {
        logger.info("create person: " + person.getVorname() + " " + person.getName());
        return personDAO.save(person);
    }

    @Override
    public Optional<Person> findById(int id) {
        logger.info("looking for person with id: " + id);
        var found = personDAO.findById(id);
        if (found.isEmpty()) {
            logger.warn("no person found with id: " + id);
        }
        return found;
    }

    @Override
    @Transactional
    public Optional<Person> addAddress(int personId, Address address) {
        logger.info("adding address to person with id: " +personId);
        return findById(personId)
                .map(person -> {
                    person.addAddress(address);
                    return person;
                });
    }
}
