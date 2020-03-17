package AutoWirdeTest.connector;

import AutoWirdeTest.model.animal.Animal;
import AutoWirdeTest.model.partner.Partner;
import AutoWirdeTest.model.zookeeper.Zookeeper;

public class MakePartnerImpl implements MakePartner {
	
	private Partner partner;
	

	public MakePartnerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public MakePartnerImpl(int partNo) {
		this.partNo = partNo;
	}

	public MakePartnerImpl(Animal animal, Zookeeper zookeeper) {
		this.partNo = animal;
		this.partner = zookeeper;
	}




	@Override
	public void makePartner(Animal animal, Zookeeper zookeeper) {
		animal.bark();
		zookeeper.calling();
	}
	
	
}
