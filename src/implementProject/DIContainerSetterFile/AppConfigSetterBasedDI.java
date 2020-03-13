package implementProject.DIContainerSetterFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import implementProject.hashPassword.BCryptPasswordEncoder;
import implementProject.hashPassword.PasswordEncoder;
import implementProject.manageUser.UserRepository;
import implementProject.manageUser.UserRepositoryImpl;
import implementProject.registerUser.UserService;
import implementProject.registerUser.UserServiceImpl;
import implementProject.registerUser.UserServiceImplSetterBasedDI;

//DI 컨테이너에서 설정파일 역할
//자바기반 설정 방식
@Configuration
public class AppConfigSetterBasedDI {

	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 
	
	/*
	@Bean
	UserService userService() {
		return new UserServiceImpl(userRepository(), passwordEncoder());
	}*/
	
	@Bean
	UserService userService() {
		UserServiceImplSetterBasedDI userService = new UserServiceImplSetterBasedDI();
		userService.setUserRepository(userRepository());
		userService.setPasswordEncoder(passwordEncoder());
		return userService;
	}
}

