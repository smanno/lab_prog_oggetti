package api_OperatoreTelefonico;

enum Promotions {
    MINUTI_ILLIMITATI(15.0),
    CHIAMA_E_RICHIAMA(10.0),
    DATI_UNLIMITED(0.0);

    private double cost;

    private Promotions(double cost){
        this.cost = cost;
    }

    double getCost(){
        return this.cost;
    }

    //ECCEZIONE
    /*
    solo se la coppia nome-valore è unica
     */
    static Promotions valueOf(double cost){
        for (Promotions promo:values()) {
            if(promo.getCost()==cost){
                return promo;
            }
        }
        return null;
    }
}
