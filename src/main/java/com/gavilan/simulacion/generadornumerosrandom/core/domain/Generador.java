package com.gavilan.simulacion.generadornumerosrandom.core.domain;

public abstract class Generador {
    protected int i;
    protected Random currentRandom;

    public Generador() {
        this.i = 0;
    }

    public abstract Random next();


    public Random current() {
        return this.currentRandom;
    }

    public int getIteration() {
        return this.i;
    }
}
