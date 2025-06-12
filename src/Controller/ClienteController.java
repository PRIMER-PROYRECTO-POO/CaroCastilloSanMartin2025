package Controller;
import Model.ClienteDAO;
import View.ClienteView;

public class ClienteController {
    private ClienteDAO dao;
    private ClienteView view;

    public ClienteController(){
        view = new ClienteView();
        dao = new ClienteDAO();
    }

    public void iniciar(){
        int opcion;
        do{
            view.mostrarMenu();
            opcion= view.leerOpcion();
            switch (opcion){
                case 1 -> view.mostrarClientes(dao.obtenerTodos());
                case 2 -> dao.crearCliente(view.leerNuevoCliente());
                case 3 -> dao.actualizarCliente(view.leerClienteActualizado());
                case 4 -> dao.eliminarCliente(view.leerIdEliminar());
                case 5 -> System.out.println("¡Adiós!");
                default ->System.out.println("Opción no valida, ingrese otra.");

            }
        }while(opcion != 5);
    }
}