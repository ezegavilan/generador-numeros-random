package com.gavilan.simulacion.generadornumerosrandom.generador.domain;

import com.gavilan.simulacion.generadornumerosrandom.core.domain.Generador;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;
import com.gavilan.simulacion.generadornumerosrandom.core.domain.Random;

import java.util.ArrayList;
import java.util.List;

public class Tabla {
    private final List<Iteracion> iteraciones;

    public Tabla() {
        this.iteraciones = new ArrayList<>();
    }

    public void generarTabla(GeneradorCustom generador) {
        this.generarTabla(20, generador);
    }

    public void generarTabla(int n, Generador generador) {
        // En la tabla necesitamos sólo una precisión de 4 decimales, no el float completo.
        //String random = String.format("%.4f", 0.45568797F);

        Random random;
        float randomValue;
        long x1;
        int it;
        for (int i = 0; i < n; i++) {
            random = generador.next();
            randomValue = random.value();
            x1 = random.seed();
            it = generador.getIteration();
            agregarIteracion(new Iteracion(it, x1, randomValue));
        }
    }

    public List<Iteracion> getIteraciones() {
        return iteraciones;
    }

    private void agregarIteracion(Iteracion iteracion) {
        this.iteraciones.add(iteracion);
    }

    @Override
    public String toString() {
        return "Tabla{" +
                "iteraciones=" + iteraciones +
                '}';
    }
}
