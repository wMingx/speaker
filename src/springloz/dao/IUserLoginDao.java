package springloz.dao;

import java.util.List;

import springloz.UserLogin;

public interface IUserLoginDao {
	List<UserLogin> selsctUserLogin(UserLogin userLogin);

	void insertUserLogin(UserLogin userLogin);
	
	void updateUserLoginusername(UserLogin userLogin);
	
	void updateUserLoginpass(UserLogin userLogin);
	
	void updateUserLoginimag(UserLogin userLogin);
}
