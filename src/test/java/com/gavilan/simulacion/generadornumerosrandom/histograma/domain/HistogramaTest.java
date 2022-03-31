package com.gavilan.simulacion.generadornumerosrandom.histograma.domain;

import com.gavilan.simulacion.generadornumerosrandom.core.domain.Generador;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistogramaTest {

    Generador generador;
    Tabla tabla;
    Histograma histograma;

    @BeforeEach
    void setUp() {
        generador = new GeneradorCustom(13, 32, 13, 17);
        tabla = new Tabla();
        tabla.generarTabla(10, generador);
        histograma = new Histograma();
        histograma.generarHistograma(5, tabla);
    }

    @Test
    public void frecuenciaAcumuladaShouldBeNTest() {
        int indexUltimoIntervalo = histograma.getIntervalos().size() - 1;
        Intervalo ultimoIntervalo = histograma.getIntervalos().get(indexUltimoIntervalo);

        assertEquals(10, ultimoIntervalo.getFrecuencaAcumulada());
    }

    @Test
    public void primerFrecuenciaIgualPrimerFrecuenciaAcumuladaTest() {
        Intervalo primerIntervalo = histograma.getIntervalos().get(0);

        assertEquals(primerIntervalo.getFrecuencia(), primerIntervalo.getFrecuencaAcumulada());
    }

    @Test
    public void proporcionAcumuladaShouldBe1Test() {
        int indexUltimoIntervalo = histograma.getIntervalos().size() - 1;
        Intervalo ultimoIntervalo = histograma.getIntervalos().get(indexUltimoIntervalo);

        assertEquals(1.0f, ultimoIntervalo.getProporcionAcumulada());
    }

    @Test
    public void primerFrecuenciaTest() {
        // dada la semilla sabemos de antemano cuales son los rnd, y la frecuencia de los intervalos
        Intervalo primerIntervalo = histograma.getIntervalos().get(0);

        assertEquals(4, primerIntervalo.getFrecuencia());
    }
}