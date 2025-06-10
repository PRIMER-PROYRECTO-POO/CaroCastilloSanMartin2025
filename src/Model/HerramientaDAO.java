package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HerramientaDAO {
    private Connection connection;
    public AutoDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_mecanico","root","");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void crearHerramienta(Herramienta er){

    }
    public List<Auto> obtenerTodos(){

    }
    public void actualizarHerramienta(Herramienta er){

    }
    public void eliminarHerramienta(int id){

    }
}
