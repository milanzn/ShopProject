package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Role;
import cubes.main.entity.User;

public interface UserDAO {
	
	
	public List<User> getAllUsers();
	public void saveUser(User user);
	public User getUserByName(String username);
	public void deleteUser(String username);
	public List<Role> getUserRoles();
	

}
