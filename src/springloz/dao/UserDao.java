/**
 * 
 */
/**
 * @author loz
 *
 */
package springloz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import springloz.User;
import springloz.UserLogin;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<User> selsctUser(User user) {
		
		
		return sqlSession.selectList("user.selectUser", user);
		
	}
	
	/**
	 * @方法：selectUserLogincheck 用户查询信息
	 * @参数：userLogin 用户查询条件
	 * @返回值：查询到用户信息
	 */
	@Override
	public List<UserLogin> selsctUserLoginCheck(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userLogin.selectUserLogincheck", userLogin);
	}
	
	/**
	 * @方法：selsctUserCodeLoginCheck 用户查询信息
	 * @参数：userName  userCode 用户查询条件
	 * @返回值：查询到用户信息
	 */
	@Override
	public List<UserLogin> selsctUserCodeLoginCheck(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userLogin.selectUserLogincheckrights", userLogin);
	}
	
	
	
	
}