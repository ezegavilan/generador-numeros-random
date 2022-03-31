package com.gavilan.simulacion.generadornumerosrandom.core.domain;

public class GeneradorCustom extends Generador {
    private final long seed;
    private final int mod;
    private final int multiplier;
    private final int incremet;

    public GeneradorCustom(int mod, int multiplier, int incremet) {
        this(7, mod, multiplier, incremet);
    }

    public GeneradorCustom(long seed, int mod, int multiplier, int incremet) {
        this.seed = seed;
        this.mod = mod;
        this.multiplier = multiplier;
        this.incremet = incremet;
        this.currentRandom = Random.of(seed);
    }

    @Override
    public Random next() {
        double x1 = (multiplier * this.currentRandom.seed() + incremet) % mod;
        float rnd = (float) (x1/mod);

        this.i++;
        this.currentRandom = Random.of(x1, rnd);
        return this.currentRandom;
    }

    public double getOriginalSeed() {
        return this.seed;
    }
}
