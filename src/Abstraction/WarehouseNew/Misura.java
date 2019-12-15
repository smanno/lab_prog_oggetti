package Abstraction.WarehouseNew;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Misura {
    private TipoMisura tipo;
    private Double valore;

    public Misura(TipoMisura tipo, Double valore) {
        super();
        this.tipo = tipo;
        this.valore = valore;
    }
}