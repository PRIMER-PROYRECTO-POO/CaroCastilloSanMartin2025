package View;
import Model.Auto;
import Model.AutoDAO;

import javax.swing.*;
import java.util.*;

public class AutoView {
    private Scanner sc=new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("MENU TALLER MECANICO");
        System.out.println("1. -Listar Autos");
        System.out.println("2. -Crear autos");
        System.out.println("3. -Editar autos");
        System.out.println("4. -Eliminar autos");
        System.out.println("5. -Salir");
        System.out.println("Indique su opcion: ");
    }
    public void mostrarAutos(List<Auto> autos){
        if (autos.isEmpty()){
            System.out.println("No hay vehiculos");
        }else{
            autos.forEach(System.out::println);
        }
    }
    public Auto leerNuevoAuto() {
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        return new Auto(0,cantidad);
    }

    public Auto leerAutoActualizado(){
        System.out.println("Ingrese el ID del auto a actualizar: ");
        int id =Integer.parseInt(sc.nextLine());
        Auto auto=leerNuevoAuto();
        auto.setId_auto(id);
        return auto;
    }
    public int leerIdEliminar(){
        System.out.println("Indique el ID del auto a eliminar");
        return Integer.parseInt(sc.nextLine());
    }
    public int leerOpcion(){
        return Integer.parseInt(sc.nextLine());
    }
}
