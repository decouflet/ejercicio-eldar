package com.ejercicio.eldar.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Visa implements Marca{

    String nombre;

    public Visa() {
        this.nombre = Constantes.VISA;
    }

    @Override
    public double calcularTasa() {
        double anioActual = Double.parseDouble(Integer.toString(LocalDate.now().getYear()).substring(2,4));
        double mesActual = LocalDate.now().getMonthValue();
        return anioActual / mesActual;
    }
}
