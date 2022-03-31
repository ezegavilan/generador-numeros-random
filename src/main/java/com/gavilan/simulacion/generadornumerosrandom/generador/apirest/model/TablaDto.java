package com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TablaDto {
    private List<IteracionDto> iteraciones;

}
