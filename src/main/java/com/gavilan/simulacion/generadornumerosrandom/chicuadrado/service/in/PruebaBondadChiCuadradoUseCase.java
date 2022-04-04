package com.gavilan.simulacion.generadornumerosrandom.chicuadrado.service.in;

import com.gavilan.simulacion.generadornumerosrandom.histograma.domain.Histograma;

/**
 * Valida si la hipótesis de que la distribución de los N números randoms del histograma de frecuencia es uniforme.
 */
public interface PruebaBondadChiCuadradoUseCase {

    boolean validarHipotesisDistribucionUniforme(Histograma histograma);
}
