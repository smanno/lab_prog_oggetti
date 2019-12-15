package Abstraction.Warehouse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Date;
import java.util.List;

@Getter @Setter @Builder
public class Scarpa {
    private Integer codice;
    private String marca;
    private String modello;
    private Date dataStoccaggio;
    private Double prezzo;
    private  Double misura;
    private List<Color> colori;
    private Double altezza, larghezza, profondita;
    private Double peso; // scarpe+scatola

    double fornisciVolume(){
        return altezza*larghezza*profondita;
    }

    @Override
    public boolean equals(Object obj){
        Scarpa vecchiaScarpa = (Scarpa)obj;
        return vecchiaScarpa.getCodice() == this.codice;
    }
}