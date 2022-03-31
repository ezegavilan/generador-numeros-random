package com.gavilan.simulacion.generadornumerosrandom.generador.domain;

import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;

import java.util.ArrayList;
import java.util.List;

public class Tabla {
    private final int DEFAULT_N = 20;
    private List<Iteracion> iteraciones;

    public Tabla() {
        this.iteraciones = new ArrayList<>();
    }

    public void generarTabla(GeneradorCustom generador) {
        this.generarTabla(DEFAULT_N, generador);
    }

    public void generarTabla(int n, GeneradorCustom generador) {

        // En la tabla necesitamos sólo una precisión de 4 decimales, no el float completo.
        String random = String.format("%.4f", 0.45568797F);

        agregarIteracion(new Iteracion(1, "1", random));

    }

    public void agregarIteracion(Iteracion iteracion) {
        this.iteraciones.add(iteracion);
    }

    @Override
    public String toString() {
        return "Tabla{" +
                "iteraciones=" + iteraciones +
                '}';
    }
}
