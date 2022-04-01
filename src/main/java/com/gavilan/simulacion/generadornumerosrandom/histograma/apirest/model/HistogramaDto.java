package com.gavilan.simulacion.generadornumerosrandom.histograma.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistogramaDto {
    private List<IntervaloDto> intervalos;

}
