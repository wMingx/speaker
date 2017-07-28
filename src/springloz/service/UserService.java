/**
 * 
 */
/**
 * @author loz
 *
 */
package springloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springloz.User;
import springloz.UserLogin;
import springloz.dao.IUserDao;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	
	
	public List<User> selectUser(User user)
	{
		 List<User> list=userDao.selsctUser(user);
		 
		 return list;
	}
	
	/**
	 * @方法：selsctUserLogin 用户查询信息
	 * @参数：userLogin 用户查询条件
	 * @返回值：查询到用户信息
	 */
	@Override
	public List<UserLogin> selsctUserLoginCheck(UserLogin userLogin) {
	// TODO Auto-generated method stub
	
	List<UserLogin> list=userDao.selsctUserLoginCheck(userLogin);
	
	return list;
	}
	
	
	
	/**
	 * @方法：selsctUserCodeLoginCheck 用户查询信息
	 * @参数：userName  userCode 用户查询条件
	 * @返回值：查询到用户信息
	 */
	@Override
	public List<UserLogin> selsctUserCodeLoginCheck(UserLogin userLogin) {
	// TODO Auto-generated method stub
	
	List<UserLogin> list=userDao.selsctUserCodeLoginCheck(userLogin);
	
	return list;
	}
	
	
	
	
	
}