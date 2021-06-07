package computadora.memoria;

public class Memoria {

    private String capacidad;
    private String velocidad;
    private String tecnologia;
    private String marca;

    public Memoria(String capacidad, String velocidad, String tecnologia, String marca) {
        this.capacidad = capacidad;
        this.velocidad = velocidad;
        this.tecnologia = tecnologia;
        this.marca = marca;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
