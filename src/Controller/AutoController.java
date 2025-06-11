package Controller;
import Model.AutoDAO;
import View.AutoView;

public class AutoController {
    private AutoDAO dao;
    private AutoView view;

    //constructor
    public AutoController() {
        dao= new AutoDAO();
        view=new AutoView();
    }
    public void iniciar(){
        int opcion;
        do{
            view.mostrarMenu();
            opcion=view.leerOpcion();

            //falta DAO PARA MODIFICAR
            switch (opcion){
                case 1 -> view.(dao.obtenerTodos());
                case 2 -> dao.(view.leerNuevoEquipo());
                case 3 -> dao.actualizarEquipo(view.leerEquipoActualizado());
                case 4 -> dao.eliminarEquipo(view.leerIdEliminar());
                case 5 -> System.out.println("adios....");
            }
        }while(opcion !=5);
    }
}
