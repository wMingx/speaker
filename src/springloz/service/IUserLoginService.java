package springloz.service;

import java.util.List;

import springloz.UserLogin;

public interface IUserLoginService {
	
	List<UserLogin> selsctUserLogin(UserLogin userLogin);

	void insertUserLogin(UserLogin userLogin);
	
	void updateUserLoginusername(UserLogin userLogin);
	
	void updateUserLoginpass(UserLogin userLogin);
	
	void updateUserLoginimag(UserLogin userLogin);
}
