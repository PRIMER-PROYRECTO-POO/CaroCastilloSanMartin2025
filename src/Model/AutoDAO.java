package Model;
import java.util.*;
import java.sql.*;

public class AutoDAO {
    private Connection connection;
    public AutoDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_mecanico","root","");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void crearAuto(Auto car){

    }
    public List<Auto> obtenerTodos(){

    }
    public void actualizarAuto(Auto car){

    }
    public void eliminarAuto(int id){

    }
}
