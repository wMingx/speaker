package springloz.dao;

import java.util.List;

import springloz.User;
import springloz.UserLogin;



public interface IUserDao {
	
	List <User> selsctUser(User user);
	List<UserLogin> selsctUserLoginCheck(UserLogin userLogin);
	List<UserLogin> selsctUserCodeLoginCheck(UserLogin userLogin);

}
