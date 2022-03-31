package com.gavilan.simulacion.generadornumerosrandom.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerarRandomRequest {
    private int n;
    private long seed;
    private int mod;
    private int multiplicador;
    private int incremento;

}
