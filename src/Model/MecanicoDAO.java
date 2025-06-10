package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MecanicoDAO {
    private Connection connection;
    public MecanicoDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_mecanico","root","");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void crearMecanico(Mecanico mc){

    }
    public List<Auto> obtenerTodos(){

    }
    public void actualizarMecanico(Mecanico mc){

    }
    public void eliminarMecanico(int id){

    }
}
