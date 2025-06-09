package Model;

public class Mecanico {
    private int id_mecanico;
    private String nombre;
    private String especialidad;
    private int anio_experiencia;

    public Mecanico() {
    }

    public Mecanico(int id_mecanico, String nombre, String especialidad, int anio_experiencia) {
        this.id_mecanico = id_mecanico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.anio_experiencia = anio_experiencia;
    }

    public int getId_mecanico() {
        return id_mecanico;
    }

    public void setId_mecanico(int id_mecanico) {
        this.id_mecanico = id_mecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAnio_experiencia() {
        return anio_experiencia;
    }

    public void setAnio_experiencia(int anio_experiencia) {
        this.anio_experiencia = anio_experiencia;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "id_mecanico=" + id_mecanico +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", anio_experiencia=" + anio_experiencia +
                '}';
    }
}
