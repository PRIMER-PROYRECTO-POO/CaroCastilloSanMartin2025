package Controller;
import Model.Herramienta;
import Model.HerramientaDAO;
import View.HerramientaView;

public class HerramientaController {
    private HerramientaDAO dao;
    private HerramientaView view;

    public HerramientaController(){
        dao = new HerramientaDAO();
        view = new HerramientaView();
    }

    private void actualizarHerramienta() {
        int id = view.pedirIdHerramienta();
        Herramienta herramientaExistente = dao.buscarHerramientaPorId(id);

        if (herramientaExistente != null) {
            Herramienta actualizado = view.leerHerramientaActualizado(herramientaExistente);
            dao.actualizarHerramienta(actualizado);
        } else {
            System.out.println("No se encontró una herramienta con ese ID.");
        }
    }

    private void eliminarHerramienta() {
        int id = view.pedirIdHerramienta(); // o view.leerIdEliminar(), si ya tienes eso

        Herramienta HerramientaExistente = dao.buscarHerramientaPorId(id);
        while(HerramientaExistente == null){
            System.out.println("No se encontró una herramienta con ese ID. Por favor, volver a ingresar");
            id = view.pedirIdHerramienta();
            HerramientaExistente = dao.buscarHerramientaPorId(id);
        }
        dao.eliminarHerramienta(id);
        System.out.println("Herramienta eliminada correctamente.");
    }


    public void iniciar(){
        String opcion;
        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();
            switch (opcion) {
                case "1" -> view.mostrarHerramientas(dao.obtenerTodos());
                case "2" -> dao.crearHerramienta(view.leerNuevaHerramienta());
                case "3" -> actualizarHerramienta();
                case "4" -> eliminarHerramienta();
                case "5" -> System.out.println("¡Adios!");
                default ->System.out.println("Opción no valida, ingrese otra.");

            }
        }while(!opcion.equalsIgnoreCase("5"));
    }
}

