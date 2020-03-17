package AutoWirdeTest.connector;

import AutoWirdeTest.model.animal.Animal;
import AutoWirdeTest.model.zookeeper.Zookeeper;

public class RegisterImpl implements Register {

	private  Animal animal;
	private  Zookeeper zookeeper;
	
	public RegisterImpl(Animal animal, Zookeeper zookeeper) {
		this.animal = animal;
		this.zookeeper = zookeeper;
	}

	@Override
	public void register(Animal animal, Zookeeper zookeeper) {
		animal.bark();
		zookeeper.Calling();
		zookeeper.callCareer();
	}

}
