package AutoWirdeTest.model.animal;

public class AnimalImpl implements Animal {

	private String type = "tiger"; 
	
	@Override
	public void bark() {
		System.out.println("어흥!");
	}

}
