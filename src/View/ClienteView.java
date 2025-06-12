package View;
import Model.Cliente;
import Model.Herramienta;

import java.util.*;

public class ClienteView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("MENU CLIENTES");
        System.out.println("1.- Listar Clientes");
        System.out.println("2.- Crear Clientes");
        System.out.println("3.- Editar Clientes");
        System.out.println("4.- Eliminar Clientes");
        System.out.println("5.- Salir");
        System.out.print("Indique una opción: ");
    }

    public void mostrarClientes(List<Cliente> cliente){
        if(cliente.isEmpty()){
            System.out.println("No hay clientes");
        }else{
            cliente.forEach(System.out::println);
        }
    }

    public Cliente leerNuevoCliente(){
        String nombre = leerNombre();
        String rut = leerRut();
        String telefono = leerTelefono();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setRut(rut);
        cliente.setTelefono(telefono);

        return cliente;
    }

    public Cliente leerClienteActualizado(){
        int id = leerIdActualizar();
        Cliente cliente = leerNuevoCliente();
        cliente.setId_clientes(id);
        return cliente;
    }

    public int leerIdEliminar(){
        int id = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Ingrese el ID del cliente a eliminar: ");
                String input = teclado.nextLine();

                // Validación de vacío
                if (input.trim().isEmpty()) {
                    System.out.println("Error: El ID no puede estar vacío. Intente nuevamente.");
                    continue;
                }

                // Validación de tipo de dato
                id = Integer.parseInt(input.trim());

                // Validación de cantidad positiva
                if (id <= 0) {
                    System.out.println("Error: El ID debe ser un número positivo. Intente nuevamente.");
                    continue;
                }

                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
            }
        } while (!valido);

        return id;
    }

    public int leerOpcion(){
        int opcion = 0;
        boolean valido = false;

        do {
            try {
                String input = teclado.nextLine();

                // Validación de vacío
                if (input.trim().isEmpty()) {
                    System.out.println("Error: Debe seleccionar una opción. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                // Validación de tipo de dato
                opcion = Integer.parseInt(input.trim());

                // Validación de cantidad positiva
                if (opcion <= 0) {
                    System.out.println("Error: Debe ingresar un número positivo. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                // Validación de opciones disponibles
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Error: Opción no válida. Debe seleccionar entre 1 y 5. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                mostrarMenu();
            }
        } while (!valido);

        return opcion;
    }

    // Método para leer y validar nombre
    private String leerNombre() {
        String nombre = "";
        boolean valido = false;

        do {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            // Validación de vacío
            if (nombre.trim().isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío. Intente nuevamente.");
                continue;
            }

            // Validación de tipo de dato (solo letras y espacios)
            if (!nombre.trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Error: El nombre solo puede contener letras y espacios. Intente nuevamente.");
                continue;
            }

            // Validación de longitud mínima
            if (nombre.trim().length() < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 caracteres. Intente nuevamente.");
                continue;
            }

            valido = true;

        } while (!valido);

        return nombre.trim();
    }

    // Método para leer y validar RUT
    private String leerRut() {
        String rut = "";
        boolean valido = false;

        do {
            System.out.print("RUT (formato: 12345678-9): ");
            rut = teclado.nextLine();

            // Validación de vacío
            if (rut.trim().isEmpty()) {
                System.out.println("Error: El RUT no puede estar vacío. Intente nuevamente.");
                continue;
            }

            // Validación de formato (tipo de dato)
            if (!rut.trim().matches("^\\d{7,8}-[0-9kK]$")) {
                System.out.println("Error: Formato de RUT inválido. Use el formato 12345678-9. Intente nuevamente.");
                continue;
            }

            // Validación de RUT válido (algoritmo básico)
            if (!validarRut(rut.trim())) {
                System.out.println("Error: RUT inválido. Verifique el dígito verificador. Intente nuevamente.");
                continue;
            }

            valido = true;

        } while (!valido);

        return rut.trim().toUpperCase();
    }

    // Método para leer y validar teléfono
    private String leerTelefono() {
        String telefono = "";
        boolean valido = false;

        do {
            System.out.print("Teléfono (+569 ########): ");
            telefono = teclado.nextLine();

            // Validación de vacío
            if (telefono.trim().isEmpty()) {
                System.out.println("Error: El teléfono no puede estar vacío. Intente nuevamente.");
                continue;
            }

            // Validación de tipo de dato (solo números)
            if (!telefono.trim().matches("^\\d+$")) {
                System.out.println("Error: El teléfono solo puede contener números. Intente nuevamente.");
                continue;
            }

            // Validación de longitud exacta
            if (telefono.trim().length() != 8) {
                System.out.println("Error: El teléfono debe tener exactamente 8 dígitos. Intente nuevamente.");
                continue;
            }

            // Validación de que sea un número de celular válido en Chile
            if (!telefono.trim().matches("^[6-9]\\d{7}$")) {
                System.out.println("Error: Número de celular inválido. Debe comenzar con 6, 7, 8 o 9. Intente nuevamente.");
                continue;
            }

            valido = true;

        } while (!valido);

        return telefono.trim();
    }

    // Método para leer y validar ID para actualizar
    private int leerIdActualizar() {
        int id = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Ingrese el ID del cliente a actualizar: ");
                String input = teclado.nextLine();

                // Validación de vacío
                if (input.trim().isEmpty()) {
                    System.out.println("Error: El ID no puede estar vacío. Intente nuevamente.");
                    continue;
                }

                // Validación de tipo de dato
                id = Integer.parseInt(input.trim());

                // Validación de cantidad positiva
                if (id <= 0) {
                    System.out.println("Error: El ID debe ser un número positivo. Intente nuevamente.");
                    continue;
                }

                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
            }
        } while (!valido);

        return id;
    }

    // Método auxiliar para validar RUT chileno
    private boolean validarRut(String rut) {
        // Separar el RUT en número y dígito verificador
        String[] partes = rut.split("-");

        // Debe tener exactamente 2 partes (número y dígito)
        if (partes.length != 2) {
            return false;
        }

        String numero = partes[0];
        String dv = partes[1].toUpperCase();

        // El número debe tener entre 7 y 8 dígitos
        if (numero.length() < 7 || numero.length() > 8) {
            return false;
        }

        // El dígito verificador debe ser un número del 0-9 o la letra K
        if (!dv.equals("0") && !dv.equals("1") && !dv.equals("2") &&
                !dv.equals("3") && !dv.equals("4") && !dv.equals("5") &&
                !dv.equals("6") && !dv.equals("7") && !dv.equals("8") &&
                !dv.equals("9") && !dv.equals("K")) {
            return false;
        }

        // Verificar que cada caracter del número sea un dígito
        for (int i = 0; i < numero.length(); i++) {
            char caracter = numero.charAt(i);
            if (caracter < '0' || caracter > '9') {
                return false;
            }
        }

        return true;
    }
}