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

            System.out.print("Marca: ");
            marca = teclado.nextLine();

            while(!marca.matches("[a-zA-Z]+")){

                System.out.println("No valido, intentelo nuevamente.");
                System.out.print("Marca: ");
                marca = teclado.nextLine();
            }


        //VALIDACION DE MODELO
        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();

        while(modelo.trim().isEmpty()){

            System.out.println("Ingrese un dato valido");

            System.out.print("Modelo: ");
            modelo = teclado.nextLine();
        }


        //VALIDACION DE AÑO

        int anio = 0;
        String anioComoString;

            System.out.print("Año de fundación: ");
            anioComoString = teclado.nextLine();


            while(!anioComoString.matches("\\d{4}")) {

                System.out.println("Año no valido, intentelo nuevamente.");
                System.out.print("Año de fundación: ");
                anioComoString = teclado.nextLine();
            }

            anio = Integer.parseInt(anioComoString);

        //VALIDACION DE PATENTE

        String patente;

            System.out.print("patente: ");
            patente = teclado.nextLine();
            while(!patente.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{6}$")) {

                    System.out.println("Patente no valida, intentelo nuevamente.");
                    System.out.print("patente: ");
                    patente = teclado.nextLine();
            }


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
        String idPal = teclado.nextLine();

        while(!idPal.matches("\\d+")){
            System.out.println("Id no valido.");
            System.out.print("Ingrese el ID del auto: ");
            idPal = teclado.nextLine();
        }

        return Integer.parseInt(idPal);
    }


    public String leerOpcion() {
        String respuesta;

        do {
            System.out.print("Opción: ");
            respuesta = teclado.nextLine();

            if (!respuesta.matches("\\d+")) {
                System.out.println("Ingrese nuevamente el número");
            }

        } while (!respuesta.matches("\\d+"));

        return respuesta;
    }

}
