package di.chap2_1_2; 
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
import di.chap2_1.BCryptPasswordEncoder;
import di.chap2_1.PasswordEncoder;
import di.chap2_1.UserRepository;
import di.chap2_1.UserService;
import di.chap2_1.UserServiceImpl;
 
@Configuration //설정 클래스 선언
@ComponentScan("di")//컴포넌트 스캔이 활성화되도록 클래스에 @ComponentScan 에너테이션을 부여한다.
//애너테이션의 value 속성이나 basePackages 속성에 컴포넌트를 스캔할 패키지를 지정한다
//스캔 대상이 되는 에너테이션이 부여된 클래스를 DI 컨테이너에 자동으로 등록한다 
//이 속성을 생략할 경우 설정 클래스가 들어있는 패키지 이하를 스캔한다.
public class AppConfigComponentScan {
	@Bean //빈 정의. 메서드 이름이 빈이 이름
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean(name="PWEncoder")//빈의 이름을 다르게 명시하고 싶을 때 재정의
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	UserService  userService() {
		
		return new UserServiceImpl(userRepository(), passwordEncoder());
		//다른 컴포넌트를 참조해야 할 때는 해당 컴포넌트의 메서드를 호출
		//의존성 주입을 프로그램적인 방법으로 처리
	}
	
	//자바 기반 설정방식에서는 메서드에 매개변수를 추가하는 방법으로 다른 컴포넌트의 의존성을 주입할 수 있다.
	//단, 인수로 전달된 인스턴스에 대한 빈은 별도로 정의돼 있어야 한다.

	@Bean
	UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		
		return new UserServiceImpl(userRepository(), passwordEncoder());
	}
	
}
