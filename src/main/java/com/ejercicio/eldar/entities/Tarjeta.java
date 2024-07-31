package com.ejercicio.eldar.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tarjeta {
    Long id;
    String cardHolder;
    LocalDate fechaVencimiento;
    Marca marca;

    public double informarTasa() {
        return this.marca.calcularTasa();
    }

    static public String tarjetasDistintas(Tarjeta tarjeta_1, Tarjeta tarjeta_2) {
        if (!tarjeta_1.getId().equals(tarjeta_2.getId())) {
            return Constantes.TARJETAS_DISTINTAS;
        } else {
            return Constantes.TARJETAS_IGUALES;
        }
    }

    public boolean tarjetaEsValida() {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isBefore(this.fechaVencimiento);
    }

    public boolean operacionValida(Integer monto) {
        return monto < 1000;
    }

}
