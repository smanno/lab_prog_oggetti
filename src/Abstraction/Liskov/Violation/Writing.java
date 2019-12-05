package Abstraction.Liskov.Violation;

import lombok.Getter;
import lombok.Setter;

/**
 * uso una classe astratta perché un'Interfaccia è una CARATTERISTICA
 * Writing esiste, è un'ENTITA'
 */
public abstract class Writing {
    @Getter @Setter
    String content; // nell'interfaccia il campo è STATIC e FINAL => il campo è una costante

    abstract String toFileName();
}