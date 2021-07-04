package computadora;

import computadora.fuente.Fuente;
import computadora.memoria.Memoria;

import java.util.List;

public class ComputadoraGamer implements Computadora {

    private List<Memoria> memorias;
    private Fuente fuente;

    public ComputadoraGamer(List<Memoria> memorias) {
        this.memorias = memorias;
    }

    public List<Memoria> getMemorias() {
        return memorias;
    }

    public void setMemorias(List<Memoria> memorias) {
        this.memorias = memorias;
    }

    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }

    @Override
    public String descripcionComputadora() {
        return "ComputadoraGamer{" +
                "fuente=" + fuente +
                '}';
    }
}
