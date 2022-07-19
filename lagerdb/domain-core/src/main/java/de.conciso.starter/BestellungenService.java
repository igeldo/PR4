package de.conciso.starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class BestellungenService implements Bestellungen {

    private static final Logger logger = LogManager.getLogger(BestellungenService.class);

    private final BestellungDAO bestellungDAO;
    private final ProduktDAO produktDAO;

    public BestellungenService(BestellungDAO bestellungDAO, ProduktDAO produktDAO) {
        this.bestellungDAO = bestellungDAO;
        this.produktDAO = produktDAO;
    }

    @Override
    public Bestellung bestelle(String kunde, int produktId, int anzahl) {
        var produkt = produktDAO.findById(produktId).orElseThrow(); //Exception handling ergänzen
        var bestellung = new Bestellung(produkt, anzahl);
        logger.info("create Bestellung: " + bestellung.getId() +
                " for " + kunde + ". Status is " + bestellung.getStatus());
        // Ermittle Zutaten
        Collection<Zutat> zutaten = produkt.getZutaten();
        // Filtere Zutaten und Bedarf --> in Listen Packen
        ArrayList<Integer> rohstoffeID = new ArrayList<>();
        ArrayList<Integer> r_bedarf = new ArrayList<>();
        for (Zutat zutat : zutaten) {
            rohstoffeID.add(zutat.getRohstoff().getId());
            r_bedarf.add(zutat.getMenge() * anzahl);
        }
        // Schaue was vorhanden ist
        //...
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