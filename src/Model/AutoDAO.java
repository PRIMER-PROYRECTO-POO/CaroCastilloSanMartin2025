package Model;
import java.util.*;
import java.sql.*;

public class AutoDAO {
    private Connection connection;
    public AutoDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller_mecanico","root","");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Auto buscarAutoPorId(int id) {
        Auto auto = null;

        String sql = "SELECT * FROM autos WHERE id_auto = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet respuesta = stmt.executeQuery();

            if (respuesta.next()) {
                auto = new Auto();
                auto.setId_auto(respuesta.getInt("id_auto"));
                auto.setMarca(respuesta.getString("marca"));
                auto.setModelo(respuesta.getString("modelo"));
                auto.setAnio(respuesta.getInt("anio"));
                auto.setPatente(respuesta.getString("patente"));
            }

            respuesta.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar auto por ID: " + e.getMessage());
        }

        return auto; // Si no encuentra nada, devuelve null
    }

    public void crearAuto(Auto car){
        String sql = "INSERT INTO autos (marca,modelo,anio,patente) values (?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,car.getMarca());
            stmt.setString(2,car.getModelo());
            stmt.setInt(3,car.getAnio());
            stmt.setString(4,car.getPatente());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Auto> obtenerTodos(){
        List<Auto> autitos = new ArrayList<>();
        String sql = "Select * FROM autos";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()) {
                autitos.add(new Auto(resultado.getInt("id_auto"),
                        resultado.getString("marca"),
                        resultado.getString("modelo"),
                        resultado.getInt("anio"),
                        resultado.getString("patente")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }return autitos;
    }
    public void actualizarAuto(Auto car){
        String sql = "UPDATE autos SET marca=?, modelo=?, anio=?, patente=? WHERE id_auto=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,car.getMarca());
            stmt.setString(2,car.getModelo());
            stmt.setInt(3,car.getAnio());
            stmt.setString(4,car.getPatente());
            stmt.setInt(5, car.getId_auto());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminarAuto(int id){
        String sql = "DELETE FROM autos WHERE id_auto=?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean buscarAutoPorId(int id) {
        String sql = "SELECT EXISTS (SELECT 1 FROM autos WHERE id_auto = ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                return resultado.getInt(1) == 1;
            }

            resultado.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
