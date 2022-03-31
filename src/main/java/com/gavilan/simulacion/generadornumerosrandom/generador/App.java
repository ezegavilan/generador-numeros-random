package com.gavilan.simulacion.generadornumerosrandom.generador;

import com.gavilan.simulacion.generadornumerosrandom.core.domain.GeneradorCustom;
import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Tabla;

public class App {
    public static void main(String[] args) {
        Tabla tablaRandoms = new Tabla();

        tablaRandoms.generarTabla(1, new GeneradorCustom(3, 32, 13, 17));

        System.out.println(tablaRandoms);
    }
}
