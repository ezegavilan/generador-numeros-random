package com.gavilan.simulacion.generadornumerosrandom.core.domain;

public class GeneradorLenguaje extends Generador {

    public GeneradorLenguaje() {
        // Dejamos que el generador del lenguaje use un seed generado automáticamente
        // En nuestro objeto Random ponemos siempre el seed -1 para indicar que no fue generado manualmente
        this.currentRandom = Random.of(-1);
    }

    @Override
    public Random next() {
        java.util.Random rndLenguaje = new java.util.Random();
        this.i++;
        return Random.of(-1, rndLenguaje.nextFloat());
    }
}
