package com.gavilan.simulacion.generadornumerosrandom.core.domain;

public class Random {

    private final long seed;
    private final float value;

    private Random(long seed, float value) {
        this.seed = seed;
        this.value = value;
    }

    public static Random of(long seed, float value) {
        return new Random(seed, value);
    }

    public static Random of(long seed) {
        return new Random(seed, -1F);
    }

    public float value() {
        return this.value;
    }

    public long seed() {
        return this.seed;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Random) {
            Random rnd = (Random) obj;
            return (rnd.value == this.value) && (rnd.seed == this.seed);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Random{" +
                "seed=" + seed +
                ", value=" + value +
                '}';
    }
}
