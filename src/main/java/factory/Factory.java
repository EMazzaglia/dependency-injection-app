package factory;

import computadora.Computadora;
import computadora.memoria.Memoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factory {

    public static void getObject(Class c){

        System.out.println(c.getClasses());
        System.out.println("----------------");
        System.out.println(Arrays.stream(c.getDeclaredFields()).findFirst());
    }

//    public <T> Class<T> getObject(Class<T> c) throws Exception {
//        System.out.println(c.getDeclaredFields());
//        System.out.println(c.getFields());
//        Memoria memo = new Memoria("1","2","3","4");
//        List<Memoria> listmemo = new ArrayList<>();
//        listmemo.add(memo);
//        return new Computadora(listmemo);
//    }
}
