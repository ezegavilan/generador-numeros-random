package com.gavilan.simulacion.generadornumerosrandom.generador.apirest;

import com.gavilan.simulacion.generadornumerosrandom.generador.apirest.model.TablaDto;
import com.gavilan.simulacion.generadornumerosrandom.generador.service.in.GenerarRandomUseCase;
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
public class GeneradorRandomController {
    private final GenerarRandomUseCase generarRandomUseCase;

    @PostMapping("/generador/custom")
    public ResponseEntity<Map<String, TablaDto>> generarTablaRandom(@RequestBody GenerarRandomRequest generarRandomRequest) {
        Map<String, TablaDto> response = new HashMap<>();

        TablaDto tabla = this.generarRandomUseCase
                .generarTablaRandom(generarRandomRequest.getN(), generarRandomRequest.getSeed(), generarRandomRequest.getMod(), generarRandomRequest.getMultiplicador(), generarRandomRequest.getIncremento());

        response.put("tabla", tabla);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/generador/lenguaje")
    public ResponseEntity<Map<String, TablaDto>> generarTablaRandomLenguaje(@RequestBody GenerarRandomRequest generarRandomRequest) {
        Map<String, TablaDto> response = new HashMap<>();

        TablaDto tabla = this.generarRandomUseCase.generarTablaRandom(generarRandomRequest.getN());

        response.put("tabla", tabla);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
