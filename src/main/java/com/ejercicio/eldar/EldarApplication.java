package com.ejercicio.eldar;

import com.ejercicio.eldar.entities.*;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@Log
@SpringBootApplication
public class EldarApplication {

	public static void main(String[] args) {

		SpringApplication.run(EldarApplication.class, args);

		Marca nara = new Nara();
		Marca amex = new Amex();
		Marca visa = new Visa();
		Tarjeta tarjeta_nara = new Tarjeta(1L, "Roberto Sanchez", LocalDate.of(2031, 1, 31), nara);
		Tarjeta tarjeta_amex = new Tarjeta(2L, "Roberto Frergolio", LocalDate.of(2032, 3, 2), amex);
		Tarjeta tarjeta_visa = new Tarjeta(3L, "Carlos Martinez", LocalDate.of(2029, 12, 12), visa);

		// INFORMACION DE TARJETA
		log.info(tarjeta_visa.toString());

		// IDENTIFICAR SI UNA TARJETA ES DISTINTA A OTRA
		log.info(Tarjeta.tarjetasDistintas(tarjeta_amex, tarjeta_nara));

		/*
			Las validaciones de las operaciones y de tarjetas validas para operar
			ocurren en la llamada al endpoint "tasaOperacion".
		*/
	}

}
