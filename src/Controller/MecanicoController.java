package Controller;
import Model.Mecanico;
import Model.MecanicoDAO;
import View.MecanicoView;

public class MecanicoController {
    private MecanicoDAO dao;
    private MecanicoView view;

    public MecanicoController(){
        dao = new MecanicoDAO();
        view = new MecanicoView();
    }

    private void actualizarMecanico() {
        int id = view.pedirIdMecanico();
        Mecanico MecanicoExistente = dao.buscarMecanicoPorId(id);

        if (MecanicoExistente != null) {
            Mecanico actualizado = view.leerMecanicoActualizado(MecanicoExistente);
            dao.actualizarMecanico(actualizado);
        } else {
            System.out.println("No se encontró un mecanico con ese ID.");
        }
    }

    private void eliminarMecanico() {
        int id = view.pedirIdMecanico(); // o view.leerIdEliminar(), si ya tienes eso

        Mecanico MecanicoExistente = dao.buscarMecanicoPorId(id);
        while(MecanicoExistente == null){
            System.out.println("No se encontró un mecanico con ese ID. Por favor, volver a ingresar");
            id = view.pedirIdMecanico();
            MecanicoExistente = dao.buscarMecanicoPorId(id);
        }
        dao.eliminarMecanico(id);
        System.out.println("Mecanico eliminado correctamente.");
    }

    public void iniciar(){
        String opcion;
        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();

            switch (opcion){
                case "1" -> view.mostrarMecanicos(dao.obtenerTodos());
                case "2" -> dao.crearMecanico(view.leerNuevoMecanico());
                case "3" -> actualizarMecanico();
                case "4" -> eliminarMecanico();
                case "5" -> System.out.println("¡Adios!");
                default ->System.out.println("Opción no valida, ingrese otra.");
            }
        }while(!opcion.equalsIgnoreCase("5"));
    }
}
