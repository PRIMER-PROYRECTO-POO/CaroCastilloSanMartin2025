import Controller.ClienteController;
import Controller.MecanicoController;
import Controller.HerramientaController;
import Controller.AutoController;
import java.util.*;


public class Main {
    static Scanner teclado = new Scanner (System.in);
    public static void main (String [] args){
        int op;


        do {
            System.out.println("MENU PRINCIPAL\n1)Gestionar Auto\n2)Gestionar Clientes\n3)Gestionar Herramientas\n4)Gestionar Mecanico\n5)Salir");
            System.out.print("Indique una opción: ");
            op = Integer.parseInt(teclado.nextLine());
            switch (op) {
                case 1:
                    new AutoController().iniciar();
                    break;
                case 2:
                    new ClienteController().iniciar();
                    break;
                case 3:
                    new HerramientaController().iniciar();
                    break;
                case 4:
                    new MecanicoController().iniciar();
                    break;
                case 5:
                    System.out.println("¡Adios!");
                    break;
                default:
                    System.out.println("Opción no valida, ingrese otra.");

            }
        }while(op != 5);
    }
}
