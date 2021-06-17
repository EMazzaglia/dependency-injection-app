package test;

import entity.Auto;
import entity.FordFiesta;
import factory.ComponentScan;
import factory.Factory;

@ComponentScan("entity")
public class MyTestSpring {
    public static void main (String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Auto auto = (Auto) Factory.getObject(FordFiesta.class);

        FordFiesta autoo = new FordFiesta();

        auto.regular();
        auto.acelerar();
        auto.frenar();
    }
}
