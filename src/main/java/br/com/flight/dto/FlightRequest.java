package br.com.flight.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightRequest{
     private String companhia;
     private String origem;
     private String destino;
     private String data_partida; // Ex: "2025-11-10T14:30:00"
     private int distancia_km;

}
