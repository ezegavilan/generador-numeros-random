package com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model;

import com.gavilan.simulacion.generadornumerosrandom.generador.domain.Iteracion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TablaResponse {
    private List<Iteracion> iteraciones;

}
