package View;
import Model.Cliente;


import java.util.*;

public class ClienteView {
    private Scanner teclado = new Scanner (System.in);

    public void mostrarMenu(){
        System.out.println("MENU CLIENTES");
        System.out.println("1.- Listar Clientes");
        System.out.println("2.- Crear Clientes");
        System.out.println("3.- Editar Clientes");
        System.out.println("4.- Eliminar Clientes");
        System.out.println("5.- Salir");
        System.out.print("indique una opción: ");
    }

    public void mostrarClientes(List <Cliente> cliente){
        if(cliente.isEmpty()){
            System.out.println("No hay clientes");
        }else{
            cliente.forEach(System.out::println);
        }
    }

    public Cliente leerNuevoCliente(){
        boolean valido = false;
        String nombre = "", rut, telefono;

        while (!valido) {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            if (nombre.matches(".*\\d.*")){
                System.out.println("El nombre no debe contener números. Intente nuevamente.");
            } else {
                valido = true;
            }
        }

        System.out.print("Rut: "); //validación pendiente
        rut = teclado.nextLine();


        System.out.print("telefono: \n+569 ");
        telefono = teclado.nextLine();
        while(!telefono.matches("\\d{8}")){
            System.out.println("Número inválido. Debe contener exactamente 8 dígitos numéricos.");
            System.out.print("telefono: \n+569 ");
            telefono = teclado.nextLine();
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setRut(rut);
        cliente.setTelefono(telefono);

        return cliente;
    }

    public Cliente leerClienteActualizado(){
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        int id = Integer.parseInt(teclado.nextLine());
        Cliente cliente = leerNuevoCliente();
        cliente.setId_clientes(id);
        return cliente;
    }

    public int leerIdEliminar(){
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        String respuesta = teclado.nextLine();
        while(!respuesta.matches("\\d+")){
            System.out.println("Por favor, ingrese la opción en numero sin espacios 🙄");
            System.out.print("Indique opción: ");
            respuesta=teclado.nextLine();
        }
        return Integer.parseInt(respuesta);
    }
}
