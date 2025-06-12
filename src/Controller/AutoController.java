package Controller;
import Model.Auto;
import Model.AutoDAO;
import View.AutoView;

import java.sql.Connection;

public class AutoController {
    private AutoDAO dao;
    private AutoView view;

    public AutoController() {
        dao = new AutoDAO();
        view = new AutoView();
    }

    private void actualizarAuto() {
        int id = view.pedirIdAuto();
        Auto autoExistente = dao.buscarAutoPorId(id);

        if (autoExistente != null) {
            Auto actualizado = view.leerAutoActualizado(autoExistente);
            dao.actualizarAuto(actualizado);
        } else {
            System.out.println("No se encontró un auto con ese ID.");
        }
    }

    private void eliminarAuto() {
        int id = view.pedirIdAuto(); // o view.leerIdEliminar(), si ya tienes eso

        Auto autoExistente = dao.buscarAutoPorId(id);

        if (autoExistente != null) {
            dao.eliminarAuto(id);
            System.out.println("Auto eliminado correctamente.");
        } else {
            System.out.println("No se encontró un auto con ese ID.");
        }
    }


    public void iniciar() {
        int opcion;
        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarAutos(dao.obtenerTodos());
                case 2 -> dao.crearAuto(view.leerNuevoAuto());
                case 3 -> actualizarAuto();
                case 4 -> eliminarAuto();
                case 5 -> System.out.println("¡Adios!");
                default ->System.out.println("Opción no valida, ingrese otra.");
            }
        } while (opcion != 5);
    }
}
