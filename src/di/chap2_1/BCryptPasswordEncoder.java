package di.chap2_1;

import org.springframework.stereotype.Component;

@Component //빈 클래스에 @Component 에녀테이션을 붙여 컴포넌트 스캔이 되도록 만든다
public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
