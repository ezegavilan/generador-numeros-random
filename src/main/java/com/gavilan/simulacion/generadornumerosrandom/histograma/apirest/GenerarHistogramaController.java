package com.gavilan.simulacion.generadornumerosrandom.histograma.apirest;

import com.gavilan.simulacion.generadornumerosrandom.histograma.apirest.model.HistogramaDto;
import com.gavilan.simulacion.generadornumerosrandom.histograma.service.in.CrearHistogramaUseCase;
import com.gavilan.simulacion.generadornumerosrandom.shared.model.GenerarRandomRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class GenerarHistogramaController {
    private final CrearHistogramaUseCase crearHistogramaUseCase;


    @PostMapping("/histograma/custom")
    public ResponseEntity<Map<String, HistogramaDto>> crearHistogramaDeFrecuencia(@RequestBody GenerarRandomRequest req) {
        Map<String, HistogramaDto> response = new HashMap<>();

        HistogramaDto histograma = this.crearHistogramaUseCase
                .generarHistogramaFrecuencia(req.getN(), req.getIntervalos(), req.getSeed(), req.getMod(), req.getMultiplicador(), req.getIncremento());

        response.put("histograma", histograma);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/histograma/lenguaje")
    public ResponseEntity<Map<String, HistogramaDto>> crearHistogramaConGeneradorLenguaje(@RequestBody GenerarRandomRequest req) {
        Map<String, HistogramaDto> response = new HashMap<>();

        HistogramaDto histograma = this.crearHistogramaUseCase.generarHistogramaFrecuenciaGeneradorLenguaje(req.getN());

        response.put("histograma", histograma);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
