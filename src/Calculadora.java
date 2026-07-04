void main() {
    IO.println("-".repeat(20));
    IO.println(String.format("Hola mundo"));
    IO.println("-------PUCE-------");
    IO.println("-".repeat(20));

    String opcion = "";

    // Ciclo principal del menú (se repite hasta que el usuario digite "0")
    while (!Objects.equals(opcion, "0")) {
        IO.println("\n--- MENÚ CALCULADORA ---");
        IO.println("1. Suma\n2. Resta\n3. Multiplicación\n4. División\n0. Salir");

        opcion = IO.readln("Ingrese su opción: ");

        // Si el usuario elige salir, rompemos el ciclo directamente
        if (Objects.equals(opcion, "0")) {
            IO.println("¡Gracias por usar la calculadora! Saliendo...");
            break;
        }

        // Variables para los números de la operación
        int numero1 = 0;
        int numero2 = 0;

        // Estructura de control para decidir qué operación realizar
        switch (opcion) {
            case "1": {
                IO.println("---- Suma ----");
                numero1 = pedirNumero("Ingrese el primer valor: ");
                numero2 = pedirNumero("Ingrese el segundo valor: ");

                int resultado = numero1 + numero2;
                IO.println(String.format("El resultado de %s + %s = %s", numero1, numero2, resultado));
                break;
            }
            case "2": {
                IO.println("---- Resta ----");
                numero1 = pedirNumero("Ingrese el primer valor: ");
                numero2 = pedirNumero("Ingrese el segundo valor: ");

                int resultado = numero1 - numero2;
                IO.println(String.format("El resultado de %s - %s = %s", numero1, numero2, resultado));
                break;
            }
            case "3": {
                IO.println("---- Multiplicación ----");
                numero1 = pedirNumero("Ingrese el primer valor: ");
                numero2 = pedirNumero("Ingrese el segundo valor: ");

                int resultado = numero1 * numero2;
                IO.println(String.format("El resultado de %s * %s = %s", numero1, numero2, resultado));
                break;
            }
            case "4": {
                IO.println("---- División ----");
                numero1 = pedirNumero("Ingrese el primer valor: ");

                // Bucle especial para la división: no permitir que el segundo número sea 0
                while (true) {
                    numero2 = pedirNumero("Ingrese el segundo valor: ");
                    if (numero2 != 0) {
                        break; // Si no es cero, salimos del bucle
                    }
                    IO.println("Error: No es posible dividir entre cero. Intenta con otro número.");
                }

                // Usamos double para que la división muestre decimales si es necesario
                double resultado = (double) numero1 / numero2;
                IO.println(String.format("El resultado de %s / %s = %s", numero1, numero2, resultado));
                break;
            }
            default: {
                IO.println("Opción no válida. Por favor, selecciona una opción del menú (0-4).");
                break;
            }
        }
    }
}

/**
 * Función auxiliar para reutilizar la lógica del try-catch de forma limpia
 * sin tener que repetir el mismo bloque de código gigante para cada número.
 */
int pedirNumero(String mensaje) {
    int numero = 0;
    while (true) {
        try {
            String texto = IO.readln(mensaje);
            numero = Integer.parseInt(texto);
            break; // Rompe el bucle si la conversión fue exitosa
        } catch (NumberFormatException e) {
            IO.println("Error: ¡Debes ingresar un número válido, no letras!");
        }
    }
    return numero;
}// Cambio para modulo de resta 
// Cambio para modulo de multiplicacion 
