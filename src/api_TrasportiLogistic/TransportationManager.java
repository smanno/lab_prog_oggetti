package api_TrasportiLogistic;

import java.time.LocalDateTime;

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
     * crea una prenotazione, modifica le prenotazioni aggiungendola nell'elenco prenotazioni

     * @param departure data di partenza desiderata
     * @param arrival data di arrivo desiderata
     * @param goods tipo di merce
     * @param quantity quantità di merce a seconda del tipo (peso, volume, quantità colli)
     * @param from luogo di partenza della merce
     * @param to luogo di arrivo della merce
     *
     * @return una nuova prenotazione
     *
     * @throws PathNotCoveredExcetption non esiste un percorso che collega from e to
     * @throws NotTransportableException non abbiamo autocarri disponibili o la quantità di merce non è trasportabile
     * (ad esempio goods = colli e quantity = 1,2)
     * @throws InvalidDateException se arrival <= departure o nei festivi o incompatibili con durata del viaggio
     */
    Booking BookTrip(LocalDateTime departure, LocalDateTime arrival, GoodsKind goods, Double quantity, Location from, Location to)
            throws PathNotCoveredExcetption, NotTransportableException, InvalidDateException {
        /**
         * valida date
         * valida tipo/quantità merce
         * cerca i percorsi che collegano from e to // scegli quello ottimale
         * se non c'è => eccezione
         * se durata p incompatibile con le date => eccezione
         * flottaNecessaria = cerca quanti e quali automezzi ci servono (goods, quantity)
         * se non trovo nulla => eccezione
         *
         * nuovaPrenotazione = creare la prenotazione
         * aggiungi (nuovaPrenotazione) a elenco delle prenotazioni
         */
        return null;
    }
}
