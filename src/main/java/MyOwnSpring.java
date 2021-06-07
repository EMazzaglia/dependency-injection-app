import computadora.Computadora;
import computadora.memoria.Memoria;
import computadora.memoria.MemoriaKingstone;

import java.util.ArrayList;
import java.util.List;

public class MyOwnSpring {




    public static void main(String[] args) throws Exception {
        Memoria kingstone = new MemoriaKingstone("16 GB","3200 MHz","DDR3","Kingstone");
        List<Memoria> listaMemorias = new ArrayList<>();
        listaMemorias.add(kingstone);
        Computadora computadora = new Computadora(listaMemorias);
        System.out.println(computadora.getMemorias().get(0).getMarca());
    }





}
