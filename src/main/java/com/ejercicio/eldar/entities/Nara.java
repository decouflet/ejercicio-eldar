package com.ejercicio.eldar.entities;

import lombok.Data;

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
        Calendar fechaActual = Calendar.getInstance();
        return fechaActual.get(Calendar.DAY_OF_MONTH) * this.indice;
    }
}
