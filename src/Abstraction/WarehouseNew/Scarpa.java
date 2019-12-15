package Abstraction.WarehouseNew;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class Scarpa extends Merce{
    private String marca;
    private String modello;
    private List<Color> colori;

    @Builder
    Scarpa(Integer codice, Double altezza, Double larghezza, Double profondita, Double peso, Date dataStoccaggio, double misura, Double prezzo, String marca, String modello, List<Color> colori) {
        super(codice, altezza, larghezza, profondita, peso, dataStoccaggio, TipiMerce.solido, null, prezzo);

        Misura nuovaMisura = new Misura(TipoMisura.polliciFrancesi, misura);
        List<Misura> listaMisura = new ArrayList<Misura>(Arrays.asList(nuovaMisura));
        super.setMisure(listaMisura);

        this.setColori(colori);
        this.setMarca(marca);
        this.setModello(modello);
    }
}