package View;
import Model.Herramienta;
import java.util.*;

public class HerramientaView {
    private Scanner teclado = new Scanner (System.in);

    public void mostrarMenu(){
        System.out.println("MENÚ HERRAMIENTAS");
        System.out.println("1.- Listar Herramientas");
        System.out.println("2.- Crear Herramientas");
        System.out.println("3.- Editar Herramientas");
        System.out.println("4.- Eliminar Herramientas");
        System.out.println("5.- Salir");
        System.out.print("indique una opcion: ");
    }

    public void mostrarHerramientas(List <Herramienta> herramientas){
        if(herramientas.isEmpty()){
            System.out.println("No hay Herramientas");
        }else{
            herramientas.forEach(System.out::println);
        }
    }

    public Herramienta leerNuevaHerramienta(){
        String nombre = "";
        boolean valido = false;
        while (!valido) {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            if (nombre.matches(".\\d.")) {
                System.out.println("El nombre no debe contener números. Intente nuevamente.");
            } else {
                valido = true;
            }
        }
        System.out.print("Tipo: ");
        String tipo = teclado.nextLine();
        System.out.print("Estado: ");
        String estado = teclado.nextLine();

        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(nombre);
        herramienta.setTipo(tipo);
        herramienta.setEstado(estado);

        return herramienta;
    }

    public Herramienta leerHerramientaActualizada(){
        System.out.print("Ingrese el ID de la herramienta a actualizar: ");
        int id = Integer.parseInt(teclado.nextLine());
        Herramienta herramienta = leerNuevaHerramienta();
        herramienta.setId_herramienta(id);
        return herramienta;
    }

    public int leerIdEliminar(){
        System.out.print("Ingrese ID de la herramienta a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}
