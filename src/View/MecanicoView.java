package View;
import Model.Mecanico;
import java.util.*;

public class MecanicoView{
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("MENU MECANICO");
        System.out.println("1.- Listar Mecanicos");
        System.out.println("2.- Crear Mecanicos");
        System.out.println("3.- Editar Mecanicos");
        System.out.println("4.- Eliminar Mecanicos");
        System.out.println("5.- Salir");
        System.out.print("Ingrese una opción: ");
    }

    public void mostrarMecanicos(List<Mecanico> mecanicos){
        if(mecanicos.isEmpty()){
            System.out.println("No hay mecanicos");
        } else {
            mecanicos.forEach(System.out::println);
        }
    }

    // Método para verificar si una cadena está vacía o sólo tiene espacios
    private boolean esVacioOEspacios(String s) {
        if (s == null || s.equals("")) return true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') return false;
        }
        return true;
    }

    // Método para validar que una cadena contiene solo dígitos
    private boolean soloDigitos(String s) {
        if (s == null || s.equals("")) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    // Método para validar que nombre solo contiene letras (mayus y minus), espacios y caracteres con tilde
    private boolean soloLetrasYEspacios(String s) {
        if (s == null || s.equals("")) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!( (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    c == ' ' ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                    c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                    c == 'ñ' || c == 'Ñ')) {
                return false;
            }
        }
        return true;
    }

    // Método para validar que especialidad contiene solo letras mayúsculas y guion bajo
    private boolean soloMayusculasYGuionBajo(String s) {
        if (s == null || s.equals("")) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!( (c >= 'A' && c <= 'Z') || c == '_')) {
                return false;
            }
        }
        return true;
    }

    // VALIDADOR PARA OPCIÓN DEL MENÚ
    public int leerOpcion(){
        boolean valido = false;
        int opcion = 0;

        while (!valido) {
            String entrada = teclado.nextLine();

            if (esVacioOEspacios(entrada)) {
                System.out.println("Error: No puede dejar la opción vacía.");
                System.out.print("Ingrese una opción: ");
                continue;
            }

            if (!soloDigitos(entrada)) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                System.out.print("Ingrese una opción: ");
                continue;
            }

            try {
                opcion = Integer.parseInt(entrada);

                if (opcion <= 0) {
                    System.out.println("Error: Debe ingresar un número positivo.");
                    System.out.print("Ingrese una opción: ");
                    continue;
                }

                if (opcion >= 1 && opcion <= 5) {
                    valido = true;
                } else {
                    System.out.println("Error: Opción no válida. Ingrese un número entre 1 y 5.");
                    System.out.print("Ingrese una opción: ");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                System.out.print("Ingrese una opción: ");
            }
        }

        return opcion;
    }

    // VALIDADOR PARA NOMBRE
    private String validarNombre() {
        boolean valido = false;
        String nombre = "";

        while (!valido) {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            if (esVacioOEspacios(nombre)) {
                System.out.println("Error: El nombre no puede estar vacío.");
                continue;
            }

            if (!soloLetrasYEspacios(nombre)) {
                System.out.println("Error: El nombre solo puede contener letras y espacios.");
                continue;
            }

            if (nombre.length() < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 caracteres.");
                continue;
            }

            if (nombre.length() > 50) {
                System.out.println("Error: El nombre no puede exceder 50 caracteres.");
                continue;
            }

            valido = true;
        }

        return nombre;
    }

    // VALIDADOR PARA ESPECIALIDAD
    private String validarEspecialidad() {
        List<String> especialidadesValidas = Arrays.asList(
                "MOTOR", "FRENOS", "SUSPENSION", "ELECTRICIDAD", "TRANSMISION",
                "AIRE_ACONDICIONADO", "CARROCERIA", "GENERAL"
        );

        int opcion = -1;
        boolean valido = false;

        while (!valido) {
            System.out.println("Seleccione la especialidad:");
            for (int i = 0; i < especialidadesValidas.size(); i++) {
                System.out.println((i + 1) + ". " + especialidadesValidas.get(i));
            }
            System.out.print("Ingrese el número correspondiente: ");
            String entrada = teclado.nextLine();

            if (esVacioOEspacios(entrada)) {
                System.out.println("Error: Debe ingresar un número.");
                continue;
            }

            if (!soloDigitos(entrada)) {
                System.out.println("Error: Solo se permiten números.");
                continue;
            }

            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= especialidadesValidas.size()) {
                    valido = true;
                } else {
                    System.out.println("Error: Debe ingresar un número entre 1 y " + especialidadesValidas.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada inválida.");
            }
        }

        return especialidadesValidas.get(opcion - 1);
    }

    // VALIDADOR PARA AÑOS DE EXPERIENCIA
    private int validarAniosExperiencia() {
        boolean valido = false;
        int anios = 0;

        while (!valido) {
            System.out.print("Años de experiencia (1-50): ");
            String entrada = teclado.nextLine();

            if (esVacioOEspacios(entrada)) {
                System.out.println("Error: Los años de experiencia no pueden estar vacíos.");
                continue;
            }

            if (!soloDigitos(entrada)) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                continue;
            }

            try {
                anios = Integer.parseInt(entrada);

                if (anios <= 0) {
                    System.out.println("Error: Los años de experiencia deben ser un número positivo.");
                    continue;
                }

                if (anios >= 1 && anios <= 50) {
                    valido = true;
                } else {
                    System.out.println("Error: Los años de experiencia deben estar entre 1 y 50.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        }

        return anios;
    }

    // VALIDADOR PARA ID
    private int validarId(String tipoOperacion) {
        boolean valido = false;
        int id = 0;

        while (!valido) {
            System.out.print("Ingrese el ID del mecanico a " + tipoOperacion + ": ");
            String entrada = teclado.nextLine();

            if (esVacioOEspacios(entrada)) {
                System.out.println("Error: El ID no puede estar vacío.");
                continue;
            }

            if (!soloDigitos(entrada)) {
                System.out.println("Error: El ID debe ser un número entero válido.");
                continue;
            }

            try {
                id = Integer.parseInt(entrada);

                if (id <= 0) {
                    System.out.println("Error: El ID debe ser un número positivo.");
                    continue;
                }

                if (id >= 1 && id <= 999999) {
                    valido = true;
                } else {
                    System.out.println("Error: El ID debe estar entre 1 y 999999.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: El ID debe ser un número entero válido.");
            }
        }

        return id;
    }

    public Mecanico leerNuevoMecanico(){
        System.out.println("=== CREAR NUEVO MECÁNICO ===");
        System.out.println("(El ID será asignado automáticamente por el sistema)");

        String nombre = validarNombre();
        String especialidad = validarEspecialidad();
        int anios = validarAniosExperiencia();

        Mecanico mecanico = new Mecanico();
        mecanico.setNombre(nombre);
        mecanico.setEspecialidad(especialidad);
        mecanico.setAnio_experiencia(anios);

        return mecanico;
    }

    public Mecanico leerMecanicoActualizado(){
        System.out.println("=== ACTUALIZAR MECÁNICO ===");
        int id = validarId("actualizar");

        System.out.println("Ingrese los nuevos datos:");
        String nombre = validarNombre();
        String especialidad = validarEspecialidad();
        int anios = validarAniosExperiencia();

        Mecanico mecanico = new Mecanico();
        mecanico.setId_mecanico(id);
        mecanico.setNombre(nombre);
        mecanico.setEspecialidad(especialidad);
        mecanico.setAnio_experiencia(anios);

        return mecanico;
    }

    public int leerIdEliminar() {
        System.out.println("=== ELIMINAR MECÁNICO ===");
        return validarId("eliminar");
    }
}
