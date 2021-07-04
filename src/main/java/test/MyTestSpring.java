package test;

import entity.Auto;
import entity.FordFiesta;
import factory.ComponentScan;
import factory.Factory;

@ComponentScan()
public class MyTestSpring {
    public static void main (String[] args) throws Exception {
        Auto auto = (Auto) Factory.getObject(FordFiesta.class);
        auto.regular();
        auto.acelerar();
        auto.frenar();
    }
}
