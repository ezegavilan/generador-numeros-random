package com.gavilan.simulacion.generadornumerosrandom.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneradorRandomTest {

    final int SEED = 1;
    final int MOD = 9;
    final int MULTIPLICADOR = 2;
    final int INCREMENTO = 0;

    @Test
    public void generarRandomPobre() {
        GeneradorCustom generador = new GeneradorCustom(SEED, MOD, MULTIPLICADOR, INCREMENTO);
        Random nextRnd = generador.next();
        assertEquals(0.2222222238779068, nextRnd.value());
        assertEquals(1, generador.getOriginalSeed());
    }

    @Test
    public void generarRandomDefaultSeedDosIteraciones() {
        GeneradorCustom generador = new GeneradorCustom(MOD, MULTIPLICADOR, INCREMENTO);

        generador.next();
        generador.next();

        assertEquals(2, generador.getIteration());
        assertEquals(0.1111111119389534, generador.current().value());
    }

    @Test
    public void generarSeisRandomConParametrosCustom() {
        // Dado un ejercicio hecho en papel, vamos a probar que pasa el test siguiente
        // Datos: seed: 3, mod: 32, mult: 13, inc: 17
        GeneradorCustom generador = new GeneradorCustom(3, 32, 13, 17);

        Random primero = generador.next();
        Random segundo = generador.next();
        Random tercero = generador.next();
        Random cuarto = generador.next();
        Random quinto = generador.next();
        Random sexto = generador.next();

        assertEquals(0.75, primero.value());
        assertEquals(0.28125, segundo.value());
        assertEquals(0.1875, tercero.value());
        assertEquals(0.96875, cuarto.value());
        assertEquals(0.1250, quinto.value());
        assertEquals(0.15625, sexto.value());
    }

    @Test
    public void generadorConPeriodo1() {
        GeneradorCustom generador = new GeneradorCustom(7, 8, 43, 4);
        Random primero = generador.next();
        generador.next();
        Random tercero = generador.next();

        assertEquals(primero, tercero);
    }

    @Test
    public void simpleRandomTest() {
        Random rnd = Random.of(1, 0.2222222238779068F);
        assertEquals(0.2222222238779068, rnd.value());
    }
}
