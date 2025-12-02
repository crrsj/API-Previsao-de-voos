package br.com.flight.controller;

import br.com.flight.dto.FlightRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/predict")
@CrossOrigin(origins = "*")
public class PredictionController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "endpoint responsável porpor exibir a previsão de voos.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public Map<String, Object> getPrediction(@RequestBody FlightRequest request) {
        // **Lógica de Previsão Simulada**
        // Em um projeto real, esta lógica seria um modelo de ML carregado.

        double probability = 0.1; // Começa com 10% de chance de atraso (baseline)

        // Regra 1: Horário de Pico (Madrugada 0-5h e Noite 18-22h)
        if (request.getScheduledHour() < 5 || request.getScheduledHour() >= 18) {
            probability += 0.25;
        }

        // Regra 2: Companhias com Maior Risco de Atraso Simulado
        if (request.getAirline().equalsIgnoreCase("GOL") || request.getAirline().equalsIgnoreCase("AZUL")) {
            probability += 0.15;
        }

        // Regra 3: Rotas Conhecidas por Congestionamento Simulado (ex: GRU-CGH)
        if (request.getOrigin().equalsIgnoreCase("GRU") && request.getDestination().equalsIgnoreCase("CGH")) {
            probability += 0.30;
        }

        // Garante que a probabilidade esteja entre 0 e 1 (0% a 100%)
        probability = Math.min(1.0, probability);

        // Decide o status baseado em um threshold (ex: > 50% de chance -> Atraso)
        String status = probability > 0.5 ? "ATRASO PROVÁVEL" : "NO HORÁRIO";

        // Formata a resposta
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("probability", String.format("%.2f%%", probability * 100));
        response.put("message", "Previsão baseada em fatores simulados de congestionamento e horário.");

        return response;
    }
}
