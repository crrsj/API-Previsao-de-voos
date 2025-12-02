package br.com.flight.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightRequest{
     private String origin;
     private String destination;
     private String airline;
     private int scheduledHour;

}
