package com.ejercicio.eldar.entities;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = Constantes.NUMERO_TARJETA_VACIO)
    Long numeroTarjeta;

    String cardHolder;

    @NotNull(message = Constantes.FECHA_VENCIMIENTO_VACIA)
    LocalDate fechaVencimiento;

    @NotNull(message = Constantes.MARCA_VACIA)
    Marca marca;

    public double informarTasa() {
        return this.marca.calcularTasa();
    }

    static public String tarjetasDistintas(Tarjeta tarjeta_1, Tarjeta tarjeta_2) {
        if (!tarjeta_1.getNumeroTarjeta().equals(tarjeta_2.getNumeroTarjeta())) {
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
        return monto < Constantes.MONTO_MAXIMO;
    }

}
