package test;

import entity.Auto;
import entity.FordFiesta;
import entity.ToyotaCorolla;
import factory.ComponentScan;
import factory.Factory;

@ComponentScan("entity")
public class MyTestSpring {
    public static void main (String[] args) throws Exception {
        Auto ford = Factory.getObject(FordFiesta.class);
        ford.regular();
        ford.acelerar();
        ford.frenar();
        Auto toyota = Factory.getObject(ToyotaCorolla.class);
        toyota.regular();
        toyota.acelerar();
        toyota.frenar();
    }
}
