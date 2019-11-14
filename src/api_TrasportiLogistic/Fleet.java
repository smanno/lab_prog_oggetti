package api_TrasportiLogistic;

import java.time.LocalDateTime;
import java.util.*;

/**
 * STATO ASTRATTO
 * insieme di autocarri senza duplicati
 */
public class Fleet {

    Set<Truck> theTrucks = new TreeSet<>();

    // INVARIANTE
    // theTrucks non è NULL

    /**
     * Trova i camion che possono essere usati per il viaggio
     * a seconda del tipo/quantità di merce
     * liberi da departure ad arrival
     * disponibili nel luogo per la partenza FUCK I HAVE TRUCK MAGIC
     * @param goods
     * @param quantity
     * @return
     */
    public List<Truck> findTrucks(LocalDateTime departure, GoodsKind goods, Double quantity) {
    }
}
