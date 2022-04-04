package com.gavilan.simulacion.generadornumerosrandom.chicuadrado.service;

import com.gavilan.simulacion.generadornumerosrandom.chicuadrado.domain.HistogramaChiCuadrado;
import com.gavilan.simulacion.generadornumerosrandom.chicuadrado.domain.PruebaBondadChiCuadrado;
import com.gavilan.simulacion.generadornumerosrandom.chicuadrado.service.in.PruebaBondadChiCuadradoUseCase;
import com.gavilan.simulacion.generadornumerosrandom.histograma.domain.Histograma;
import org.springframework.stereotype.Service;

@Service
public class PruebaBondadChiCuadradoService implements PruebaBondadChiCuadradoUseCase {

    @Override
    public boolean validarHipotesisDistribucionUniforme(Histograma histograma) {
        HistogramaChiCuadrado histogramaChiCuadrado = this.generarHistogramaChiCuadrado(histograma);

        float chiCuadradoCalculado = histogramaChiCuadrado.getChiCuadradoCalculado();
        int gradosLibertad = histogramaChiCuadrado.calcularGradosLibertad();

        PruebaBondadChiCuadrado pruebaBondadChiCuadrado = new PruebaBondadChiCuadrado();
        return pruebaBondadChiCuadrado.validarHipotesisUniforme(chiCuadradoCalculado, gradosLibertad);
    }

    private HistogramaChiCuadrado generarHistogramaChiCuadrado(Histograma histograma) {
        HistogramaChiCuadrado histogramaChiCuadrado = new HistogramaChiCuadrado();
        histogramaChiCuadrado.generarHistogramaChiCuadrado(histograma);
        return histogramaChiCuadrado;
    }
}
