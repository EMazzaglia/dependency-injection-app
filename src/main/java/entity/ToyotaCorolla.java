package entity;

import factory.Injected;

public class ToyotaCorolla implements Auto {

    @Injected(implementation = ToyotaMotor.class)
    private Motor motor;

    @Override
    public void acelerar() {
        motor.carburar();
        System.out.println("Acelerando el corolita!");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando el corolla...");
    }

    @Override
    public void regular() {
        System.out.println("Regulando como un campeon el corolla...");
    }

}
