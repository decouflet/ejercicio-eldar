# EJERCICIOS TECNICOS ELDAR


## Ejercicio 1 y 2

- FUNCIONALIDAD:
    - El endpoint "operacion" recibe un json con los campos del objeto de tipo Tarjeta, donde el campo "marca" debe ser pasada de la siguiente manera:
      {
      "marca" : {
          "tipo" : "AMEX"
        }
      }
      El resto de los campos se colocan de la manera clasica (solo el String)
    - El campo "fechaVencimiento" debe respetar el formato YYYY-MM-DD

- CONSIDERACIONES:
    - Como las excepciones en caso de que la tarjeta no sea valida o la operacion sea no valida pueden desencadenar distinto escenarios opté por crear responses distintos para ambos casos,
      aumentando la repiticion de codigo pero priorizando la escalabilidad

- POSIBLES MEJORAS:
    - Validar que sea obligatorio el campo del monto en el endpoint llamado tasaOperacion
    - Guardar en BBDD de forma encriptada las tarjetas, generando un id automatico
 
## Ejercicios 3 y 4

Respondidos en el mail de entrega.

## Ejercicio 5

Resuelto en la clase EldarApplication.

