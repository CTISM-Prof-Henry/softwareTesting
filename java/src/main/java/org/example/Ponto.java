package org.example;

public class Ponto {
    private final float x;
    private final float y;

    public Ponto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public double distanciaEuclidiana(Ponto outro) {
        return Math.sqrt(Math.pow(this.x - outro.x, 2) + Math.pow(this.y - outro.y, 2));
    }
}