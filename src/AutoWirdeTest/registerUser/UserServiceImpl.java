package AutoWirdeTest.registerUser;

import AutoWirdeTest.entity.User;
import AutoWirdeTest.hashPassword.PasswordEncoder;
import AutoWirdeTest.manageUser.UserRepository;

public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		System.out.println("사용자 정보를 입력받아왔습니다");
		this.userRepository =userRepository;
		this.passwordEncoder =passwordEncoder;
	}

	public void register(User user, String rawPassword) throws UserAlredyRegisterException {
		if(this.userRepository.countById(user.getId())>0) {
			//같은 사용자 계정의 사용자가 있다면 예외를 발생시킨다.
			System.out.println("예외가 발생하였습니다.: 같은 사용자 계정이 있음");
			throw new UserAlredyRegisterException(); 
		} 
		System.out.println("사용자 정보를 등록합니다.");
		//입력한 원본 패스워드를 해시화한 후, 사용자 정보로 설정한다.
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

	
}
