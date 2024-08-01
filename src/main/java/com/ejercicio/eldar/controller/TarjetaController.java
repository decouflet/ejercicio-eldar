package com.ejercicio.eldar.controller;

import com.ejercicio.eldar.entities.Constantes;
import com.ejercicio.eldar.entities.Tarjeta;
import com.ejercicio.eldar.exceptions.InvalidCardException;
import com.ejercicio.eldar.exceptions.InvalidOperationException;
import com.ejercicio.eldar.responses.OperacionResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaController {

    @PostMapping("/operacion/{monto}")
    public OperacionResponse tasaOperacion(@PathVariable(value = "monto") Integer monto, @Valid @RequestBody Tarjeta tarjeta) {
        this.validaciones(tarjeta, monto);

        return new OperacionResponse(tarjeta.informarTasa(),
                tarjeta.getMarca().getNombre(),
                monto);
    }

    private void validaciones(Tarjeta tarjeta, Integer monto) {
        if (!tarjeta.tarjetaEsValida()) {
            throw new InvalidCardException(Constantes.TARJETA_VENCIDA);
        }

        if (!tarjeta.operacionValida(monto)) {
            throw new InvalidOperationException(Constantes.OPERACION_INVALIDA);
        }
    }

}
