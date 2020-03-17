package AutoWirdeTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import AutoWirdeTest.connector.Register;

public class Application {
	public static void main(String [] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Register register = context.getBean(Register.class);
		
		register.register(null, null);
	}
}
