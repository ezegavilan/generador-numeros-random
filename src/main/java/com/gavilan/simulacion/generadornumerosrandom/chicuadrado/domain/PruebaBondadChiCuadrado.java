package com.gavilan.simulacion.generadornumerosrandom.chicuadrado.domain;

public class PruebaBondadChiCuadrado {

    public boolean validarHipotesisUniforme(float chiCuadradoCalculado, int gradosLibertad) {
        TablaDistribucionChiCuadrado tablaChiCuadrado = new TablaDistribucionChiCuadrado();
        float chiCuadradoTabulado = tablaChiCuadrado.valorChiTabulado(gradosLibertad);

        if (chiCuadradoTabulado < 0) {
            return false;
        }

        return chiCuadradoCalculado <= chiCuadradoTabulado;
    }
}
