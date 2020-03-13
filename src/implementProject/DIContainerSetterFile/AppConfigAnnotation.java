package implementProject.DIContainerSetterFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import implementProject.hashPassword.BCryptPasswordEncoder;
import implementProject.hashPassword.BCryptPasswordEncoderAnnotation;
import implementProject.hashPassword.PasswordEncoder;
import implementProject.manageUser.UserRepository;
import implementProject.manageUser.UserRepositoryImpl;
import implementProject.manageUser.UserRepositoryImplAnnotation;
import implementProject.registerUser.UserService;
import implementProject.registerUser.UserServiceImpl;
import implementProject.registerUser.UserServiceImplAnnotation;

//DI 컨테이너에서 설정파일 역할
//자바기반 설정 방식
@Configuration
@ComponentScan("implementProject")
public class AppConfigAnnotation {

	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImplAnnotation();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoderAnnotation();
	}
	
	@Bean
	UserService userService() {
		return new UserServiceImplAnnotation(userRepository(), passwordEncoder());
	}
}

