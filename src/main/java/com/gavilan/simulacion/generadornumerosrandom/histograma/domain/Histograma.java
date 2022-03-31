package com.gavilan.simulacion.generadornumerosrandom.histograma.domain;

import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Iteracion;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;

import java.util.ArrayList;
import java.util.List;

public class Histograma {
    private List<Intervalo> intervalos;

    public Histograma() {
        this.intervalos = new ArrayList<>();
    }

    public void generarHistograma(int cantidadIntervalos, Tabla tablaRandoms) {
        crearIntervalos(cantidadIntervalos);

        cargarObservaciones(tablaRandoms.getIteraciones());
    }

    private void crearIntervalos(int cantidadIntervalos) {
        float tamIntervalo = 1F/cantidadIntervalos;
        Intervalo intervaloNuevo;
        int intervalo;
        float inf, sup, marcaClase;

        inf = 0.0f;
        sup = tamIntervalo;
        for (int i = 0; i < cantidadIntervalos; i++) {
            intervalo = i + 1;
            if (intervalo == 1) {
                marcaClase = calcularMarcaClase(inf, sup);

                intervaloNuevo = new Intervalo(intervalo, inf, sup, marcaClase);
                intervalos.add(intervaloNuevo);
                continue;
            }

            inf = calcularLimiteInferior(sup);
            sup = calcularLimiteSuperior(tamIntervalo, sup);
            marcaClase = calcularMarcaClase(inf ,sup);

            intervaloNuevo = new Intervalo(intervalo, inf, sup, marcaClase);

            intervalos.add(intervaloNuevo);
        }
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