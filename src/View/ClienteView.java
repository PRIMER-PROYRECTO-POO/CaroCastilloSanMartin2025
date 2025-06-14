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

                if (esCadenaVacia(input) || soloEspacios(input)) {
                    System.out.println("Error: El ID no puede estar vacío. Intente nuevamente.");
                    continue;
                }

                if (!soloDigitosCustom(input)) {
                    System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                    continue;
                }

                id = convertirAEntero(input);
                if (id <= 0) {
                    System.out.println("Error: El ID debe ser un número positivo. Intente nuevamente.");
                    continue;
                }

                valido = true;

            } catch (Exception e) {
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

                if (esCadenaVacia(input) || soloEspacios(input)) {
                    System.out.println("Error: Debe seleccionar una opción. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                if (!soloDigitosCustom(input)) {
                    System.out.println("Error: Solo se permiten números. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                opcion = convertirAEntero(input);
                if (opcion <= 0 || opcion > 5) {
                    System.out.println("Error: Opción no válida. Debe seleccionar entre 1 y 5. Intente nuevamente.");
                    mostrarMenu();
                    continue;
                }

                valido = true;

            } catch (Exception e) {
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

            if (esCadenaVacia(nombre) || soloEspacios(nombre)) {
                System.out.println("Error: El nombre no puede estar vacío.");
                continue;
            }

            if (!soloLetrasYEspaciosCustom(nombre)) {
                System.out.println("Error: El nombre solo puede contener letras y espacios.");
                continue;
            }

            if (contarCaracteres(nombre) < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 caracteres.");
                continue;
            }

            valido = true;
        } while (!valido);

        return nombre;
    }

    private String leerRut() {
        String rut;
        boolean valido = false;

        do {
            System.out.print("RUT (formato: 12345678-9): ");
            rut = teclado.nextLine();

            if (esCadenaVacia(rut) || soloEspacios(rut)) {
                System.out.println("Error: El RUT no puede estar vacío.");
                continue;
            }

            if (!validarRut(rut)) {
                System.out.println("Error: Formato de RUT inválido o dígito verificador incorrecto.");
                continue;
            }

            valido = true;
        } while (!valido);

        return convertirAMayusculas(rut);
    }

    private String leerTelefono() {
        String telefono;
        boolean valido = false;

        do {
            System.out.print("Teléfono (########): ");
            telefono = teclado.nextLine();

            if (esCadenaVacia(telefono) || soloEspacios(telefono)) {
                System.out.println("Error: El teléfono no puede estar vacío.");
                continue;
            }

            if (!soloDigitosCustom(telefono)) {
                System.out.println("Error: El teléfono solo puede contener números.");
                continue;
            }

            if (contarCaracteres(telefono) != 8 || primerCaracterMenorA(telefono, '6')) {
                System.out.println("Error: Número de celular inválido. Debe comenzar con 6, 7, 8 o 9 y tener 8 dígitos.");
                continue;
            }

            valido = true;
        } while (!valido);

        return telefono;
    }

    private int leerIdActualizar() {
        int id = 0;
        boolean valido = false;

        do {
            try {
                System.out.print("Ingrese el ID del cliente a actualizar: ");
                String input = teclado.nextLine();

                if (esCadenaVacia(input) || soloEspacios(input)) {
                    System.out.println("Error: El ID no puede estar vacío.");
                    continue;
                }

                if (!soloDigitosCustom(input)) {
                    System.out.println("Error: Solo se permiten números.");
                    continue;
                }

                id = convertirAEntero(input);
                if (id <= 0) {
                    System.out.println("Error: El ID debe ser un número positivo.");
                    continue;
                }

                valido = true;
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        } while (!valido);

        return id;
    }

    private boolean validarRut(String rut) {
        int guionIndex = buscarCaracter(rut, '-');
        if (guionIndex == -1 || guionIndex == 0 || guionIndex == contarCaracteres(rut) - 1) return false;

        String numero = construirSubcadena(rut, 0, guionIndex);
        String dv = convertirAMayusculas(construirSubcadena(rut, guionIndex + 1, contarCaracteres(rut)));

        if (contarCaracteres(numero) < 7 || contarCaracteres(numero) > 8) return false;
        if (contarCaracteres(dv) != 1 || (!esDigito(dv.charAt(0)) && !esK(dv.charAt(0)))) return false;

        return soloDigitosCustom(numero);
    }

    // Métodos utilitarios sin usar métodos nativos prohibidos

    private boolean esCadenaVacia(String texto) {
        return texto != null && contarCaracteres(texto) == 0;
    }

    private boolean soloEspacios(String texto) {
        for (int i = 0; i < contarCaracteres(texto); i++) {
            if (texto.charAt(i) != ' ') return false;
        }
        return true;
    }

    private boolean soloDigitosCustom(String texto) {
        for (int i = 0; i < contarCaracteres(texto); i++) {
            if (!esDigito(texto.charAt(i))) return false;
        }
        return true;
    }

    private boolean esDigito(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean soloLetrasYEspaciosCustom(String texto) {
        String acentos = "áéíóúÁÉÍÓÚñÑ";
        for (int i = 0; i < contarCaracteres(texto); i++) {
            char c = texto.charAt(i);
            if (!(esLetra(c) || c == ' ' || contieneCaracter(acentos, c))) return false;
        }
        return true;
    }

    private boolean contieneCaracter(String cadena, char buscado) {
        for (int i = 0; i < contarCaracteres(cadena); i++) {
            if (cadena.charAt(i) == buscado) return true;
        }
        return false;
    }

    private int buscarCaracter(String cadena, char buscado) {
        for (int i = 0; i < contarCaracteres(cadena); i++) {
            if (cadena.charAt(i) == buscado) return i;
        }
        return -1;
    }

    private int contarCaracteres(String texto) {
        int count = 0;
        try {
            while (true) {
                texto.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Fin de la cadena
        }
        return count;
    }

    private int convertirAEntero(String texto) {
        int resultado = 0;
        for (int i = 0; i < contarCaracteres(texto); i++) {
            resultado = resultado * 10 + (texto.charAt(i) - '0');
        }
        return resultado;
    }

    private String convertirAMayusculas(String texto) {
        String resultado = "";
        for (int i = 0; i < contarCaracteres(texto); i++) {
            char c = texto.charAt(i);
            if (c >= 'a' && c <= 'z') {
                resultado += (char)(c - 32);
            } else {
                resultado += c;
            }
        }
        return resultado;
    }

    private boolean primerCaracterMenorA(String texto, char referencia) {
        return contarCaracteres(texto) > 0 && texto.charAt(0) < referencia;
    }

    private boolean esK(char c) {
        return c == 'K';
    }

    private String construirSubcadena(String texto, int desde, int hasta) {
        String resultado = "";
        for (int i = desde; i < hasta; i++) {
            resultado += texto.charAt(i);
        }
        return resultado;
    }
}
