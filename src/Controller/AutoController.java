package Controller;
import Model.AutoDAO;
import View.AutoView;

public class AutoController {
    private AutoDAO dao;
    private AutoView view;

    public AutoController(){
        dao = new AutoDAO();
        view = new AutoView();
    }

    public void iniciar() {
        int opcion;
        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarAutos(dao.obtenerTodos());
                case 2 -> dao.crearAuto(view.leerNuevoAuto());
                case 3 -> dao.actualizarAuto(view.leerAutoActualizado());
                case 4 -> dao.eliminarAuto(view.leerIdEliminar());
                case 5 -> System.out.println("¡Adios!");
            }
        } while (opcion != 5);
    }
}
