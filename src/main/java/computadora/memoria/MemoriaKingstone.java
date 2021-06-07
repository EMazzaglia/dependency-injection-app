package computadora.memoria;

public class MemoriaKingstone extends Memoria {

    private String marca;

    public MemoriaKingstone(String capacidad, String velocidad, String tecnologia, String marca) {
        super(capacidad, velocidad, tecnologia, marca);
        this.marca = marca;
    }
}
