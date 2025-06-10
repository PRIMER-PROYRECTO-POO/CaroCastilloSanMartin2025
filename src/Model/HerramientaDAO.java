package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class HerramientaDAO {
    private Connection connection;
    public HerramientaDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_mecanico","root","");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void crearHerramienta(Herramienta er){
        String sql = "INSERT INTO clientes (nombre,tipo,estado) values (?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,er.getNombre());
            stmt.setString(2,er.getTipo());
            stmt.setString(3,er.getEstado());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Auto> obtenerTodos(){

    }
    public void actualizarHerramienta(Herramienta er){

    }
    public void eliminarHerramienta(int id){

    }
}
