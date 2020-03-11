package di.chap2_1;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	// 결합도 낮추는 방법:생성자의 인수로 받아 할당
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public UserServiceImpl(javax.sql.DataSource dataSource) {
		// 데이터베이스 방식으로 사용자 정보를 관리하는 구현 클래스
		this.userRepository = new JdbcUserRepository(dataSource);

		// Bcrypt 알고리즘으로 해시화하는 구현 클래스
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	
	public void register(User user, String rawPassword) throws UserAlreadyRegisterdException {
		if (this.userRepository.countByUserName(user.getUserName()) > 0) {
			// 같은 사용자 계정의사용자가 있다면 예외를 발생시킨다.
			throw new UserAlreadyRegisterdException();
		}

		// 입력된 원본 패스워드를 해시화한 후, 사용자 정보로 설정한다.
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}
}
