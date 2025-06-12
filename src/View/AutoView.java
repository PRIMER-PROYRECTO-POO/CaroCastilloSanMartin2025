package View;
import Model.Auto;
import java.util.*;

public class AutoView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("MENÚ AUTOS");
        System.out.println("1.- Listar Autos");
        System.out.println("2.- Crear Autos");
        System.out.println("3.- Editar Autos");
        System.out.println("4.- Eliminar Autos");
        System.out.println("5.- Salir");
        System.out.print("Indique una opción: ");
    }

    public void mostrarAutos(List<Auto> car){
        if(car.isEmpty()){
            System.out.println("No hay autos");
        }else{
            car.forEach(System.out::println);
        }
    }

    private String leerStringNoVacio(String mensaje) {
        String entrada = "";
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            entrada = teclado.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("ERROR: No puede dejar el campo vacío. Intente nuevamente.");
                continue;
            }

            if (!entrada.matches("[a-zA-Z0-9\\s]+")) {
                System.out.println("ERROR: Solo se permiten letras, números y espacios. Intente nuevamente.");
                continue;
            }

            valido = true;
        }

        return entrada;
    }

    private int leerAnio() {
        int anio = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("Año: ");
            String entrada = teclado.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("ERROR: No puede dejar el campo vacío. Intente nuevamente.");
                continue;
            }

            try {
                anio = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debe ingresar un número entero válido. Intente nuevamente.");
                continue;
            }

            if (anio <= 0) {
                System.out.println("ERROR: El año debe ser positivo (mayor a 0). Intente nuevamente.");
                continue;
            }

            if (anio < 1886 || anio > 2025) {
                System.out.println("ERROR: El año debe estar entre 1886 y 2025. Intente nuevamente.");
                continue;
            }

            valido = true;
        }

        return anio;
    }

    private String leerPatente() {
        String patente = "";
        boolean valido = false;

        while (!valido) {
            System.out.print("Patente (máximo 6 caracteres): ");
            patente = teclado.nextLine().trim();

            if (patente.isEmpty()) {
                System.out.println("ERROR: No puede dejar el campo vacío. Intente nuevamente.");
                continue;
            }

            if (!patente.matches("[A-Za-z0-9]+")) {
                System.out.println("ERROR: La patente solo puede contener letras y números. Intente nuevamente.");
                continue;
            }

            if (patente.length() > 6) {
                System.out.println("ERROR: La patente no puede tener más de 6 caracteres. Intente nuevamente.");
                continue;
            }

            if (patente.length() < 3) {
                System.out.println("ERROR: La patente debe tener al menos 3 caracteres. Intente nuevamente.");
                continue;
            }

            valido = true;
        }

        return patente;
    }


    public Auto leerNuevoAuto(){
        String marca = leerStringNoVacio("Marca: ");
        String modelo = leerStringNoVacio("Modelo: ");
        int anio = leerAnio();
        String patente = leerPatente();

        Auto car = new Auto();
        car.setMarca(marca);
        car.setModelo(modelo);
        car.setAnio(anio);
        car.setPatente(patente);

        return car;
    }

    private int leerIdValido(String mensaje) {
        int id = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("ERROR: No puede dejar el campo vacío. Intente nuevamente.");
                continue;
            }

            try {
                id = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debe ingresar un número entero válido. Intente nuevamente.");
                continue;
            }

            if (id <= 0) {
                System.out.println("ERROR: El ID debe ser positivo (mayor a 0). Intente nuevamente.");
                continue;
            }

            if (id > 999999) {
                System.out.println("ERROR: El ID no puede ser mayor a 999999. Intente nuevamente.");
                continue;
            }

            valido = true;
        }

        return id;
    }

    public Auto leerAutoActualizado(){
        int id = leerIdValido("Ingrese el ID del Auto a actualizar: ");
        Auto car = leerNuevoAuto();
        car.setId_auto(id); // Aquí sí se asigna el ID, porque es una edición
        return car;
    }

    public int leerIdEliminar(){
        return leerIdValido("Ingrese el ID del Auto a eliminar: ");
    }

    public int leerOpcion() {
        int opcion = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                String entrada = teclado.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.out.println("ERROR: No puede dejar el campo vacío. Intente nuevamente.");
                    System.out.print("Indique una opción: ");
                    continue;
                }

                try {
                    opcion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Debe ingresar un número entero válido. Intente nuevamente.");
                    System.out.print("Indique una opción: ");
                    continue;
                }

                if (opcion < 1 || opcion > 5) {
                    System.out.println("ERROR: Opción no válida. Debe elegir entre 1 y 5. Intente nuevamente.");
                    System.out.print("Indique una opción: ");
                    continue;
                }

                esValido = true;
            } catch (Exception e) {
                System.out.println("ERROR inesperado: " + e.getMessage() + ". Intente nuevamente.");
                System.out.print("Indique una opción: ");
            }
        }

        return opcion;
    }
}
