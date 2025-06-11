package Controller;
import Model.HerramientaDAO;
import View.HerramientaView;

public class HerramientaController {
    private HerramientaDAO dao;
    private HerramientaView view;

    public HerramientaController(){
        dao = new HerramientaDAO();
        view = new HerramientaView();
    }

    public void iniciar(){
        int opcion;
        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarHerramientas(dao.obtenerTodos());
                case 2 -> dao.crearHerramienta(view.leerNuevaHerramienta());
                case 3 -> dao.actualizarHerramienta(view.leerHerramientaActualizada());
                case 4 -> dao.eliminarHerramienta(view.leerIdEliminar());
                case 5 -> System.out.println("¡Adios!");
            }
        }while(opcion != 5);
    }
}

