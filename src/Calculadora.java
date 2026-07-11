void main() {
    IO.println("-".repeat(20));
    IO.println("-------PUCE-------");
    IO.println("----Calculadora----");
    IO.println("-".repeat(20));

    String opcion = "";

    while (!Objects.equals(opcion, "0")) { //Otra forma de establecer un bucle es con do/while. La diferencia recae en que while evalúa la condición antes de ejecutar el bloque de código, mientars que do/while ejecuta el bloque de código antes de evaluar la condición.
        IO.println("\n--- MENÚ CALCULADORA ---");
        IO.println("1. Suma\n2. Resta\n3. Multiplicación\n4. División\n0. Salir");

        opcion = IO.readln("Ingrese su opción: "); //Otra forma de imprimir texto es con System.out.println("");

        if (Objects.equals(opcion, "0")) {
            IO.println("¡Gracias por usar la calculadora! Saliendo...");
            break;
        }

        int numero1 = 0;
        int numero2 = 0;

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

                while (true) {
                    numero2 = pedirNumero("Ingrese el segundo valor: ");
                    if (numero2 != 0) {
                        break;
                    }
                    IO.println("Error: No es posible dividir entre cero. Intenta con otro número.");
                }

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
            break;
        } catch (NumberFormatException e) {
            IO.println("Error: ¡Debes ingresar un número válido, no letras!");
        }
    }
    return numero;
}
