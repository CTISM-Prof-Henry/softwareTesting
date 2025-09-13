package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PontoTest {
    @Test
    public void testeDistanciaEuclidiana() {
        Ponto p1 = new Ponto(0, 0);
        Ponto p2 = new Ponto(3, 4);
        double correta = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        assertEquals(
                correta,  // saída esperada
                p1.distanciaEuclidiana(p2),  // saída comparada
                0.01  // tolerância
        );
    }
}