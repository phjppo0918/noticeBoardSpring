package di.chap2_1_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di.chap2_1.BCryptPasswordEncoder;
import di.chap2_1.PasswordEncoder;
import di.chap2_1.UserRepository;
import di.chap2_1.UserService;
import di.chap2_1.UserServiceImpl;
 
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
	UserService  userService() {
		return new UserServiceImpl(userRepository(), passwordEncoder());
	}


}
