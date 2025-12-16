package br.com.flight.controller;

import br.com.flight.dto.FlightRequest;
import br.com.flight.dto.PredictionResponse;
import br.com.flight.service.PredictionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/predict")
@CrossOrigin(origins = "*")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "endpoint responsável por chamar a API Python para determinar a previsão do vôo.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PredictionResponse> getPrediction(@RequestBody FlightRequest request) {
        try {
            // A validação de campos obrigatórios ocorre no Service/Controller.
            // A chamada HTTP para o Python ocorre dentro do Service.
            PredictionResponse response = predictionService.getPrediction(request);

            // Retorno de sucesso (200 OK)
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            // Erro de validação (BAD REQUEST)
            PredictionResponse errorResponse = new PredictionResponse();
            errorResponse.setPrevisao("Erro de Entrada: " + e.getMessage());
            errorResponse.setProbabilidade(0.0);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            // Erro de serviço (SERVICE UNAVAILABLE)
            PredictionResponse errorResponse = new PredictionResponse();
            errorResponse.setPrevisao("Serviço de Previsão Indisponível/Com Erro");
            errorResponse.setProbabilidade(0.0);
            return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

 }
