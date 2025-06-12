package Model;

public class Herramienta {
    private int id_herramienta;
    private String nombre;
    private String tipo;
    private String estado;

    public Herramienta() {
    }

    public Herramienta(int id_herramienta, String nombre, String tipo, String estado) {
        this.id_herramienta = id_herramienta;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId_herramienta() {
        return id_herramienta;
    }

    public void setId_herramienta(int id_herramienta) {
        this.id_herramienta = id_herramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Herramienta{" +
                "id_herramienta=" + id_herramienta +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
