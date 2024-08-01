package com.ejercicio.eldar.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacionResponse {
    double tasa;
    String marca;
    Integer importe;
}
