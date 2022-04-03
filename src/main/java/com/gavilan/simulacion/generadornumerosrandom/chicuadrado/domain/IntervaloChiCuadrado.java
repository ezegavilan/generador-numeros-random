package com.gavilan.simulacion.generadornumerosrandom.chicuadrado.domain;

public class IntervaloChiCuadrado {
    private final int intervalo;
    private final float inferior;
    private final float superior;
    private final float marcaClase;
    private final int frecuenciaObservada;
    private final int frecuenciaEsperada;
    private float chiCuadrado;
    private float chiCuadradoAcumulado;

    public IntervaloChiCuadrado(int intervalo, float inferior, float superior, float marcaClase, int frecuenciaObservada, int frecuenciaEsperada) {
        this.intervalo = intervalo;
        this.inferior = inferior;
        this.superior = superior;
        this.marcaClase = marcaClase;
        this.frecuenciaObservada = frecuenciaObservada;
        this.frecuenciaEsperada = frecuenciaEsperada;
        this.chiCuadrado = 0f;
        this.chiCuadradoAcumulado = 0f;
    }

    public void registrarChiCuadrado() {
        this.chiCuadrado = calcularChiCuadrado(frecuenciaObservada, frecuenciaEsperada);
    }

    public void registrarChiCuadradoAcumulado(float chiCuadradoAcumulado) {
        this.chiCuadradoAcumulado = chiCuadradoAcumulado;
    }

    private float calcularChiCuadrado(int fo, int fe) {
        return (float) (Math.pow((fo - fe), 2) / fe);
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

    public int getFrecuenciaObservada() {
        return frecuenciaObservada;
    }

    public int getFrecuenciaEsperada() {
        return frecuenciaEsperada;
    }

    public float getChiCuadrado() {
        return chiCuadrado;
    }

    public float getChiCuadradoAcumulado() {
        return chiCuadradoAcumulado;
    }

    @Override
    public String toString() {
        return "IntervaloChiCuadrado{" +
                "intervalo=" + intervalo +
                ", inferior=" + inferior +
                ", superior=" + superior +
                ", marcaClase=" + marcaClase +
                ", frecuenciaObservada=" + frecuenciaObservada +
                ", frecuenciaEsperada=" + frecuenciaEsperada +
                ", chiCuadrado=" + chiCuadrado +
                ", chiCuadradoAcumulado=" + chiCuadradoAcumulado +
                '}';
    }
}
