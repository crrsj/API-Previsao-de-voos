package br.com.flight.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PredictionResponse {

    private String previsao;
    private double probabilidade;
}
