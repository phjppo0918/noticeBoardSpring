package AutoWirdeTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import AutoWirdeTest.connector.MakePartner;
import AutoWirdeTest.connector.MakePartnerImpl;
import AutoWirdeTest.model.animal.Animal;
import AutoWirdeTest.model.animal.AnimalImplCat;
import AutoWirdeTest.model.zookeeper.Zookeeper;
import AutoWirdeTest.model.zookeeper.ZookeeperImplSamsung;

@Configuration
public class AppConfig {

	@Bean
	Animal animal() {
		return new AnimalImplCat();
	}

	@Bean
	Zookeeper zookeeper() {
		return new ZookeeperImplSamsung();
	}
	
	@Bean
	MakePartner makepartner() {
		return new MakePartnerImpl(animal(), zookeeper());
	}
}
