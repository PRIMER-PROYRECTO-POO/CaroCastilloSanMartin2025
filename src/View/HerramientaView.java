package View;
import Model.Herramienta;
import java.util.*;

public class HerramientaView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("MENÚ HERRAMIENTAS");
        System.out.println("1.- Listar Herramientas");
        System.out.println("2.- Crear Herramientas");
        System.out.println("3.- Editar Herramientas");
        System.out.println("4.- Eliminar Herramientas");
        System.out.println("5.- Salir");
        System.out.print("Indique una opción: ");
    }

    public void mostrarHerramientas(List<Herramienta> herramientas){
        if(herramientas.isEmpty()){
            System.out.println("No hay Herramientas");
        }else{
            herramientas.forEach(System.out::println);
        }
    }

    public Herramienta leerNuevaHerramienta(){
        String nombre = leerNombre();
        String tipo = leerTipo();
        String estado = leerEstado();

        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(nombre);
        herramienta.setTipo(tipo);
        herramienta.setEstado(estado);

        return herramienta;
    }

    public Herramienta leerHerramientaActualizada(){
        int id = leerIdActualizar();
        Herramienta herramienta = leerNuevaHerramienta();
        herramienta.setId_herramienta(id);
        return herramienta;
    }

    public int leerIdEliminar(){
        int id = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Ingrese ID de la herramienta a eliminar: ");
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

            // Validación de tipo de dato (letras, números y espacios)
            if (!nombre.trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s]+$")) {
                System.out.println("Error: El nombre solo puede contener letras, números y espacios. Intente nuevamente.");
                continue;
            }

            // Validación de longitud mínima
            if (nombre.trim().length() < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 caracteres. Intente nuevamente.");
                continue;
            }

            // Validación de longitud máxima
            if (nombre.trim().length() > 50) {
                System.out.println("Error: El nombre no puede tener más de 50 caracteres. Intente nuevamente.");
                continue;
            }

            valido = true;

        } while (!valido);

        return nombre.trim();
    }

    // Método para leer y validar tipo
    private String leerTipo() {
        String tipo = "";
        boolean valido = false;
        String[] tiposValidos = {"manual", "electrica", "neumatica", "hidraulica", "mecanica"};

        do {
            System.out.println("Tipos disponibles: manual, electrica, neumatica, hidraulica, mecanica");
            System.out.print("Tipo: ");
            tipo = teclado.nextLine();

            // Validación de vacío
            if (tipo.trim().isEmpty()) {
                System.out.println("Error: El tipo no puede estar vacío. Intente nuevamente.");
                continue;
            }

            // Validación de tipo de dato (solo letras)
            if (!tipo.trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$")) {
                System.out.println("Error: El tipo solo puede contener letras. Intente nuevamente.");
                continue;
            }

            // Validación de opciones disponibles
            boolean tipoValido = false;
            String tipoLower = tipo.trim().toLowerCase();
            for (int i = 0; i < tiposValidos.length; i++) {
                if (tiposValidos[i].equals(tipoLower)) {
                    tipoValido = true;
                    break;
                }
            }

            if (!tipoValido) {
                System.out.println("Error: Tipo no válido. Debe ser uno de los tipos disponibles. Intente nuevamente.");
                continue;
            }

            valido = true;

        } while (!valido);

        return tipo.trim().toLowerCase();
    }

    // Método para leer y validar estado
    private String leerEstado() {
        String estado = "";
        boolean valido = false;
        String[] estadosValidos = {"disponible", "en uso"};

        do {
            System.out.println("Estados disponibles: disponible, en uso");
            System.out.print("Estado: ");
            estado = teclado.nextLine();

            // Validación de vacío
            if (estado.trim().isEmpty()) {
                System.out.println("Error: El estado no puede estar vacío. Intente nuevamente.");
                continue;
            }

            // Validación de tipo de dato (letras y espacios para "en uso")
            if (!estado.trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Error: El estado solo puede contener letras y espacios. Intente nuevamente.");
                continue;
            }

            // Validación de opciones disponibles
            boolean estadoValido = false;
            String estadoLower = estado.trim().toLowerCase();
            for (int i = 0; i < estadosValidos.length; i++) {
                if (estadosValidos[i].equals(estadoLower)) {
                    estadoValido = true;
                    break;
                }
            }

            if (!estadoValido) {
                System.out.println("Error: Estado no válido. Debe ser 'disponible' o 'en uso'. Intente nuevamente.");
                continue;
            }

            valido = true;

        } while (!valido);

        return estado.trim().toLowerCase();
    }

    // Método para leer y validar ID para actualizar
    private int leerIdActualizar() {
        int id = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Ingrese el ID de la herramienta a actualizar: ");
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
}