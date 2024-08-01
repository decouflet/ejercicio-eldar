package com.ejercicio.eldar.entities;

import lombok.Data;

import java.time.LocalDate;
import java.util.Calendar;

@Data
public class Nara implements Marca {

    Double indice;
    String nombre;

    public Nara() {
        this.indice = Constantes.INDICE_NARA;
        this.nombre = Constantes.NARA;
    }

    @Override
    public double calcularTasa() {
        int diaMesActual = LocalDate.now().getDayOfMonth();
        return diaMesActual * this.indice;
    }
}
