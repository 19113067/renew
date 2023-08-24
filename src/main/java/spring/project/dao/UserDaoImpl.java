package spring.project.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int registerUser(User user) {
		String insertQuery = "INSERT INTO admin "
				+ "( username, password) "
				+ "VALUES (?,?)";
		
		return jdbcTemplate.update(
				insertQuery, 
				 
				user.getUsername(), 
				user.getPassword());
	}

	@Override
	public User isUserRegistered(String username, String password) throws DataAccessException {
		String checkQuery = "SELECT * FROM admin WHERE username = ? AND password = ?";
		User user = null;
		
		if(username != null && !username.isEmpty() ) {
			if( password != null && !password.isEmpty()) {
				System.out.println("user : " + user);
				user = jdbcTemplate.queryForObject(checkQuery, new UserRowMapper(), username, password); 
			}
		}
		System.out.println("-------");
		System.out.println(user);
		return user;
	}


}
