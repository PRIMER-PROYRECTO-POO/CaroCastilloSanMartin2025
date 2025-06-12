package Controller;
import Model.MecanicoDAO;
import View.MecanicoView;

public class MecanicoController {
    private MecanicoDAO dao;
    private MecanicoView view;

    public MecanicoController(){
        dao = new MecanicoDAO();
        view = new MecanicoView();
    }

    public void iniciar(){
        int opcion;

        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();
            switch (opcion){
                case 1 -> view.mostrarMecanicos(dao.obtenerTodos());
                case 2 -> dao.crearMecanico(view.leerNuevoMecanico());
                case 3 -> dao.actualizarMecanico(view.leerMecanicoActualizado());
                case 4 -> dao.eliminarMecanico(view.leerIdEliminar());
                case 5 -> System.out.println("¡Adios!");
                default ->System.out.println("Opción no valida, ingrese otra.");


            }
        }while(opcion != 5);
    }
}
