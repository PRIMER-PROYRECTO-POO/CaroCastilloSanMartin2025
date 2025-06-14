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

                if (esCadenaVacia(input)) {
                    System.out.println("Error: El ID no puede estar vacío. Intente nuevamente.");
                    continue;
                }

                id = Integer.parseInt(input);

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

                if (esCadenaVacia(input)) {
                    System.out.println("Error: Debe seleccionar una opción. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                opcion = Integer.parseInt(input);

                if (opcion <= 0) {
                    System.out.println("Error: Debe ingresar un número positivo. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

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

    private String leerNombre() {
        String nombre = "";
        boolean valido = false;

        do {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            if (esCadenaVacia(nombre)) {
                System.out.println("Error: El nombre no puede estar vacío. Intente nuevamente.");
                continue;
            }

            if (!esNombreValido(nombre)) {
                System.out.println("Error: El nombre solo puede contener letras, números y espacios. Intente nuevamente.");
                continue;
            }

            if (nombre.length() < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 caracteres. Intente nuevamente.");
                continue;
            }

            if (nombre.length() > 50) {
                System.out.println("Error: El nombre no puede tener más de 50 caracteres. Intente nuevamente.");
                continue;
            }

            valido = true;

        } while (!valido);

        return nombre;
    }

    private String leerTipo() {
        String tipo = "";
        boolean valido = false;
        String[] tiposValidos = {"manual", "electrica", "neumatica", "hidraulica", "mecanica"};

        do {
            System.out.println("Tipos disponibles: manual, electrica, neumatica, hidraulica, mecanica");
            System.out.print("Tipo: ");
            tipo = teclado.nextLine();

            if (esCadenaVacia(tipo)) {
                System.out.println("Error: El tipo no puede estar vacío. Intente nuevamente.");
                continue;
            }

            if (!esTipoValidoFormato(tipo)) {
                System.out.println("Error: El tipo solo puede contener letras. Intente nuevamente.");
                continue;
            }

            boolean tipoValido = false;
            String tipoMinus = tipo.toLowerCase();
            for (String t : tiposValidos) {
                if (t.equals(tipoMinus)) {
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

        return tipo.toLowerCase();
    }

    private String leerEstado() {
        int opcion = 0;
        boolean valido = false;

        do {
            System.out.println("Seleccione estado:");
            System.out.println("[1] Disponible");
            System.out.println("[2] En uso");
            System.out.print("Ingrese opción (1 o 2): ");

            String input = teclado.nextLine();

            if (esCadenaVacia(input)) {
                System.out.println("Error: Debe seleccionar una opción. Intente nuevamente.");
                continue;
            }

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido (1 o 2). Intente nuevamente.");
                continue;
            }

            if (opcion != 1 && opcion != 2) {
                System.out.println("Error: Opción no válida. Debe seleccionar 1 o 2. Intente nuevamente.");
                continue;
            }

            valido = true;
        } while (!valido);

        if (opcion == 1) {
            return "disponible";
        } else {
            return "en uso";
        }
    }

    private int leerIdActualizar() {
        int id = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Ingrese el ID de la herramienta a actualizar: ");
                String input = teclado.nextLine();

                if (esCadenaVacia(input)) {
                    System.out.println("Error: El ID no puede estar vacío. Intente nuevamente.");
                    continue;
                }

                id = Integer.parseInt(input);

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

    // FUNCIONES AUXILIARES

    private boolean esCadenaVacia(String s) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') return false;
        }
        return true;
    }

    private boolean esNombreValido(String s) {
        // Solo letras (mayúsc/minúsc), números, espacios y letras con acento, ñ
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9') || c == ' ' ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                    c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                    c == 'ñ' || c == 'Ñ' )) {
                return false;
            }
        }
        return true;
    }

    private boolean esTipoValidoFormato(String s) {
        // Solo letras (mayúsc/minúsc) y letras con acento, ñ, sin espacios
        if (s == null || s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                    c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                    c == 'ñ' || c == 'Ñ')) {
                return false;
            }
        }
        return true;
    }
}
