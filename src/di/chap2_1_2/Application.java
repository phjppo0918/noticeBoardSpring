package di.chap2_1_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.chap2_1.UserService;

public class Application {
	public static void main(String [] args) {
		
		//ApplicationContext 생상하는 다양한 방법
		
		//자바 기반 설정방식
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//에너테이션 기반의 설정 방식
		ApplicationContext context1 = new AnnotationConfigApplicationContext("com.example.app");
		//XML 기반 설정 방식. 경로에 접두어가 생략된 경우에는 클래스패스 안에서 상대 경로로 설정 파일을 탐색
		ApplicationContext context2 =
				new ClassPathXmlApplicationContext("META_INF/spring/applicationContext.xml");
		//XML 기반 설정 방식. 경로에 접두어가 생략된 경우에는 JVM의 직업 디렉터리 안에서 상대 결로로 설정 파일을 탐생한다.
		ApplicationContext context3 =
				new FileSystemXmlApplicationContext("./spring/applicationContext.xml");
		
		
		
		//DI 컨테이너에서 빈 가져오기
		
		//빈의 type을 지정하는 방법. 지정한 타입에 해당하는 빈이 DI 컨테이너에 오직 하나만 있을 때 사용
		UserService userService = context.getBean(UserService.class);
		//가져오려는 빈의 이름과 타입을 지정하는 방법. 지정한 타입에 해당하는 빈이 DI 컨테이너에 여러 개 있을 때 사용
		UserService userService1 = context.getBean("UserService", UserService.class);
		//가져오려는 빈의 이름을 지정하는 방법. 캐스트 필수
		UserService userService2 = (UserService)context.getBean("UserService");
		
	}
}
