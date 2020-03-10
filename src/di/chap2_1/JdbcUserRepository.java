package di.chap2_1;

import javax.sql.DataSource;

public class JdbcUserRepository implements UserRepository {

	public JdbcUserRepository(DataSource dataSource) {
		// TODO Auto-generated constructor stub
	}

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
