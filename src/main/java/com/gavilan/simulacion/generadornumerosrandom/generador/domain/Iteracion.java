package com.gavilan.simulacion.generadornumerosrandom.generador.domain;

public class Iteracion {
    private final int iteracion;
    private final String xi;
    private final String random;

    public Iteracion(int iteracion, String xi, String random) {
        this.iteracion = iteracion;
        this.xi = xi;
        this.random = random;
    }

    public int getIteracion() {
        return iteracion;
    }

    public String getXi() {
        return xi;
    }

    public String getRandom() {
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
