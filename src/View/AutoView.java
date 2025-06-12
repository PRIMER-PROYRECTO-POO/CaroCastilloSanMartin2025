package View;
import Model.Auto;
import java.util.*;

public class AutoView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("MENÚ AUTOS");
        System.out.println("1.- Listar Autos");
        System.out.println("2.- Crear Autos");
        System.out.println("3.- Editar Autos");
        System.out.println("4.- Eliminar Autos");
        System.out.println("5.- Salir");
        System.out.print("Indique una opción: ");
    }

    public void mostrarAutos(List<Auto> car){
        if(car.isEmpty()){
            System.out.println("No hay autos");
        }else{
            car.forEach(System.out::println);
        }
    }
    public Auto leerNuevoAuto(){
        boolean valido = false;
        String marca="";
        while (!valido) {
            System.out.print("Marca: ");
            marca = teclado.nextLine();

            if (marca.matches(".\\d.")) {
                System.out.println("El nombre no debe contener números. Intente nuevamente.");
            } else {
                valido = true;
            }
        }
        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();

        int anio = 0;
        valido = false;

        while (!valido) {
            System.out.print("Año de fundación: ");
            String entrada = teclado.nextLine();
            try {
                if (entrada.length() == 4) {
                    if(anio > 0) {
                        valido = true;
                    }else {
                        System.out.println("debe ingresar un año valido");
                    }
                } else {
                    System.out.println("debe ingresar un año valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar un número entero.");
            }

        }

        System.out.print("patente: ");
        String patente = teclado.nextLine();

        if(patente.length() > 6){
            do{
                System.out.print("patente fuera de rango, ingrese otra: ");
                patente = teclado.nextLine();
            }while(patente.length() > 6);
        }

        Auto car = new Auto();
        car.setMarca(marca);
        car.setModelo(modelo);
        car.setAnio(anio);
        car.setPatente(patente);

        return car;
    }

    public Auto leerAutoActualizado(){
        System.out.print("Ingrese el ID del Auto a actualizar: ");
        int id = Integer.parseInt(teclado.nextLine());


        Auto car = leerNuevoAuto();
        car.setId_auto(id);
        return car;
    }

    public int leerIdEliminar(){
        System.out.println("Ingrese el ID del Auto a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }
    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}
