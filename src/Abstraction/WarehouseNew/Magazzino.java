package Abstraction.WarehouseNew;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class Magazzino {
    private List<Merce> merci;
    @Getter
    private Double capienzaMassima;
    private Double latitudine, longitudine;
    private GeneratoreDiCodice codificatore;
    // TODO: 12/12/2019 volume scaffali

    public Integer numeroScarpe(){ // assert in fase di produzione, eccezione no perchè capita n magazzino vuoto
        if(merci!=null) {
            return merci.size();
        } else {
            return 0;
        }
    }

    public Double totaleVolume(){
        return merci.stream().mapToDouble(scarpa -> scarpa.fornisciVolume()).sum()+volume;
    }

    public Double totalePeso(){
        return merci.stream().mapToDouble(scarpa -> scarpa.getPeso()).sum();
    }

    public void aggiungiMerce(Merce nuovaMerce){
        Integer nuovoCodice = codificatore.generaCodice();
        nuovaMerce.setCodice(nuovoCodice);
        merci.add(nuovaMerce);
    }

    public void rimuoviScarpa(Merce vecchiaMerce){
        merci.remove(vecchiaMerce); // usa equals
    }

    public Merce fornisciMerce(Integer codice){
        for(Merce merce:merci){
            if(codice==merce.getCodice()){
                return merce;
            }
        }
        return null;
    }

    List<Double> fornisciPosizione(){
        return new ArrayList<Double>(Arrays.asList(latitudine, longitudine));
    }

    void inviaInfo(String url){
        Inviatore inviatore = new Inviatore();
        Double pct = totaleVolume() / capienzaMassima;
        String parametro = "locazione: ("+latitudine+", "+longitudine+")"+"; percentuale: "+pct+"%; numero merci: "+merci.size();
        inviatore.invia(url,parametro);
    }
}
