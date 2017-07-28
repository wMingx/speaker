package springloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.UserLogin;
import springloz.dao.IUserLoginDao;



/**
 * @作者：loz
 * @备注：用户查询信息Service层
 * @UserLoginService
 */



@Repository
public class UserLoginService implements IUserLoginService {

	//用户查询信息dao层依赖注入
	@Autowired		
	private IUserLoginDao userLoginDao;
	
			/**
			 * @方法：selsctUserLogin 用户查询信息
			 * @参数：userLogin 用户查询条件
			 * @返回值：查询到用户信息
			 */
	@Override
	public List<UserLogin> selsctUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub
		
		List<UserLogin> list=userLoginDao.selsctUserLogin(userLogin);
		
		return list;
	}

	
	
	/**
	 * @方法：insertUserLogin 添加新的用户信息
	 * @参数：userLogin 添加的用户信息
	 * @返回值：无
	 */
	@Override
	public void insertUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub

		userLoginDao.insertUserLogin(userLogin); 
	}

	
	@Override
	public void updateUserLoginusername(UserLogin userLogin) {
		// TODO Auto-generated method stub

		userLoginDao.updateUserLoginusername(userLogin); 
	}
	
	@Override
	public void updateUserLoginpass(UserLogin userLogin) {
		// TODO Auto-generated method stub

		userLoginDao.updateUserLoginpass(userLogin); 
	}
	
	@Override
	public void updateUserLoginimag(UserLogin userLogin) {
		// TODO Auto-generated method stub

		userLoginDao.updateUserLoginimag(userLogin); 
	}
	
	
	
	
 
}
