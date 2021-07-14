package entity;

import factory.Injected;

import java.util.List;

public class FordMotor implements Motor {

	@Injected(implementation = BujiaBosh.class, count=3)
	private List<Bujia> bujias;

	@Override
	public void carburar()
	{
		System.out.println("Carburando el motor Marca Ford");
	}

}
