package api_TrasportiLogistic;

import java.util.Date;

/**
 * PARTIRE DA QUESTA CLASSE, sopratutto all'esame, perchè è il nocciolo dell'esercizio
 * facendo riferimento agli altri TIpi di Dati Astratti
 *
 * è MUTABILE perchè mantiene un elenco di viaggi/prenotazioni/percorsi *
 * ---Caratterizzato da:
 * elenco percorsi
 * elenco prenotazioni
 * flotta
 * // cliente // non richiesto dall'esercizio
 * // alla API non serve un utente (a meno che non sia richiesta un'autorizzazione <= situazione rara)
 *
 * inizializzare percorsi/flotta/merci
 * usare un'istanza per prenotare un nuovo viaggio
 *
 * ---Per usare l'API occorre:
 * tm = new TransportationManager()
 * tm.Initialize() // crea uno stato valido
 *
 * ---IPOTESI
 * tm.BookTrip()                    MAKER
 * tm.FindTripsTo(Location loc)     OBSERVER
 * tm.FindTripOnDate(Date d)        OBSERVER
 * tm.Reroute(Trip trip)            MODIFIER
 */
public class TransportationManager {

    /**
     *
     * @param arrival
     * @param merce
     * @param from
     * @param to
     */
    BookTrip(Date arrival, TipoMerce merce, quantity, Location from, Location to){}

    /**
     * crea una prenotazione, modifica le prenotazioni aggiungendo una prenotazione
     * tranne:
     * - non esiste un percorso che colleghi from e to
     * - non ci sono autocarri liberi per quella merce
     * - quantità merce eccessiva
     * - arrival <= departure (tengo conto del tempo)
     * - durata del viaggio non compatibile // departure + ETA > arrival
     * - arrival/departue in date festive
     * @param departure
     * @param arrival
     * @param merce
     * @param from
     * @param to
     */
    BookTrip(Date departure, Date arrival, TipoMerce merce, quantity, Location from, Location to){}
}
