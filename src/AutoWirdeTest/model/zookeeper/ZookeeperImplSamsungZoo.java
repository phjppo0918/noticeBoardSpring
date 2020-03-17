package AutoWirdeTest.model.zookeeper;

public class ZookeeperImplSamsungZoo implements Zookeeper{

	private String name;
	private int carrer;
	
	public ZookeeperImplSamsungZoo() {
		// TODO Auto-generated constructor stub
	}
	
	public ZookeeperImplSamsungZoo(String name, int carrer) {
		this.name = name;
		this.carrer = carrer;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCarrer() {
		return carrer;
	}

	public void setCarrer(int carrer) {
		this.carrer = carrer;
	}

	
	
	@Override
	public void Calling() {
		
		System.out.println("삼성 동물원 소속: 제 성함은 "+ name+"입니다");
		
	}

	@Override
	public void callCareer() {
		System.out.println("삼성 동물원 소속: 제 경력은 "+ carrer+"년 입니다");
		
	}

}
