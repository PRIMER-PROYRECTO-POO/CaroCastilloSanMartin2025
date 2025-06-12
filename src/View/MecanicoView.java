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

    // VALIDADOR PARA OPCIÓN DEL MENÚ
    public int leerOpcion(){
        boolean valido = false;
        int opcion = 0;

        while (!valido) {
            String entrada = teclado.nextLine().trim();

            // 3. Validador de vacío
            if (entrada.isEmpty()) {
                System.out.println("Error: No puede dejar la opción vacía.");
                System.out.print("Ingrese una opción: ");
                continue;
            }

            try {
                // 2. Tipo de datos
                opcion = Integer.parseInt(entrada);

                // 1. Cantidades positivas
                if (opcion <= 0) {
                    System.out.println("Error: Debe ingresar un número positivo.");
                    System.out.print("Ingrese una opción: ");
                    continue;
                }

                // 4. Opciones disponibles
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
            nombre = teclado.nextLine().trim();

            // 3. Validador de vacío
            if (nombre.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
                continue;
            }

            // 2. Tipo de datos (solo letras y espacios)
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("Error: El nombre solo puede contener letras y espacios.");
                continue;
            }

            // 1. Cantidades positivas (longitud mínima)
            if (nombre.length() < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 caracteres.");
                continue;
            }

            // 4. Opciones disponibles (longitud máxima)
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
        boolean valido = false;
        String especialidad = "";
        List<String> especialidadesValidas = Arrays.asList(
                "MOTOR", "FRENOS", "SUSPENSION", "ELECTRICIDAD", "TRANSMISION",
                "AIRE_ACONDICIONADO", "CARROCERIA", "GENERAL"
        );

        while (!valido) {
            System.out.println("Especialidades disponibles: " + String.join(", ", especialidadesValidas));
            System.out.print("Especialidad: ");
            especialidad = teclado.nextLine().trim().toUpperCase();

            // 3. Validador de vacío
            if (especialidad.isEmpty()) {
                System.out.println("Error: La especialidad no puede estar vacía.");
                continue;
            }

            // 2. Tipo de datos (solo letras, números y guiones bajos)
            if (!especialidad.matches("^[A-Z_]+$")) {
                System.out.println("Error: La especialidad solo puede contener letras mayúsculas y guiones bajos.");
                continue;
            }

            // 1. Cantidades positivas (longitud mínima)
            if (especialidad.length() < 3) {
                System.out.println("Error: La especialidad debe tener al menos 3 caracteres.");
                continue;
            }

            // 4. Opciones disponibles
            if (especialidadesValidas.contains(especialidad)) {
                valido = true;
            } else {
                System.out.println("Error: Especialidad no válida. Seleccione una de las opciones disponibles.");
            }
        }

        return especialidad;
    }

    // VALIDADOR PARA AÑOS DE EXPERIENCIA
    private int validarAniosExperiencia() {
        boolean valido = false;
        int anios = 0;

        while (!valido) {
            System.out.print("Años de experiencia (1-50): ");
            String entrada = teclado.nextLine().trim();

            // 3. Validador de vacío
            if (entrada.isEmpty()) {
                System.out.println("Error: Los años de experiencia no pueden estar vacíos.");
                continue;
            }

            try {
                // 2. Tipo de datos
                anios = Integer.parseInt(entrada);

                // 1. Cantidades positivas
                if (anios <= 0) {
                    System.out.println("Error: Los años de experiencia deben ser un número positivo.");
                    continue;
                }

                // 4. Opciones disponibles (rango válido)
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
            String entrada = teclado.nextLine().trim();

            // 3. Validador de vacío
            if (entrada.isEmpty()) {
                System.out.println("Error: El ID no puede estar vacío.");
                continue;
            }

            try {
                // 2. Tipo de datos
                id = Integer.parseInt(entrada);

                // 1. Cantidades positivas
                if (id <= 0) {
                    System.out.println("Error: El ID debe ser un número positivo.");
                    continue;
                }

                // 4. Opciones disponibles (rango válido para ID)
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