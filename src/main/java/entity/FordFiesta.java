package entity;

import factory.Injected;


public class FordFiesta implements Auto {
    @Injected(implementation = FordMotor.class)
    private Motor motor;

    @Override
    public void acelerar() {
        motor.carburar();
        System.out.println("Acelerando el fiestita!");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando...");
    }

    @Override
    public void regular() {
        System.out.println("Regulando...");
    }

}
