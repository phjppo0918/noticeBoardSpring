package AutoWirdeTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import AutoWirdeTest.connector.Register;
import AutoWirdeTest.connector.RegisterImpl;
import AutoWirdeTest.model.animal.Animal;
import AutoWirdeTest.model.animal.AnimalImpl;
import AutoWirdeTest.model.zookeeper.Zookeeper;
import AutoWirdeTest.model.zookeeper.ZookeeperImplSamsungZoo;

@Configuration
public class AppConfig {

	@Bean
	Animal animal() {
		return new AnimalImpl();
	}
	
	@Bean
	Zookeeper zookeeper() {
		return new ZookeeperImplSamsungZoo();
	}
	
	@Bean
	Register register() {
		return new RegisterImpl(animal(), zookeeper());
	}
	
}
