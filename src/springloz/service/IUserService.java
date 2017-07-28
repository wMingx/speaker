package springloz.service;

import java.util.List;

import springloz.User;
import springloz.UserLogin;

public interface IUserService {
	
	List<User> selectUser(User user);
	List<UserLogin> selsctUserLoginCheck(UserLogin userLogin);
	List<UserLogin> selsctUserCodeLoginCheck(UserLogin userLogin);

}
