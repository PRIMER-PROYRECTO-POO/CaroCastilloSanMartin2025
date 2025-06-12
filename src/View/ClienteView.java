package View;
import Model.Cliente;
import Model.Herramienta;

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
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Rut: ");
        String rut = teclado.nextLine();
        System.out.print("telefono: \n+569 ");
        String telefono = teclado.nextLine();

        if(telefono.length() != 8){
            System.out.print("Número no valido, intentelo de nuevo: ");
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
        return Integer.parseInt(teclado.nextLine());
    }
}