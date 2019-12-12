package Abstraction.WarehouseNew;

public class GeneratoreDiCodice {
    int codice = 0;

    public Integer generaCodice() {
        return ++codice;
    }
}
