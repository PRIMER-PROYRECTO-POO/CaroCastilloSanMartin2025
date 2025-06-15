package View;
import Model.Herramienta;
import Model.Mecanico;
import java.util.*;

public class MecanicoView{
    private Scanner teclado = new Scanner (System.in);

    public void mostrarMenu(){
        System.out.println("MENU MECANICO");
        System.out.println("1.- Listar Mecanicos");
        System.out.println("2.- Crear Mecanicos");
        System.out.println("3.- Editar Mecanicos");
        System.out.println("4.- Eliminar Mecanicos");
        System.out.println("5.- Salir");
        System.out.print("Ingrese una opción: ");
    }

    public void mostrarMecanicos(List <Mecanico> mecanicos){
        if(mecanicos.isEmpty()){
            System.out.println("No hay mecanicos");
        }else {
            mecanicos.forEach(System.out::println);
        }
    }

    public Mecanico leerNuevoMecanico(){

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        while(!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}")){
            System.out.print("Nombre no valido, Ingreselo nuevamente (Máximo 25 caracteres): ");
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
        }

        System.out.print("Especialidad: ");
        String especialidad = teclado.nextLine();

        while(!especialidad.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,25}")){
            System.out.print("Especialidad no valida, Ingresela nuevamente (Máximo 25 caracteres): ");
            System.out.print("Especialidad: ");
            especialidad = teclado.nextLine();
        }

        System.out.print("Años de experiencia: ");
        String aniosPal = teclado.nextLine();
        int anios;

        while (!aniosPal.matches("^\\d{1,2}$")){
            System.out.println("Años no validos, ingreselos nuevamente.");
            System.out.print("Años de experiencia: ");
            aniosPal = teclado.nextLine();
        }

        anios = Integer.parseInt(aniosPal);

        Mecanico mecanico = new Mecanico();
        mecanico.setNombre(nombre);
        mecanico.setEspecialidad(especialidad);
        mecanico.setAnio_experiencia(anios);

        return mecanico;
    }

    public Mecanico leerMecanicoActualizado(Mecanico MecanicoExistente) {
        System.out.println("Actualizando Mecanico con ID: " + MecanicoExistente.getId_mecanico());

        Mecanico actualizado = leerNuevoMecanico(); // se piden los nuevos datos
        actualizado.setId_mecanico(MecanicoExistente.getId_mecanico()); // se conserva el ID original

        return actualizado;
    }

    public int pedirIdMecanico() {
        System.out.print("Ingrese el ID del mecanico: ");
        String idPal = teclado.nextLine();

        while(!idPal.matches("\\d+")){
            System.out.println("Id no valido.");
            System.out.print("Ingrese el ID del mecanico: ");
            idPal = teclado.nextLine();
        }

        return Integer.parseInt(idPal);
    }

    public String leerOpcion() {
        String respuesta;

        while(!respuesta.matches("\\d+")){
                System.out.println("Ingrese nuevamente el número");
                respuesta = teclado.nextLine();
        } 
        return respuesta;
    }
}
