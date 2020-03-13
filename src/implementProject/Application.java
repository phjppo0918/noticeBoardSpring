package implementProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import implementProject.DIContainerSetterFile.AppConfig;
import implementProject.registerUser.UserService;

public class Application {
	public static void main(String [] args) {
		
		//applicationContext 생성
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//DI 컨테이너에서 빈 가져오기
		UserService userService = context.getBean(UserService.class);
		
		
	}
}
