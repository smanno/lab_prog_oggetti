package api_TrasportiLogistic;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * PARTIRE DA QUESTA CLASSE, sopratutto all'esame, perchè è il nocciolo dell'esercizio
 * facendo riferimento agli altri TIpi di Dati Astratti
 *
 * è MUTABILE perchè mantiene un elenco di viaggi/prenotazioni/percorsi *
 * ---Caratterizzato da:
 * elenco percorsi      non vuoto, ogni percorso è valido
 * elenco prenotazioni  può essere vuoto
 * flotta               con almeno un camion per tipo
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

    // funzione di astrazione ovvia
    private PathRegister elencoPercorsi;
    private BookingRegister elencoPrenotazioni;
    private Fleet flotta;

    // INVARIANTE
    /**
     * ciascuna variabile di istanza =/= NULL
     * Invariante dopo initialise();
     * elencoPercorsi: 1+ Path
     * flotta: 1+ Truck
     */

    /**
     * crea una prenotazione a partire dalla data di PARTENZA

     * @param departure data di partenza desiderata
     * @param goods tipo di merce
     * @param quantity quantità di merce
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
    private Booking BookTrip(LocalDateTime departure, GoodsKind goods, Double quantity, Location from, Location to)
            throws PathNotCoveredExcetption, NotTransportableException, InvalidDateException {

        // valida tipo/quantità merce
        ValidateGoods(goods, quantity);
        // cerca i percorsi che collegano from e to // scegli quello ottimale
        Path aPath = elencoPercorsi.findPath(from, to);
        long durationMinutes = aPath.computeDuration();
        LocalDateTime arrival = departure+durationMinutes;
        // valida le date
        ValidateTripDates(departure, arrival, durationMinutes);
        // flottaNecessaria = cerca quanti e quali automezzi ci servono (goods, quantity)
        List<Truck> possibleTrucks = flotta.findTrucks(departure, goods, quantity)
        // TODO: 14/11/2019 considerare il fatto che la posizione del camion non coincida con from
        if(possibleTrucks.isEmpty()){
            throw new NotTransportableException("Non ci sono autocarri");
        }
        Truck chosenTruck = possibleTrucks.get(0);
        // creo la prenotazione
        Booking newBooking = new Booking(departure,arrival,goods,quantity,from,to,chosenTruck);
        elencoPrenotazioni.add(newBooking);
        return newBooking;
    }

    /**
     * crea una prenotazione a partire dalla data di PARTENZA
     * modifica le prenotazioni aggiungendola nell'elenco prenotazioni

     * @param departure data di partenza desiderata
     * @param goods tipo di merce
     * @param quantity quantità di merce
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

    public Booking BookTripDeparting(LocalDateTime departure, GoodsKind goods, Double quantity, Location from, Location to)
            throws PathNotCoveredExcetption, NotTransportableException, InvalidDateException {
        // delega CreateTrip la creazione del viaggio e il controllo degli errori
        // TODO: 13/11/2019 try/catch
        Booking newTrip = BookTrip(departure, goods, quantity, from, to);
        // se tutto ok aggiungi newTrip a elenco delle prenotazioni
        return newTrip;
    }

    /**
     * crea una prenotazione a partire dalla data di ARRIVO
     * modifica le prenotazioni aggiungendola nell'elenco prenotazioni

     * @param arrival data di arrivo desiderata
     * @param goods tipo di merce
     * @param quantity quantità di merce
     * @param from luogo di partenza della merce
     * @param to luogo di arrivo della merce
     *
     * @return una nuova prenotazione
     *
     * @throws PathNotCoveredExcetption non esiste un percorso che collega from e to
     * @throws NotTransportableException non abbiamo autocarri disponibili o la quantità di merce non è trasportabile
     * (ad esempio goods = colli e quantity = 1,2)
     * @throws InvalidDateException se departure.before(now()) nei festivi
     */
    public Booking BookTripArriving(LocalDateTime arrival, GoodsKind goods, Double quantity, Location from, Location to)
            throws PathNotCoveredExcetption, NotTransportableException, InvalidDateException {
        Duration tripDuration = GetTripDuration(from, to);
        LocalDateTime departure = LocalDateTime.now();
        // calcolo departure = arrival - tripDuration
        // se daparture.isBefore(now()) => eccezione
        // delega CreateTrip la creazione del viaggio e il controllo degli errori
        // TODO: 13/11/2019 try/catch
        Booking newTrip = BookTrip(departure, goods, quantity, from, to);
        // se tutto ok aggiungi newTrip a elenco delle prenotazioni
        return newTrip;
    }

    /**
     * controlla due date:
     *  non devono essere NULL
     *  arrival.after(departure)
     *  departure.after(now())
     *  non devono essere festivi     *
     * @param departure data di partenza
     * @param arrival data di arrivo
     * @param durationMinutes durata prevista del viaggio
     * @throws InvalidDateException se una delle condizione è violata
     */
    private void ValidateTripDates(LocalDateTime departure, LocalDateTime arrival, long durationMinutes)
            throws InvalidDateException{
    }

    /**
     * verifica merce e quantità
     * @param goods
     * @param quantity
     * @throws NotTransportableException
     */
    private void ValidateGoods(GoodsKind goods, double quantity)
            throws NotTransportableException{
    }

    /**
     * @param from luogo di partenza
     * @param to luogo di arrivo
     * @return durata del percorso
     * @throws PathNotCoveredExcetption non esiste tra i percorsi conosciuti
     */
    Duration GetTripDuration(Location from, Location to)
            throws PathNotCoveredExcetption{
        // valida from/to, in caso => eccezione
        Duration tripDuration = Duration.ZERO;
        // in un ciclo da leg.origin=from
        // finchè leg.destination!=to
            // tripDuration += leg.transitTime
        return tripDuration;
    }

    /**
     * @param alternativePath to reroute the Booking
     * @param trip that needs to change
     * @throws PathNotCoveredExcetption non esiste tra i percorsi conosciuti
     * @throws NotTransportableException la flotta non è disponibile
     * @throws InvalidDateException se departure/arrival vengono modificati
     */
    Booking Reroute(Path alternativePath, Booking trip)
            throws PathNotCoveredExcetption, NotTransportableException, InvalidDateException{
        // valida Path, in caso => eccezione
        // crea un nuovo Booking
        Booking newTrip = trip.ReroutePath(alternativePath);
        // se cambiano le date di departure/arrival => eccezione
        // se non ci sono automezzi disponibili => eccezione
        // se tutto ok, dalla lista prenotazioni
        // rimuovo vecchia prenotazione
        // aggiungo nuova prenotazione
        return newTrip;
    }
}
