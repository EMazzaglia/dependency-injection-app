package computadora;

import computadora.memoria.Memoria;

import java.util.List;

public class Computadora {

    private List<Memoria> memorias;
//    private Motherboard motherboard;
//    private PlacaVideo placaVideo;
//    private Fuente fuente;
//    private Gabinete gabinete;

    public Computadora(List<Memoria> memorias) {
        this.memorias = memorias;
    }

    public List<Memoria> getMemorias() {
        return memorias;
    }

    public void setMemorias(List<Memoria> memorias) {
        this.memorias = memorias;
    }

}
