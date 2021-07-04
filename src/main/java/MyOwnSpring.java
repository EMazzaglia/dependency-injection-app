import computadora.Computadora;
import computadora.ComputadoraGamer;
import computadora.memoria.Memoria;
import computadora.memoria.MemoriaKingstone;
import factory.Factory;

import java.util.ArrayList;
import java.util.List;

public class MyOwnSpring {

    public static void main(String[] args) throws Exception {
        Memoria kingstone = new MemoriaKingstone("16 GB","3200 MHz","DDR3","Kingstone");
        List<Memoria> listaMemorias = new ArrayList<>();
        listaMemorias.add(kingstone);
        Computadora computadora = new ComputadoraGamer(listaMemorias);
        Factory.getObject(Computadora.class);
    }

}
