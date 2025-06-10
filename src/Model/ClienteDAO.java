package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO {
    private Connection connection;
    public ClienteDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_mecanico","root","");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void crearCliente(Cliente cl){
        String sql = "INSERT INTO clientes (nombre,rut,telefono) values (?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,cl.getNombre());
            stmt.setString(2,cl.getRut());
            stmt.setString(3,cl.getTelefono());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Auto> obtenerTodos(){

    }
    public void actualizarCliente(Cliente cl){

    }
    public void eliminarCliente(int id){

    }
}
