package Model;

import java.sql.*;
import java.util.ArrayList;
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
    public List<Cliente> obtenerTodos(){
        List<Cliente> clientitos = new ArrayList<>();
        String sql = "Select * FROM clientes";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                clientitos.add(new Cliente(resultado.getInt("id_clientes"),
                        resultado.getString("nombre"),
                        resultado.getString("rut"),
                        resultado.getString("telefono")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }return clientitos;
    }
    public void actualizarCliente(Cliente cl){

    }
    public void eliminarCliente(int id){

    }
}
