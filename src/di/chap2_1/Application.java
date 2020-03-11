package di.chap2_1;

import javax.sql.DataSource;

public class Application {

	public static void main(String[] args) {
		DataSource dataSource = null;
	
		//미완성된 클래스는 더미로 대체
		UserRepository userRepository = new DummyUserRepository(dataSource);
		PasswordEncoder passwordEncoder = new DummyPasswordEncoder();
		
		UserService userService = new UserServiceImpl(userRepository, passwordEncoder);
	
		//DI 컨테이너에서 userService 꺼내기
	
		//ApplicationContext context = ...;
		//UserService userService = context.getBean(UserService,class);
	}

}
