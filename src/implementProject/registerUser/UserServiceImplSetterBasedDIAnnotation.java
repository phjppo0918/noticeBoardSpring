package implementProject.registerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import implementProject.entity.User;
import implementProject.hashPassword.BCryptPasswordEncoder;
import implementProject.hashPassword.PasswordEncoder;
import implementProject.manageUser.JdbcUserRepository;
import implementProject.manageUser.UserRepository;

@Component
public class UserServiceImplSetterBasedDIAnnotation implements UserService{

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	//default 생성자 (생략 가능)
	public UserServiceImplSetterBasedDIAnnotation() {
		// TODO Auto-generated constructor stub
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public UserServiceImplSetterBasedDIAnnotation(javax.sql.DataSource dataSource) {
		this.userRepository = new JdbcUserRepository(dataSource);
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public UserServiceImplSetterBasedDIAnnotation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		System.out.println("설정자 기반 의존성 주입:에너테이션: 사용자 정보를 입력받아왔습니다");
		this.userRepository =userRepository;
		this.passwordEncoder =passwordEncoder;
	}

	public void register(User user, String rawPassword) throws UserAlredyRegisterException {
		if(this.userRepository.countById(user.getId())>0) {
			//같은 사용자 계정의 사용자가 있다면 예외를 발생시킨다.
			System.out.println("설정자 기반 의존성 주입: 예외가 발생하였습니다.: 같은 사용자 계정이 있음");
			throw new UserAlredyRegisterException(); 
		}
		System.out.println("설정자 기반 의존성 주입: 사용자 정보를 등록합니다.");
		//입력한 원본 패스워드를 해시화한 후, 사용자 정보로 설정한다.
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

	
}
