package com.gavilan.simulacion.generadornumerosrandom.generador.apirest;

import com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model.GenerarRandomRequest;
import com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model.TablaResponse;
import com.gavilan.simulacion.generadornumerosrandom.generador.service.in.GenerarRandomUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GeneradorRandomController {
    private final GenerarRandomUseCase generarRandomUseCase;

    @GetMapping("/generador/custom")
    public ResponseEntity<Map<String, TablaResponse>> generarTablaRandom(@RequestBody GenerarRandomRequest generarRandomRequest) {
        Map<String, TablaResponse> response = new HashMap<>();

        TablaResponse tabla = this.generarRandomUseCase
                .generarTablaRandom(generarRandomRequest.getN(), generarRandomRequest.getSeed(), generarRandomRequest.getMod(), generarRandomRequest.getMultiplicador(), generarRandomRequest.getIncremento());

        response.put("tabla", tabla);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/generador/lenguaje")
    public ResponseEntity<Map<String, TablaResponse>> generarTablaRandomLenguaje(@RequestBody GenerarRandomRequest generarRandomRequest) {
        Map<String, TablaResponse> response = new HashMap<>();

        TablaResponse tabla = this.generarRandomUseCase.generarTablaRandom(generarRandomRequest.getN());

        response.put("tabla", tabla);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
