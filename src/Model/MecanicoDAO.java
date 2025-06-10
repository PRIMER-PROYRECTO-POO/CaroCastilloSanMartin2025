package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO mecanicos (nombre,especialidad,anio_experiencia) values (?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,mc.getNombre());
            stmt.setString(2,mc.getEspecialidad());
            stmt.setInt(3,mc.getAnio_experiencia());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Auto> obtenerTodos(){

    }
    public void actualizarMecanico(Mecanico mc){

    }
    public void eliminarMecanico(int id){

    }
}
