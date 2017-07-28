package springloz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.UserLogin;

/**
 * @作者：loz
 * @备注：用户查询信息DAO层
 * @UserLoginDao
 */



@Repository
public class UserLoginDao implements IUserLoginDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/**
	 * @方法：selsctUserLogin 用户查询信息
	 * @参数：userLogin 用户查询条件
	 * @返回值：查询到用户信息
	 */
	@Override
	public List<UserLogin> selsctUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userLogin.selectUserLogin", userLogin);
	}
	/**
	 * @方法：insertUserLogin 添加新的用户信息
	 * @参数：userLogin 添加的用户信息
	 * @返回值：无
	 */
	@Override
	public void insertUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub
		sqlSession.insert("userLogin.insertUserLogin", userLogin);
	}
	
	@Override
	public void updateUserLoginusername(UserLogin userLogin) {
		// TODO Auto-generated method stub
		sqlSession.insert("userLogin.updateUserLoginusername", userLogin);
	}
	
	@Override
	public void updateUserLoginpass(UserLogin userLogin) {
		// TODO Auto-generated method stub
		sqlSession.insert("userLogin.updateUserLoginpass", userLogin);
	}
	
	@Override
	public void updateUserLoginimag(UserLogin userLogin) {
		// TODO Auto-generated method stub
		sqlSession.insert("userLogin.updateUserLoginimag", userLogin);
	}
	
	
 

}
