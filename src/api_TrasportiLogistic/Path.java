package api_TrasportiLogistic;

/**
 * rappresentare un percorso caratterizzato da varie leg
 * un percorso valido deve:
 * - avere 1+ leg
 * - leg collegate tra loro linearmente (tranne quella iniziale e finale)
 * - non ci possono essere dei cicli
 * - ha esattamente una Origine e una Destinazione (necessariamente diverse)
 * per semplicità può rappresentare una serie di tratte ordinate non ripetute
 *
 * ---ESSENZIALI---
 * costruttore con 1 leg o lista leg
 * aggiungere tratta
 * si può aggiungere una certa leg?
 * getOrigin()
 * getDestination()
 *
 * ---ADDIZIONALI---
 * costruttore vuoto // non ha molto senso
 * copy constructor
 * esiste una certa leg
 * remove leg
 * fondere due percorsi
 * estrarre lista città
 * calcolo distanza totale
 * calcolo costo?
 */
public class Path {
    private java.util.Vector<Leg> elencoTratte;
    //origine?
    //destinazione?

    // TODO: 11/11/2019 costruttore

    /**
     * @return l'origine del Path (origine prima leg)
     */
    Location getOrigin(){
        return null;
    }

    /**
     * @return la destinazione del Path (destinazione ultima leg)
     */
    Location getDestination(){
        return null;
    }

    // TODO: 11/11/2019 puòAggiungereLaLeg?

    /**
     * MODIFIY path <= aggiunge newLeg al percorso
     * path=(a,b)(b,c)(c,d)
     * addLeg(d,e)=> aggiunge in coda perchè newLeg.origine=destinazione percorso
     * path'=(a,b)(b,c)(c,d)(d,e)
     * addLeg(e,a)=> aggiunge in testa perchè newLeg.destinazione=origine percorso
     * path'=(e,a)(a,b)(b,c)(c,d)
     *
     * ---tranne nei casi delle eccezioni elencate:
     * addLeg(d,a)=> ECCEZIONE perchè introduce un loop
     * addLeg(r,s)=> ECCEZIONE perchè è sconnesso
     * addLeg(NULL)=> ECCEZIONE
     * addLeg(b,e)=> ECCEZIONE perchè crea una biforcazione
     * addLeg(b,d)=> ECCEZIONE perchè crea una biforcazione
     * addLeg(b,c)=> ECCEZIONE perchè già presente
     *
     * @param newLeg REQUIRE notNull
     */
    public void AddLeg(Leg newLeg) {
    }

    public void methodCalcolaLuoghiPercorsi() {
    }

    public void CalcolaDistanza() {
    }

    /**
     * calcola la durata come somma della durata delle tratte
     * @return
     */
    public long computeDuration() {
    }
}
