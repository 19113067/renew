package spring.project.dao;

public interface UserDao {
	int registerUser(User user);
	User isUserRegistered(String username, 
			String password);

}
