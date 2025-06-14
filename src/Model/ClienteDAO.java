package Model;

import java.sql.*;
import java.util.*;

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
            stmt.executeUpdate();
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
        String sql = "UPDATE clientes SET nombre=?, rut=?, telefono=? WHERE id_clientes=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,cl.getNombre());
            stmt.setString(2,cl.getRut());
            stmt.setString(3,cl.getTelefono());
            stmt.setInt(4,cl.getId_clientes());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminarCliente(int id){
        String sql = "DELETE FROM clientes WHERE id_clientes=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Cliente buscarAutoPorIdd(int id) {
        Cliente cl = null;
        String sql = "SELECT * FROM autos WHERE id_auto = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet respuesta = stmt.executeQuery();
            if (respuesta.next()) {
                cl = new Cliente();
                cl.setId_clientes(respuesta.getInt("id_auto"));
                cl.setNombre(respuesta.getString("nombre"));
                cl.setRut(respuesta.getString("rut"));
                cl.setTelefono(respuesta.getString("telefono"));
            }
            respuesta.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar auto por ID: " + e.getMessage());
        }

        return cl; // Si no encuentra nada, devuelve null
    }
}
