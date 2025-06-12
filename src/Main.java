import Controller.ClienteController;
import Controller.MecanicoController;
import Controller.HerramientaController;
import Controller.AutoController;
import java.util.*;


public class Main {
    static Scanner teclado = new Scanner (System.in);
    public static void main (String [] args){
        int op;


        do {
            System.out.println("MENU PRINCIPAL\n1)Gestionar Auto\n2)Gestionar Clientes\n3)Gestionar Herramientas\n4)Gestionar Mecanico\n5)Salir");
            System.out.print("Indique una opción: ");
            op =validarOpcionMenu();//validando la opcion
            switch (op) {
                case 1:
                    new AutoController().iniciar();
                    break;
                case 2:
                    new ClienteController().iniciar();
                    break;
                case 3:
                    new HerramientaController().iniciar();
                    break;
                case 4:
                    new MecanicoController().iniciar();
                    break;
                case 5:
                    System.out.println("¡Adios!");
                    break;
                default:
                    System.out.println("Opción no valida, ingrese otra.");

            }
        }while(op != 5);
    }

    public static int validarOpcionMenu() {
        int opcion = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                System.out.print("Indique una opción (1-5): ");
                String entrada = Main.teclado.nextLine().trim();

                // 3. Validador de vacío
                if (entrada.isEmpty()) {
                    System.out.println("ERROR: No puede dejar el campo vacío. Intente nuevamente.");
                    continue;
                }

                // 2. Validador de tipo de datos
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Debe ingresar un número entero válido. Intente nuevamente.");
                    continue;
                }

                // 1. Validador de cantidades positivas
                if (opcion <= 0) {
                    System.out.println("ERROR: El número debe ser positivo (mayor a 0). Intente nuevamente.");
                    continue;
                }

                // 4. Validador de opciones disponibles
                if (opcion < 1 || opcion > 5) {
                    System.out.println(" ERROR: Opción no válida. Debe elegir entre 1 y 5. Intente nuevamente.");
                    continue;
                }

                // Si llegamos aquí, la opción es válida
                esValido = true;
                System.out.println("Opción válida seleccionada: " + opcion);

            } catch (Exception e) {
                System.out.println("ERROR inesperado: " + e.getMessage() + ". Intente nuevamente.");
            }
        }

        return opcion;
    }




}
