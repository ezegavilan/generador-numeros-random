package com.gavilan.simulacion.generadornumerosrandom.generador.service;


import com.gavilan.simulacion.generadornumerosrandom.core.domain.Generador;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorLenguaje;
import com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model.IteracionDto;
import com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model.TablaDto;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Iteracion;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;
import com.gavilan.simulacion.generadornumerosrandom.generador.service.in.GenerarRandomUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneradorRandomService implements GenerarRandomUseCase {

    @Override
    public TablaDto generarTablaRandom(int n, long seed, int mod, int multiplicador, int incremento) {
        Generador generador = new GeneradorCustom(seed, mod, multiplicador, incremento);
        Tabla tabla = new Tabla();
        tabla.generarTabla(n, generador);
        List<IteracionDto> iteraciones = tabla.getIteraciones()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return TablaDto.builder().iteraciones(iteraciones).build();
    }

    @Override
    public TablaDto generarTablaRandom(int n) {
        Generador generador = new GeneradorLenguaje();
        Tabla tabla = new Tabla();
        tabla.generarTabla(n, generador);
        List<IteracionDto> iteraciones = tabla.getIteraciones()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return TablaDto.builder().iteraciones(iteraciones).build();
    }

    private IteracionDto mapToDto(Iteracion iteracion) {
        String i, xi, randomString;

        i = String.valueOf(iteracion.getIteracion());
        xi = String.valueOf(iteracion.getXi());
        randomString = String.format("%.4f", iteracion.getRandomValue());

        return IteracionDto.builder()
                .iteracion(i)
                .xi(xi)
                .random(randomString).build();
    }
}
