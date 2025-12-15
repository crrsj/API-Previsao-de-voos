package br.com.flight;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Análise de previsão de atraso de voos",
				version = "1.0",
				description = "API para análise de previsão de voos",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class FlightOnTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightOnTimeApplication.class, args);
	}

}
