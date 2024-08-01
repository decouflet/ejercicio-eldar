package com.ejercicio.eldar.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Amex.class, name = Constantes.AMEX),
        @JsonSubTypes.Type(value = Nara.class, name = Constantes.NARA),
        @JsonSubTypes.Type(value = Visa.class, name = Constantes.VISA)
})
public interface Marca {

    public double calcularTasa();
    public String getNombre();
}
