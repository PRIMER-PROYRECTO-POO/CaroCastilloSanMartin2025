package View;
import Model.Cliente;
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
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        while(!nombre.matches("[a-z-A-Z ]+")){
            System.out.println("Nombre no valido, ingreselo nuevamente.");
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
        }

        System.out.print("Tipo: ");
        String tipo = teclado.nextLine();

        while(!tipo.matches("[a-zA-Z ]+")){
            System.out.println("Tipo no valido, ingreselo nuevamente.");
            System.out.print("Tipo: ");
            tipo = teclado.nextLine();
        }

        System.out.println("Estado:\n1)Disponible\t2)Ocupado ");
        String estado = teclado.nextLine();

        while(!estado.equalsIgnoreCase("Disponible") && !estado.equalsIgnoreCase("Ocupado")) {
                System.out.println("Estado invalido, ingreselo nuevamente.");
                System.out.println("1)Disponible\t2)Ocupado ");
                estado = teclado.nextLine();
        }


        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(nombre);
        herramienta.setTipo(tipo);
        herramienta.setEstado(estado);

        return herramienta;
    }

    public Herramienta leerHerramientaActualizado(Herramienta HerramientaExistente) {
        System.out.println("Actualizando Herramienta con ID: " + HerramientaExistente.getId_herramienta());

        Herramienta actualizado = leerNuevaHerramienta(); // se piden los nuevos datos
        actualizado.setId_herramienta(HerramientaExistente.getId_herramienta()); // se conserva el ID original

        return actualizado;
    }

    public int pedirIdHerramienta() {
        System.out.print("Ingrese el ID de la Herramienta: ");
        String idPal = teclado.nextLine();

        while(!idPal.matches("\\d+")){
            System.out.println("Id no valido.");
            System.out.print("Ingrese el ID de la herramienta: ");
            idPal = teclado.nextLine();
        }

        return Integer.parseInt(idPal);
    }

    public String leerOpcion() {
        String respuesta;

        do {
            respuesta = teclado.nextLine();

            if (!respuesta.matches("\\d+")) {
                System.out.println("Ingrese nuevamente el número");
            }

        } while (!respuesta.matches("\\d+"));

        return respuesta;
    }
}
