package di.chap2_1_2;

import org.springframework.stereotype.Component;

import di.chap2_1.User;
import di.chap2_1.UserRepository;

@Component //빈 클래스에 @Component 에녀테이션을 붙여 컴포넌트 스캔이 되도록 만든다
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByUserName(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
