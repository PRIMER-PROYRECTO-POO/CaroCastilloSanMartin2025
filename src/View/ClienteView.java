package View;
import Model.Cliente;

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

                if (input.trim().isEmpty()) {
                    System.out.println("Error: El ID no puede estar vacío. Intente nuevamente.");
                    continue;
                }

                id = Integer.parseInt(input.trim());

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

                if (input.trim().isEmpty()) {
                    System.out.println("Error: Debe seleccionar una opción. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                opcion = Integer.parseInt(input.trim());

                if (opcion <= 0 || opcion > 5) {
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

    private String leerNombre() {
        String nombre;
        boolean valido = false;

        do {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            if (nombre.trim().isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
                continue;
            }

            if (!nombre.trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Error: El nombre solo puede contener letras y espacios.");
                continue;
            }

            if (nombre.trim().length() < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 caracteres.");
                continue;
            }

            valido = true;

        } while (!valido);

        return nombre.trim();
    }

    private String leerRut() {
        String rut;
        boolean valido = false;

        do {
            System.out.print("RUT (formato: 12345678-9): ");
            rut = teclado.nextLine();

            if (rut.trim().isEmpty()) {
                System.out.println("Error: El RUT no puede estar vacío.");
                continue;
            }

            if (!rut.trim().matches("^\\d{7,8}-[0-9kK]$")) {
                System.out.println("Error: Formato de RUT inválido.");
                continue;
            }

            if (!validarRut(rut.trim())) {
                System.out.println("Error: RUT inválido. Verifique el dígito verificador.");
                continue;
            }

            valido = true;

        } while (!valido);

        return rut.trim().toUpperCase();
    }

    private String leerTelefono() {
        String telefono;
        boolean valido = false;

        do {
            System.out.print("Teléfono (+569 ########): ");
            telefono = teclado.nextLine();

            if (telefono.trim().isEmpty()) {
                System.out.println("Error: El teléfono no puede estar vacío.");
                continue;
            }

            if (!telefono.trim().matches("^\\d+$")) {
                System.out.println("Error: El teléfono solo puede contener números.");
                continue;
            }

            if (telefono.trim().length() != 8) {
                System.out.println("Error: El teléfono debe tener exactamente 8 dígitos.");
                continue;
            }

            if (!telefono.trim().matches("^[6-9]\\d{7}$")) {
                System.out.println("Error: Número de celular inválido. Debe comenzar con 6, 7, 8 o 9.");
                continue;
            }

            valido = true;

        } while (!valido);

        return telefono.trim();
    }

    private int leerIdActualizar() {
        int id = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Ingrese el ID del cliente a actualizar: ");
                String input = teclado.nextLine();

                if (input.trim().isEmpty()) {
                    System.out.println("Error: El ID no puede estar vacío.");
                    continue;
                }

                id = Integer.parseInt(input.trim());

                if (id <= 0) {
                    System.out.println("Error: El ID debe ser un número positivo.");
                    continue;
                }

                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        } while (!valido);

        return id;
    }

    private boolean validarRut(String rut) {
        String[] partes = rut.split("-");
        if (partes.length != 2) return false;

        String numero = partes[0];
        String dv = partes[1].toUpperCase();

        if (numero.length() < 7 || numero.length() > 8) return false;
        if (!dv.matches("[0-9K]")) return false;
        if (!numero.matches("\\d+")) return false;

        return true;
    }
}
