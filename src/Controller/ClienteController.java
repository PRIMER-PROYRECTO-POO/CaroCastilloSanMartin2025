package Controller;
import Model.Cliente;
import Model.ClienteDAO;
import View.ClienteView;

public class ClienteController {
    private ClienteDAO dao;
    private ClienteView view;

    public ClienteController(){
        view = new ClienteView();
        dao = new ClienteDAO();
    }

    private void actualizarCliente() {
        int id = view.pedirIdCliente();
        Cliente clienteExistente = dao.buscarClientePorId(id);

        if (clienteExistente != null) {
            Cliente actualizado = view.leerClienteActualizado(clienteExistente);
            dao.actualizarCliente(actualizado);
        } else {
            System.out.println("No se encontró un cliente con ese ID.");
        }
    }

    private void eliminarCliente() {
        int id = view.pedirIdCliente(); // o view.leerIdEliminar(), si ya tienes eso

        Cliente clienteExistente = dao.buscarClientePorId(id);
        while(clienteExistente == null){
            System.out.println("No se encontró un cliente con ese ID. Por favor, volver a ingresar");
            id = view.pedirIdCliente();
            clienteExistente = dao.buscarClientePorId(id);
        }
        dao.eliminarCliente(id);
        System.out.println("Cliente eliminado correctamente.");
    }

    public void iniciar(){
        String opcion;
        do{
            view.mostrarMenu();
            opcion= view.leerOpcion();
            switch (opcion){
                case "1" -> view.mostrarClientes(dao.obtenerTodos());
                case "2" -> dao.crearCliente(view.leerNuevoCliente());
                case "3" -> actualizarCliente();
                case "4" -> eliminarCliente();
                case "5" -> System.out.println("¡Adiós!");
                default ->System.out.println("Opción no valida, ingrese otra.");

            }
        }while(!opcion.equalsIgnoreCase("5"));
    }
}
