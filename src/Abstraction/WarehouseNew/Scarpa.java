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

    @Builder
    Scarpa(Integer codice, Double altezza, Double larghezza, Double profondita, Double peso, Date dataStoccaggio, List<Misura> misure, Double prezzo, String marca, String modello, List<Color> colori) {
        super(codice, altezza, larghezza, profondita, peso, dataStoccaggio, TipiMerce.scarpa, misure, prezzo);
        this.setColori(colori);
        this.setMarca(marca);
        this.setModello(modello);
    }
}