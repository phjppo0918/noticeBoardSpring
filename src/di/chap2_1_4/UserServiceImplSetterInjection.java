package di.chap2_1_4;

import di.chap2_1.PasswordEncoder;
import di.chap2_1.User;
import di.chap2_1.UserAlreadyRegisterdException;
import di.chap2_1.UserRepository;
import di.chap2_1.UserService;

public class UserServiceImplSetterInjection implements UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	//기본생성자(생략 가능)
	public UserServiceImplSetterInjection() {
		// TODO Auto-generated constructor stub
	}
	
	//설정자 기반 의존성 주입 방식 (setter injection)
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public void register(User user, String rawPassword) throws UserAlreadyRegisterdException {
		// TODO Auto-generated method stub

	}

}
