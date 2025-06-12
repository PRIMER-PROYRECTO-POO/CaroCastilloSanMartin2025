package Model;

public class Auto {
  private int id_auto;
  private int cantidad;
  private String Nombre;

  public Auto() {
  }

  public Auto(int id_auto, int cantidad) {
    this.id_auto = id_auto;
    this.cantidad = cantidad;
  }

  public int getId_auto() {
    return id_auto;
  }

  public void setId_auto(int id_auto) {
    this.id_auto = id_auto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
