package AutoWirdeTest.hashPassword;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.printf("비밀번호를 해쉬화합니다\n");
		return null;
	}

}
