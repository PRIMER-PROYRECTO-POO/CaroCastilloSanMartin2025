package Model;

import java.sql.Connection;
import java.sql.DriverManager;
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

    }
    public List<Auto> obtenerTodos(){

    }
    public void actualizarCliente(Cliente cl){

    }
    public void eliminarCliente(int id){

    }
}
