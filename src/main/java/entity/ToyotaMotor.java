package entity;

import factory.Injected;
import java.util.List;


public class ToyotaMotor implements Motor {

	@Injected(implementation = BujiaChina.class, count=3)
	private List<Bujia> bujias;

	@Override
	public void carburar()
	{
		System.out.println("Carburando el motor Toyota");
	}

}
