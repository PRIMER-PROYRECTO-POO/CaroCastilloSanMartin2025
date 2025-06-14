package View;
import Model.Mecanico;
import java.util.*;

public class MecanicoView{
    private Scanner teclado = new Scanner (System.in);

    public void mostrarMenu(){
        System.out.println("MENU MECANICO");
        System.out.println("1.- Listar Mecanicos");
        System.out.println("2.- Crear Mecanicos");
        System.out.println("3.- Editar Mecanicos");
        System.out.println("4.- Elimianr Mecanicos");
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
        boolean valido = false;
        String nombre = "";

        while (!valido) {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            if (nombre.matches(".*\\d.*")){
                System.out.println("El nombre no debe contener números. Intente nuevamente.");
            } else {
                valido = true;
            }
        }

        System.out.print("Especialidad: ");
        String especialidad = teclado.nextLine();

        int anios = 0;
        boolean validos = false;

        while (!validos) {
            System.out.print("Años de experiencia: ");
            String entrada = teclado.nextLine();

            try {
                anios = Integer.parseInt(entrada);
                if (entrada.length() <= 2) {
                    if(anios > 0) {
                        validos = true;
                    }else {
                        System.out.println("debe ingresar años de experiencia validos.");
                    }
                } else {
                    System.out.println("debe ingresar años de experiencia validos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar un número entero.");
            }
        }

        Mecanico mecanico = new Mecanico();
        mecanico.setNombre(nombre);
        mecanico.setEspecialidad(especialidad);
        mecanico.setAnio_experiencia(anios);

        return mecanico;
    }

    public Mecanico leerMecanicoActualizado(){
        System.out.print("Ingrese el ID del mecanico a actualizar: ");
        int id = Integer.parseInt(teclado.nextLine());
        Mecanico mecanico = leerNuevoMecanico();
        mecanico.setId_mecanico(id);
        return mecanico;
    }

    public int leerIdEliminar() {
        System.out.print("Ingrese el ID del mecanico a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        String respuesta = teclado.nextLine();
        while(!respuesta.matches("\\d+")){
            System.out.println("Por favor, ingrese la opción en numero sin espacios 🙄");
            System.out.print("Indique opción: ");
            respuesta=teclado.nextLine();
        }
        return Integer.parseInt(respuesta);
    }
}
