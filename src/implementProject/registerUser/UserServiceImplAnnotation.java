package implementProject.registerUser;

import org.springframework.beans.factory.annotation.Autowired;

import implementProject.entity.User;
import implementProject.hashPassword.BCryptPasswordEncoder;
import implementProject.hashPassword.PasswordEncoder;
import implementProject.manageUser.JdbcUserRepository;
import implementProject.manageUser.UserRepository;

public class UserServiceImplAnnotation implements UserService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImplAnnotation(javax.sql.DataSource dataSource) {
		this.userRepository = new JdbcUserRepository(dataSource);
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	@Autowired
	public UserServiceImplAnnotation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		System.out.println("에녀테이션 기반 설정: 사용자 정보를 입력받아왔습니다");
		this.userRepository =userRepository;
		this.passwordEncoder =passwordEncoder;
	}

	public void register(User user, String rawPassword) throws UserAlredyRegisterException {
		if(this.userRepository.countById(user.getId())>0) {
			//같은 사용자 계정의 사용자가 있다면 예외를 발생시킨다.
			System.out.println("에녀테이션 기반 설정: 예외가 발생하였습니다.: 같은 사용자 계정이 있음");
			throw new UserAlredyRegisterException(); 
		}
		System.out.println("에녀테이션 기반 설정: 사용자 정보를 등록합니다.");
		//입력한 원본 패스워드를 해시화한 후, 사용자 정보로 설정한다.
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

	
}
