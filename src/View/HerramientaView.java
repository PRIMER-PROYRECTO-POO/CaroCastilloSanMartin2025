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

    public Herramienta leerNuevaHerramienta() {
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        while (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}")) {
            System.out.print("Nombre no valido, Ingreselo nuevamente (Máximo 25 caracteres): ");
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
        }

        System.out.print("Tipo: ");
        String tipo = teclado.nextLine();

        while (!tipo.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}")) {
            System.out.print("Tipo no valido, Ingreselo nuevamente (Máximo 25 caracteres): ");
            System.out.print("Tipo: ");
            tipo = teclado.nextLine();
        }

        System.out.println("Estado:\n1)Disponible\t2)En uso ");
        String estado = teclado.nextLine();

        while (!estado.matches("[1-2]")) {
            System.out.println("Estado no valido, ingreselo nuevamente.");
            System.out.println("Estado:\n1)Disponible\t2)En uso ");
            estado = teclado.nextLine();
        }

        if(estado.equals("1")){
            estado = "Disponible";
        } else if(estado.equals("2")){
            estado = "En uso";
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
