package AutoWirdeTest.registerUser;

import AutoWirdeTest.entity.User;

//사용자 등록을 처리하는 인터페이스
public interface UserService {
	//사용자 정보를 등록한다.
	void register(User user, String rawPassword) throws UserAlredyRegisterException;
}
