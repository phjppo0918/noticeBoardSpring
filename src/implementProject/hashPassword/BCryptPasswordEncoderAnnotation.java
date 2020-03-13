package implementProject.hashPassword;

import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderAnnotation implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.printf("에녀테이션 기반 설정: 비밀번호를 해쉬화합니다\n");
		return null;
	}

}
