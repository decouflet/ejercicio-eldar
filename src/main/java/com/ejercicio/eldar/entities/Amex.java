package com.ejercicio.eldar.entities;

import lombok.Data;

import java.time.LocalDate;
import java.util.Calendar;

@Data
public class Amex implements Marca {

    Double indice;
    String nombre;

    public Amex() {
        this.indice = Constantes.INDICE_AMEX;
        this.nombre = Constantes.AMEX;
    }

    @Override
    public double calcularTasa() {
        int mesActual = LocalDate.now().getMonthValue();
        return mesActual * this.indice;
    }
}
