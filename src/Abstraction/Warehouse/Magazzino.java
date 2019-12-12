package Abstraction.Warehouse;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class Magazzino {
    private List<Scarpa> scarpe;
    @Getter
    private Double capienzaMassima;
    private Double latitudine, longitudine;
    private GeneratoreDiCodice codificatore;

    public Integer numeroScarpe(){ // assert in fase di produzione, eccezione no perchè capita n magazzino vuoto
        if(scarpe!=null) {
            return scarpe.size();
        } else {
            return 0;
        }
    }

    public Double totaleVolumeScarpe(){
        return scarpe.stream().mapToDouble(scarpa -> scarpa.fornisciVolume()).sum();
    }

    public Double totalePesoScarpe(){
        return scarpe.stream().mapToDouble(scarpa -> scarpa.getPeso()).sum();
    }

    public void aggiungiScarpa(Scarpa nuovaScarpa){
        Integer nuovoCodice = codificatore.generaCodice();
        nuovaScarpa.setCodice(nuovoCodice);
        scarpe.add(nuovaScarpa);
    }

    public void rimuoviScarpa(Scarpa vecchiaScarpa){
        scarpe.remove(vecchiaScarpa); // usa equals
    }

    public Scarpa fornisciScarpa(Integer codice){
        for(Scarpa scarpa:scarpe){
            if(codice==scarpa.getCodice()){
                return scarpa;
            }
        }
        return null;
    }

    List<Double> fornisciPosizione(){
        return new ArrayList<Double>(Arrays.asList(latitudine, longitudine));
    }
}
