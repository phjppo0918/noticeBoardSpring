package implementProject.registerUser;

import implementProject.entity.User;
import implementProject.hashPassword.BCryptPasswordEncoder;
import implementProject.hashPassword.PasswordEncoder;
import implementProject.manageUser.JdbcUserRepository;
import implementProject.manageUser.UserRepository;

public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(javax.sql.DataSource dataSource) {
		this.userRepository = new JdbcUserRepository(dataSource);
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository =userRepository;
		this.passwordEncoder =passwordEncoder;
	}

	public void register(User user, String rawPassword) throws UserAlredyRegisterException {
		if(this.userRepository.countById(user.getId())>0) {
			//같은 사용자 계정의 사용자가 있다면 예외를 발생시킨다.
			throw new UserAlredyRegisterException(); 
		}
		
		//입력한 원본 패스워드를 해시화한 후, 사용자 정보로 설정한다.
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

	
}
