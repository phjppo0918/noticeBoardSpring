package AutoWirdeTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import AutoWirdeTest.hashPassword.BCryptPasswordEncoder;
import AutoWirdeTest.hashPassword.PasswordEncoder;
import AutoWirdeTest.manageUser.UserRepository;
import AutoWirdeTest.manageUser.UserRepositoryImpl;
import AutoWirdeTest.registerUser.UserService;
import AutoWirdeTest.registerUser.UserServiceImpl;


//DI 컨테이너에서 설정파일 역할
//자바기반 설정 방식
@Configuration
public class AppConfig {

	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserService userService() {
		return new UserServiceImpl(userRepository(), passwordEncoder());
	}
}

