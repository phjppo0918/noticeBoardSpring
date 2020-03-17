package AutoWirdeTest.model.partner;

import AutoWirdeTest.model.animal.Animal;
import AutoWirdeTest.model.zookeeper.Zookeeper;

public class Partner {

	private int partNo;
	private Animal animal;
	private Zookeeper zookeeper;
	
	public Partner() {
		// TODO Auto-generated constructor stub
	}
	
	public Partner(int partNo) {
		this.partNo = partNo;
	}

	public Partner(int partNo, Animal animal, Zookeeper zookeeper) {
		this.partNo = partNo;
		this.animal = animal;
		this.zookeeper = zookeeper;
	}



	public int getPartNo() {
		return partNo;
	}
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Zookeeper getZookeeper() {
		return zookeeper;
	}
	public void setZookeeper(Zookeeper zookeeper) {
		this.zookeeper = zookeeper;
	}

	
	
}
