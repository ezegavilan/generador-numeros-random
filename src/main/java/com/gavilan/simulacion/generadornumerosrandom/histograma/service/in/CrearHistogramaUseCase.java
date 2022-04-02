package com.gavilan.simulacion.generadornumerosrandom.histograma.service.in;

import com.gavilan.simulacion.generadornumerosrandom.histograma.apirest.model.HistogramaDto;

/**
 * Caso de uso para generar un histograma con sus intervalos (por defecto 5). Recibe como entrada: número de muestras N,
 * semilla, modulo, multiplicador e incremento, que son utilizadas para generar la tabla de números pseudoaleatorios.
 */
public interface CrearHistogramaUseCase {
    HistogramaDto generarHistogramaFrecuencia(int n, long seed, int mod, int multiplicador, int incremento);

    HistogramaDto generarHistogramaFrecuenciaGeneradorLenguaje(int n);
}
