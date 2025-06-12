package Model;

public class Cliente {
    private int id_clientes;
    private String nombre;
    private String rut;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int id_clientes, String nombre, String rut, String telefono) {
        this.id_clientes = id_clientes;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_clientes=" + id_clientes +
                ", nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}