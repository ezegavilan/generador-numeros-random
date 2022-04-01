package com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IteracionDto {
    private String iteracion;
    private String xi;
    private String random;

}
