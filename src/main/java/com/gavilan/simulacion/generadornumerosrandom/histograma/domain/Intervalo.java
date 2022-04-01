package com.gavilan.simulacion.generadornumerosrandom.histograma.domain;

public class Intervalo {
    private final int intervalo;
    private final float inferior;
    private final float superior;
    private final float marcaClase;
    private int frecuencia;
    private float proporcion;
    private int frecuencaAcumulada;
    private float proporcionAcumulada;

    public Intervalo(int intervalo, float inferior, float superior, float marcaClase) {
        this.intervalo = intervalo;
        this.inferior = inferior;
        this.superior = superior;
        this.marcaClase = marcaClase;
        this.frecuencia = 0;
        this.proporcion = 0f;
        this.frecuencaAcumulada = 0;
        this.proporcionAcumulada = 0f;
    }

    public void registrarObservacion() {
        this.frecuencia++;
    }

    public void registrarProporcion(int n) {
        this.proporcion = (float) this.frecuencia / n;
    }

    public void registrarFrecuenciaAcumulada(int frecuencaAcumulada) {
        this.frecuencaAcumulada = frecuencaAcumulada;
    }

    public void registrarProporcionAcumulada(float proporcionAcumulada) {
        this.proporcionAcumulada = proporcionAcumulada;
    }


    public int getIntervalo() {
        return intervalo;
    }

    public float getInferior() {
        return inferior;
    }

    public float getSuperior() {
        return superior;
    }

    public float getMarcaClase() {
        return marcaClase;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public float getProporcion() {
        return proporcion;
    }

    public int getFrecuencaAcumulada() {
        return frecuencaAcumulada;
    }

    public float getProporcionAcumulada() {
        return proporcionAcumulada;
    }

    @Override
    public String toString() {
        return "Intervalo{" +
                "intervalo=" + intervalo +
                ", inferior=" + inferior +
                ", superior=" + superior +
                ", marcaClase=" + marcaClase +
                ", frecuencia=" + frecuencia +
                ", proporcion=" + proporcion +
                ", frecuencaAcumulada=" + frecuencaAcumulada +
                ", proporcionAcumulada=" + proporcionAcumulada +
                '}';
    }
}
