package com.gavilan.simulacion.generadornumerosrandom.generador.domain;

public class Iteracion {
    private final int iteracion;
    private final long xi;
    private final float random;

    public Iteracion(int iteracion, long xi, float random) {
        this.iteracion = iteracion;
        this.xi = xi;
        this.random = random;
    }

    public int getIteracion() {
        return iteracion;
    }

    public long getXi() {
        return xi;
    }

    public float getRandomValue() {
        return random;
    }

    @Override
    public String toString() {
        return "Iteracion{" +
                "iteracion=" + iteracion +
                ", xi='" + xi + '\'' +
                ", random='" + random + '\'' +
                '}';
    }
}
