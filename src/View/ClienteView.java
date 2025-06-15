package View;
import Model.Auto;
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

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        while(!nombre.matches("[a-zA-Z ]+")){
            System.out.print("Nombre no valido, ingreselo nuevamente: ");
            nombre = teclado.nextLine();
        }

        System.out.print("Rut: ");
        String rut = teclado.nextLine();

        while(!rut.matches("^\\d{7,8}-[\\dkK]$")){
            System.out.println("Rut invalido, ingreselo nuevamente (sin puntos y con guion)");
            System.out.print("Rut: ");
            rut = teclado.nextLine();
        }

        String telefono;


            System.out.print("telefono: \n+569 ");
            telefono = teclado.nextLine();

            while(!telefono.matches("\\d{8}")) {

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

    public Cliente leerClienteActualizado(Cliente ClienteExistente) {
        System.out.println("Actualizando Cliente con ID: " + ClienteExistente.getId_clientes());

        Cliente actualizado = leerNuevoCliente(); // se piden los nuevos datos
        actualizado.setId_clientes(ClienteExistente.getId_clientes()); // se conserva el ID original

        return actualizado;
    }

    public int pedirIdCliente() {
        System.out.print("Ingrese el ID del Cliente: ");
        String idPal = teclado.nextLine();

        while(!idPal.matches("\\d+")){
            System.out.println("Id no valido.");
            System.out.print("Ingrese el ID del cliente: ");
            idPal = teclado.nextLine();
        }

        return Integer.parseInt(idPal);
    }

    public String leerOpcion() {
        String respuesta;

        do {
            respuesta = teclado.nextLine();

            if (!respuesta.matches("\\d+")) {
                System.out.println("Ingrese nuevamente el número");
            }

        } while (!respuesta.matches("\\d+"));

        return respuesta;
    }
}
