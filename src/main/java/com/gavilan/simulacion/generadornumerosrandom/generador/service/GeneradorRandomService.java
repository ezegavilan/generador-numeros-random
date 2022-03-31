package com.gavilan.simulacion.generadornumerosrandom.generador.service;


import com.gavilan.simulacion.generadornumerosrandom.core.domain.Generador;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorLenguaje;
import com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model.TablaResponse;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;
import com.gavilan.simulacion.generadornumerosrandom.generador.service.in.GenerarRandomUseCase;
import org.springframework.stereotype.Service;

@Service
public class GeneradorRandomService implements GenerarRandomUseCase {

    @Override
    public TablaResponse generarTablaRandom(int n, long seed, int mod, int multiplicador, int incremento) {
        Generador generador = new GeneradorCustom(seed, mod, multiplicador, incremento);
        Tabla tabla = new Tabla();
        tabla.generarTabla(n, generador);
        return TablaResponse.builder().iteraciones(tabla.getIteraciones()).build();
    }

    @Override
    public TablaResponse generarTablaRandom(int n) {
        Generador generador = new GeneradorLenguaje();
        Tabla tabla = new Tabla();
        tabla.generarTabla(n, generador);
        return TablaResponse.builder().iteraciones(tabla.getIteraciones()).build();
    }
}
