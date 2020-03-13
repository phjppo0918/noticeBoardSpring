package implementProject.manageUser;

import org.springframework.stereotype.Component;

import implementProject.entity.User;

@Component
public class UserRepositoryImplAnnotation implements UserRepository {

	@Override
	public User save(User user) {
		System.out.printf("에녀테이션 기반 설정: 사용자 정보를 %s값으로 저장합니다\n", user.getId());
		
		return null;
	}

	@Override
	public int countById(String id) {
		System.out.println("에녀테이션 기반 설정: 사용자 계정과 이름이 같은 id의 개수를 출력합니다.");
		return 0;
	}

}
