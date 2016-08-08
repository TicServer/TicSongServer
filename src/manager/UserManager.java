package manager;

import java.util.ArrayList;

import java.util.ArrayList;

import DAO.UserDAO;
import DTO.UserDTO;

public class UserManager {

	private static final UserManager instance = new UserManager();
	private static UserDAO userDao;
	
	private UserManager() {
		userDao = UserDAO.getInstance();
	}
	
	public static UserManager getInstance() {
		return instance;
	}
	
	public UserDTO login(String userId, String name) {
		return userDao.login(userId, name);
	}
	
	public int insertUser(String userId, String name) {
		return userDao.insertUser(userId, name);
	}
	
}
