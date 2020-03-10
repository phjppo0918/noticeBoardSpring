package di.chap2_1;
//패스워드를 해시화하는 인터페이스
public interface PasswordEncoder {
	//패스워드를 해시화한다.
	String encode(CharSequence rawPassword);
}
