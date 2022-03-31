package com.gavilan.simulacion.generadornumerosrandom.generador.service.in;

import com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model.TablaDto;

/**
 * Principal caso de uso: Dado un número de muestras N, semilla, modulo, multiplicador e incremento: Generar N números
 * pseudoaleatorios en una tabla con 'i' iteraciones que corresponden a las N muestras solicitadas.
 */
public interface GenerarRandomUseCase {
    TablaDto generarTablaRandom(int n, long seed, int mod, int multiplicador, int incremento);

    TablaDto generarTablaRandom(int n);
}
