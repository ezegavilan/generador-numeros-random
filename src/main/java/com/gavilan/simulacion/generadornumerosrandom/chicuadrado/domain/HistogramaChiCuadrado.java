package com.gavilan.simulacion.generadornumerosrandom.chicuadrado.domain;

import com.gavilan.simulacion.generadornumerosrandom.histograma.domain.Histograma;
import com.gavilan.simulacion.generadornumerosrandom.histograma.domain.Intervalo;

import java.util.ArrayList;
import java.util.List;

public class HistogramaChiCuadrado {
    private final List<IntervaloChiCuadrado> intervalos;
    private int cantidadIntervalos;

    public HistogramaChiCuadrado() {
        this.intervalos = new ArrayList<>();
    }

    public void generarHistogramaChiCuadrado(Histograma histograma) {
        this.cantidadIntervalos = histograma.getCantidadIntervalos();

        List<Intervalo> intervalosHistograma = histograma.getIntervalos();
        Intervalo currentIntervalo;
        IntervaloChiCuadrado intervaloChiCuadrado;

        int intervalo, frecuenciaObservada, frecuenciaEsperada;
        float inferior, superior, marcaClase;
        float chiCuadradoAcumuladoActual = 0f;
        for (int i = 0; i < intervalosHistograma.size(); i++) {
            currentIntervalo = intervalosHistograma.get(i);
            intervalo = currentIntervalo.getIntervalo();
            frecuenciaEsperada = currentIntervalo.getFrecuenciaEsperada();
            frecuenciaObservada = currentIntervalo.getFrecuencia();
            inferior = currentIntervalo.getInferior();
            superior = currentIntervalo.getSuperior();
            marcaClase = currentIntervalo.getMarcaClase();

            intervaloChiCuadrado = new IntervaloChiCuadrado(intervalo, inferior, superior, marcaClase, frecuenciaObservada, frecuenciaEsperada);

            intervaloChiCuadrado.registrarChiCuadrado();
            chiCuadradoAcumuladoActual += intervaloChiCuadrado.getChiCuadrado();

            intervaloChiCuadrado.registrarChiCuadradoAcumulado(chiCuadradoAcumuladoActual);
            intervalos.add(intervaloChiCuadrado);
        }
    }

    public float getChiCuadradoCalculado() {
        int ultimoIndice = intervalos.size() - 1;
        return intervalos.get(ultimoIndice).getChiCuadradoAcumulado();
    }

    public int calcularGradosLibertad() {
        return this.cantidadIntervalos - 1;
    }

    @Override
    public String toString() {
        return "HistogramaChiCuadrado{" +
                "intervalos=" + intervalos +
                ", cantidadIntervalos=" + cantidadIntervalos +
                '}';
    }
}
