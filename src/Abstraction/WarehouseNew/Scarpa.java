package Abstraction.WarehouseNew;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class Scarpa extends Merce{
    private String marca;
    private String modello;
    private List<Color> colori;

    // TODO: 12/12/2019 builder
    Scarpa(Integer codice, Double altezza, Double larghezza, Double profondita, Double peso, Date dataStoccaggio, TipiMerce tipologia, List<Misura> misure, Double prezzo) {
        super(codice, altezza, larghezza, profondita, peso, dataStoccaggio, tipologia, misure, prezzo);
    }
}