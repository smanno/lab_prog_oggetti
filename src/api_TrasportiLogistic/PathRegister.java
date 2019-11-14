package api_TrasportiLogistic;

/**
 * STATO ASTRATTO
 * contenitore di Path tutti diversi tra loro
 * possono avere stessa origine e destinazione
 */
public class PathRegister {

    /**
     * Trai i path possibili che collegano from con to, restituisce il migliore
     * migliore nel senso di +corto/+veloce     *
     * @param from path origin
     * @param to pah destination
     * @return bestPath
     * @throws PathNotCoveredExcetption se non esiste un percorso che li colleghi
     */
    public Path findPath(Location from, Location to)
            throws PathNotCoveredExcetption {
    }
}
