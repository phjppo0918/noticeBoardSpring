package AutoWirdeTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import implementProject.entity.User;
import implementProject.registerUser.UserAlredyRegisterException;
import implementProject.registerUser.UserService;

public class Application {
	public static void main(String [] args) throws UserAlredyRegisterException {
		
		//applicationContext 생성
		ApplicationContext context =
				//new AnnotationConfigApplicationContext(AppConfig.class);
				//new ClassPathXmlApplicationContext("implementProject/DIContainerSetterFile/applicationContextForXml.xml");
				//new AnnotationConfigApplicationContext(AppConfigAnnotation.class);
				//new ClassPathXmlApplicationContext("implementProject/DIContainerSetterFile/applicationContextForXmlAnnotation.xml");
				//new AnnotationConfigApplicationContext(AppConfigSetterBasedDI.class);
				new ClassPathXmlApplicationContext("implementProject/DIContainerSetterFile/"
						+ "applicationContextForXmlSetterBaseDI.xml");
				
				
		//DI 컨테이너에서 빈 가져오기
		UserService userService = context.getBean(UserService.class);
		
		User user = new User("phjppo0918","현준");
		
		userService.register(user, "12345");
	}
}
