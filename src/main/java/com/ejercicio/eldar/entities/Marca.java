package com.ejercicio.eldar.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Amex.class, name = "Amex"),
        @JsonSubTypes.Type(value = Nara.class, name = "Nara"),
        @JsonSubTypes.Type(value = Visa.class, name = "Visa")
})
public interface Marca {

    public double calcularTasa();
    public String getNombre();
}
