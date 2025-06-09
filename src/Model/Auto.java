package Model;

public class Auto {
  private int id_auto;
  private String marca;
  private String modelo;
  private int anio;
  private String patente;

  public Auto() {
  }

  public Auto(int id_auto, String marca, String modelo, int anio, String patente) {
    this.id_auto = id_auto;
    this.marca = marca;
    this.modelo = modelo;
    this.anio = anio;
    this.patente = patente;
  }

  public int getId_auto() {
    return id_auto;
  }

  public void setId_auto(int id_auto) {
    this.id_auto = id_auto;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getAnio() {
    return anio;
  }

  public void setAnio(int anio) {
    this.anio = anio;
  }

  public String getPatente() {
    return patente;
  }

  public void setPatente(String patente) {
    this.patente = patente;
  }

  @Override
  public String toString() {
    return "Auto{" +
            "id_auto=" + id_auto +
            ", marca='" + marca + '\'' +
            ", modelo='" + modelo + '\'' +
            ", anio=" + anio +
            ", patente='" + patente + '\'' +
            '}';
  }
}
