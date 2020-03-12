package di.chap2_1_4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di.chap2_1.BCryptPasswordEncoder;
import di.chap2_1.PasswordEncoder;
import di.chap2_1.UserRepository;
import di.chap2_1.UserService;
import di.chap2_1_2.UserRepositoryImpl;

@Configuration 
public class AppConfigConstructInjection {
	
	@Bean //빈 정의. 메서드 이름이 빈이 이름
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean(name="PWEncoder")//빈의 이름을 다르게 명시하고 싶을 때 재정의
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//세터 인젝션을 자바 기반 설정 방식으로 표현한 예
	@Bean 
	UserService userService() {
		UserServiceImplSetterInjection userService = new UserServiceImplSetterInjection();
		userService.setUserRepository(userRepository());
		userService.setPasswordEncoder(passwordEncoder());
		return userService;
	}
	
	//매개변수를 활용해 새터 인젝션을 자바 기반 설정 방식으로 표현한 예
	@Bean
	UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		UserServiceImplSetterInjection userService = new UserServiceImplSetterInjection();
		userService.setUserRepository(userRepository);
		userService.setPasswordEncoder(passwordEncoder);
		return userService;
	}
}
