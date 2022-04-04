package com.gavilan.simulacion.generadornumerosrandom.histograma.service;

import com.gavilan.simulacion.generadornumerosrandom.chicuadrado.service.in.PruebaBondadChiCuadradoUseCase;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.Generador;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;
import com.gavilan.simulacion.generadornumerosrandom.histograma.apirest.model.HistogramaDto;
import com.gavilan.simulacion.generadornumerosrandom.histograma.apirest.model.IntervaloDto;
import com.gavilan.simulacion.generadornumerosrandom.histograma.domain.Histograma;
import com.gavilan.simulacion.generadornumerosrandom.histograma.domain.Intervalo;
import com.gavilan.simulacion.generadornumerosrandom.histograma.service.in.CrearHistogramaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CreadorHistogramaService implements CrearHistogramaUseCase {
    private final PruebaBondadChiCuadradoUseCase pruebaBondadChiCuadradoUseCase;
    private final int INTERVALOS_DEFAULT = 5;

    @Autowired
    public CreadorHistogramaService(PruebaBondadChiCuadradoUseCase pruebaBondadChiCuadradoUseCase) {
        this.pruebaBondadChiCuadradoUseCase = pruebaBondadChiCuadradoUseCase;
    }

    @Override
    public HistogramaDto generarHistogramaFrecuencia(int n, long seed, int mod, int multiplicador, int incremento) {
        Generador generador = new GeneradorCustom(seed, mod, multiplicador, incremento);
        Tabla tabla = new Tabla();
        tabla.generarTabla(n, generador);

        Histograma histograma = new Histograma(INTERVALOS_DEFAULT);
        histograma.generarHistograma(tabla);

        boolean resultadoPruebaBondadChiCuadrado = this.realizarPruebaChiCuadrado(histograma);

        return HistogramaDto.builder()
                .intervalos(histograma.getIntervalos().stream().map(this::mapToDto).collect(Collectors.toList()))
                .pruebaBondadChiCuadrado(resultadoPruebaBondadChiCuadrado)
                .build();
    }

    private IntervaloDto mapToDto(Intervalo intervalo) {
        return IntervaloDto.builder()
                .intervalo(String.valueOf(intervalo.getIntervalo()))
                .inferior(String.format("%.4f", intervalo.getInferior()))
                .superior(String.format("%.4f", intervalo.getSuperior()))
                .marcaClase(String.format("%.4f", intervalo.getMarcaClase()))
                .frecuenciaEsperada(String.valueOf(intervalo.getFrecuenciaEsperada()))
                .frecuencia(String.valueOf(intervalo.getFrecuencia()))
                .proporcion(String.format("%.4f", intervalo.getProporcion()))
                .frecuenciaAcumulada(String.valueOf(intervalo.getFrecuenciaAcumulada()))
                .proporcionAcumulada(String.format("%.4f", intervalo.getProporcionAcumulada()))
                .build();
    }

    private boolean realizarPruebaChiCuadrado(Histograma histograma) {
        return pruebaBondadChiCuadradoUseCase.validarHipotesisDistribucionUniforme(histograma);
    }
}
