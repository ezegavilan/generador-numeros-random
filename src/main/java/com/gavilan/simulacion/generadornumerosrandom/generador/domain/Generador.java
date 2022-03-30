package com.gavilan.simulacion.generadornumerosrandom.generador.domain;

public class Generador {
    private final float seed;
    private final int mod;
    private final int multiplier;
    private final int incremet;

    private int i;

    private Random currentRandom;

    public Generador(int mod, int multiplier, int incremet) {
        this(7, mod, multiplier, incremet);
    }

    public Generador(float seed, int mod, int multiplier, int incremet) {
        this.seed = seed;
        this.mod = mod;
        this.multiplier = multiplier;
        this.incremet = incremet;
        this.i = 0;
        this.currentRandom = Random.of(seed);
    }

    public Random next() {
        float x1 = (multiplier * this.currentRandom.seed() + incremet) % mod;
        float rnd = x1/mod;

        this.i++;
        this.currentRandom = Random.of(x1, rnd);
        return this.currentRandom;
    }

    public Random current() {
        return this.currentRandom;
    }

    public int getIteration() {
        return this.i;
    }

    public float getOriginalSeed() {
        return this.seed;
    }
}
