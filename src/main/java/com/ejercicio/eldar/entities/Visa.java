package com.ejercicio.eldar.entities;

import lombok.Data;

import java.util.Calendar;

@Data
public class Visa implements Marca{

    String nombre;

    public Visa() {
        this.nombre = Constantes.VISA;
    }

    @Override
    public double calcularTasa() {
        Calendar fechaActual = Calendar.getInstance();

        String anio = Integer.toString(fechaActual.get(Calendar.YEAR));
        // Tomamos los ultimos dos valores del anio actual
        double anio_tasa = Double.parseDouble(anio.substring(2));

        int mes = 1 + fechaActual.get(Calendar.MONTH);

        return anio_tasa / mes;
    }
}
