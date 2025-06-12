package View;
import Model.Auto;
import Model.AutoDAO;

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

        //VALIDACION DE MARCA
        String marca;
        do{
            System.out.print("Marca: ");
            marca = teclado.nextLine();

            if(!marca.matches("[a-zA-Z]+")) {
                System.out.println("No valido, intentelo nuevamente.");
            }

        }while(!marca.matches("[a-zA-Z]+"));

        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();


        //VALIDACION DE AÑO

        int anio;
        String anioComoString;

        do {
            System.out.print("Año de fundación: ");
            anio = Integer.parseInt(teclado.nextLine());

            anioComoString = Integer.toString(anio);

            if (anioComoString.matches("\\d{4}")) {
                anio = Integer.parseInt(anioComoString);
            } else {
                System.out.println("Año no valido, intentelo nuevamente.");
            }
        }while(!anioComoString.matches("\\d{4}"));

        //VALIDACION DE PATENTE

        String patente;

        do {
            System.out.print("patente: ");
            patente = teclado.nextLine();

            if (!patente.matches("^[a-zA-Z0-9]{6}$")) {
                System.out.println("Patente no valida, intentelo nuevamente.");
            }

        }while(!patente.matches("^[a-zA-Z0-9]{6}$"));

            Auto car = new Auto();
            car.setMarca(marca);
            car.setModelo(modelo);
            car.setAnio(anio);
            car.setPatente(patente);

            return car;
        }

    public Auto leerAutoActualizado(Auto autoExistente) {
        System.out.println("Actualizando auto con ID: " + autoExistente.getId_auto());

        Auto actualizado = leerNuevoAuto(); // se piden los nuevos datos
        actualizado.setId_auto(autoExistente.getId_auto()); // se conserva el ID original

        return actualizado;
    }

    public int pedirIdAuto() {
        System.out.print("Ingrese el ID del auto: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerIdEliminar(Auto autoExistente) {
        System.out.println("Eliminando auto con ID: " + autoExistente.getId_auto());
        return autoExistente.getId_auto(); // ✅ devolvemos el ID
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}
