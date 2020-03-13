package implementProject.manageUser;

import javax.sql.DataSource;

import implementProject.entity.User;

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
	public int countById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
