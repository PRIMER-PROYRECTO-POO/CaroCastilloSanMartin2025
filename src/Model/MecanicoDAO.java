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

    public Mecanico buscarMecanicoPorId(int id) {
        Mecanico mecanico = null;

        String sql = "SELECT * FROM mecanicos WHERE id_mecanico = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet respuesta = stmt.executeQuery();

            if (respuesta.next()) {
                mecanico = new Mecanico();
                mecanico.setId_mecanico(respuesta.getInt("id_mecanico"));
                mecanico.setNombre(respuesta.getString("nombre"));
                mecanico.setEspecialidad(respuesta.getString("especialidad"));
                mecanico.setAnio_experiencia(respuesta.getInt("anio_experiencia"));
            }

            respuesta.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar Mecanico por ID: " + e.getMessage());
        }

        return mecanico; // Si no encuentra nada, devuelve null
    }

    public void crearMecanico(Mecanico mc){
        String sql = "INSERT INTO mecanicos (nombre,especialidad,anio_experiencia) values (?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,mc.getNombre());
            stmt.setString(2,mc.getEspecialidad());
            stmt.setInt(3,mc.getAnio_experiencia());
            stmt.executeUpdate();

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
            stmt.executeUpdate();

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
