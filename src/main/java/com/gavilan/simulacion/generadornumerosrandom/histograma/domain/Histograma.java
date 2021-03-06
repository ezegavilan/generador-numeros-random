package com.gavilan.simulacion.generadornumerosrandom.histograma.domain;

import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Iteracion;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;

import java.util.ArrayList;
import java.util.List;

public class Histograma {
    private final List<Intervalo> intervalos;
    private final int cantidadIntervalos;

    public Histograma(int cantidadIntervalos) {
        this.intervalos = new ArrayList<>();
        this.cantidadIntervalos = cantidadIntervalos;
    }

    public void generarHistograma(Tabla tablaRandoms) {
        int n = tablaRandoms.getIteraciones().size();
        crearIntervalos(cantidadIntervalos, n);

        cargarObservaciones(tablaRandoms.getIteraciones());
    }

    private void crearIntervalos(int cantidadIntervalos, int n) {
        float tamIntervalo = 1F/cantidadIntervalos;
        int frecuenciaEsperada = this.calcularFrecuenciaEsperada(n, cantidadIntervalos);

        Intervalo intervaloNuevo;
        int intervalo;
        float inf, sup, marcaClase;

        inf = 0.0f;
        sup = tamIntervalo;
        for (int i = 0; i < cantidadIntervalos; i++) {
            intervalo = i + 1;
            if (intervalo == 1) {
                marcaClase = calcularMarcaClase(inf, sup);

                intervaloNuevo = new Intervalo(intervalo, inf, sup, marcaClase, frecuenciaEsperada);
                intervalos.add(intervaloNuevo);
                continue;
            }

            inf = calcularLimiteInferior(sup);
            sup = calcularLimiteSuperior(tamIntervalo, sup);
            marcaClase = calcularMarcaClase(inf ,sup);

            intervaloNuevo = new Intervalo(intervalo, inf, sup, marcaClase, frecuenciaEsperada);

            intervalos.add(intervaloNuevo);
        }
    }

    private int calcularFrecuenciaEsperada(int n, int k) {
        return n/k;
    }

    private void cargarObservaciones(List<Iteracion> tabla) {
        Intervalo intervaloActual;

        int totalObservados = tabla.size();
        float rnd, inf, sup;

        int frAcumuladaActual = 0;
        float propAcumuladaActual = 0f;
        for (int i = 0; i < intervalos.size(); i++) {
            intervaloActual = intervalos.get(i);
            for (int j = 0; j < tabla.size(); j++) {
                rnd = tabla.get(j).getRandomValue();
                inf = intervaloActual.getInferior();
                sup = intervaloActual.getSuperior();

                if (rnd >= inf && rnd < sup) {
                    intervaloActual.registrarObservacion();
                }
            }

            frAcumuladaActual += intervaloActual.getFrecuencia();
            intervaloActual.registrarProporcion(totalObservados);

            propAcumuladaActual += intervaloActual.getProporcion();
            intervaloActual.registrarFrecuenciaAcumulada(frAcumuladaActual);
            intervaloActual.registrarProporcionAcumulada(propAcumuladaActual);
        }
    }

    public List<Intervalo> getIntervalos() {
        return intervalos;
    }

    public int getCantidadIntervalos() {
        return cantidadIntervalos;
    }

    private float calcularMarcaClase(float inf, float sup) {
        return (inf + sup) / 2;
    }

    private float calcularLimiteInferior(float supPrevio) {
        return supPrevio + 0.0001f;
    }

    private float calcularLimiteSuperior(float tamIntervalo, float supPrevio) {
        return supPrevio + tamIntervalo;
    }
}
