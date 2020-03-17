package AutoWirdeTest.model.animal;

public class AnimalImplCat implements Animal {
	private String name;
	private int age;
	
	@Override
	public void bark() {
		System.out.println("야옹");
	}
}
