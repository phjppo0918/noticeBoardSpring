package AutoWirdeTest.manageUser;

import AutoWirdeTest.entity.User;

//사용자 정보를 관리하는 인터페이스
public interface UserRepository {
	
	//사용자 정보를 저장한다.
	User save(User user);
	//사용자 계정명이 일치하는 사용자 수를 카운트 한다.
	int countById(String id);
}
