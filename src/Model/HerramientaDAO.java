package Model;

import java.sql.*;
import java.util.ArrayList;
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
    public List<Herramienta> obtenerTodos(){
        List<Herramienta> herramientas = new ArrayList<>();
        String sql = "Select * FROM herramientas";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                herramientas.add(new Herramienta(resultado.getInt("id_herramienta"),
                        resultado.getString("nombre"),
                        resultado.getString("tipo"),
                        resultado.getString("estado")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }return herramientas;
    }
    public void actualizarHerramienta(Herramienta er){
        String sql = "UPDATE herramientas SET nombre=?, tipo=?, estado=? WHERE id_herramienta=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,er.getNombre());
            stmt.setString(2,er.getTipo());
            stmt.setString(3,er.getEstado());
            stmt.setInt(4,er.getId_herramienta());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminarHerramienta(int id){
        String sql = "DELETE FROM herramientas WHERE id_herramienta=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
