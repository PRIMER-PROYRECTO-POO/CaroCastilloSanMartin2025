package Model;

import java.sql.*;
import java.util.*;

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
    public List<Mecanico> obtenerTodos(){
        List<Mecanico> mecanicos = new ArrayList<>();
        String sql = "Select * FROM mecanicos";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                mecanicos.add(new Mecanico(resultado.getInt("id_mecanico"),
                        resultado.getString("nombre"),
                        resultado.getString("especialidad"),
                        resultado.getInt("anio_experiencia")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }return mecanicos;
    }
    public void actualizarMecanico(Mecanico mc){
        String sql = "UPDATE mecanicos SET nombre=?, especialidad=?, anio_experiencia=? WHERE id_mecanico=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,mc.getNombre());
            stmt.setString(2,mc.getEspecialidad());
            stmt.setInt(3,mc.getAnio_experiencia());
            stmt.setInt(4,mc.getId_mecanico());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminarMecanico(int id){
        String sql = "DELETE FROM mecanicos WHERE id_mecanico=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
