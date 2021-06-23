package entity;

import factory.Injected;

import java.util.ArrayList;
import java.util.List;

public class ToyotaMotor implements Motor
{

	@Injected(implementation = BujiaBosh.class, count=5)
	private List<Bujia> bujias;

	@Override
	public void carburar()
	{
		System.out.println("Carburando el motor japones");
	}

}
