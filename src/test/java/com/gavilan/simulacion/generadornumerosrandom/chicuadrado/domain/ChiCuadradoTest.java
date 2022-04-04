package com.gavilan.simulacion.generadornumerosrandom.chicuadrado.domain;

import com.gavilan.simulacion.generadornumerosrandom.core.domain.Generador;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;
import com.gavilan.simulacion.generadornumerosrandom.histograma.domain.Histograma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChiCuadradoTest {

    Histograma histograma;
    Generador generador;

    @BeforeEach
    void setUp() {
        generador = new GeneradorCustom(3, 32, 13, 17);
        Tabla tabla = new Tabla();
        tabla.generarTabla(30, generador);

        histograma = new Histograma(5);
        histograma.generarHistograma(tabla);
    }

    @Test
    public void chiCuadradoCalculadoTest() {
        HistogramaChiCuadrado histogramaChiCuadrado = new HistogramaChiCuadrado();
        histogramaChiCuadrado.generarHistogramaChiCuadrado(histograma);

        assertEquals(0.33333334f, histogramaChiCuadrado.getChiCuadradoCalculado());
    }

    @Test
    public void pasaPruebaBondadTest() {
        HistogramaChiCuadrado histogramaChiCuadrado = new HistogramaChiCuadrado();
        histogramaChiCuadrado.generarHistogramaChiCuadrado(histograma);

        float chiCalculado = histogramaChiCuadrado.getChiCuadradoCalculado();
        int gradosLibertad = histogramaChiCuadrado.calcularGradosLibertad();

        PruebaBondadChiCuadrado pruebaBondadChiCuadrado = new PruebaBondadChiCuadrado();
        assertTrue(pruebaBondadChiCuadrado.validarHipotesisUniforme(chiCalculado, gradosLibertad));
    }
}
