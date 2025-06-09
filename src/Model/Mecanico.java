package Model;

public class Mecanico {
    private String nombre;
    private int cantidad;

    public Mecanico() {
    }

    public Mecanico(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;

    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
