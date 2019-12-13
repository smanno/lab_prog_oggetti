package Abstraction.WarehouseNew;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter @Builder
public abstract class Merce {
    private Integer codice;
    private Double altezza, larghezza, profondita;
    private Double peso; // merce+scatola
    private Date dataStoccaggio;
    private TipiMerce tipologia;
    private List<Misura> misure;
    private Double prezzo;

    double fornisciVolume(){
        return altezza*larghezza*profondita;
    }

    @Override
    public boolean equals(Object obj){
        Merce vecchiaMerce = (Merce)obj;
        return vecchiaMerce.getCodice() == this.codice;
    }
}