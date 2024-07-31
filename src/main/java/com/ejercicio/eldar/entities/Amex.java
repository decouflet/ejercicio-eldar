package com.ejercicio.eldar.entities;

import lombok.Data;

import java.util.Calendar;

@Data
public class Amex implements Marca {

    Double indice;
    String nombre;

    public Amex() {
        this.indice = 0.1;
        this.nombre = Constantes.AMEX;
    }

    @Override
    public double calcularTasa() {
        Calendar fechaActual = Calendar.getInstance();
        // Debido a que Calendar enumera los meses a partir del 0, debemos sumarle un 1 para que nos devuelve el mes correcto
        int mes = 1 + fechaActual.get(Calendar.MONTH);
        return mes * this.indice;
    }
}
