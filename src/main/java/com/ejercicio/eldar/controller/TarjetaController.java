package com.ejercicio.eldar.controller;

import com.ejercicio.eldar.entities.Tarjeta;
import com.ejercicio.eldar.responses.OperacionResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/tarjeta")
@RestController
public class TarjetaController {

    @PostMapping("/operacion/{monto}")
    public OperacionResponse tasaOperacion(@PathVariable Integer monto, @RequestBody Tarjeta tarjeta) {
        Boolean operacionValida = true;
        if (monto > 1000) {
            operacionValida = false;
        }

        OperacionResponse operacionResponse = new OperacionResponse(tarjeta.getMarca().calcularTasa(),
                                                                    tarjeta.getMarca().getNombre(),
                                                                    monto,
                                                                    tarjeta.operacionValida(monto),
                                                                    tarjeta.tarjetaEsValida());
        return operacionResponse;
    }

}
