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
	 * @������selectUserLogincheck �û���ѯ��Ϣ
	 * @������userLogin �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 */
	@Override
	public List<UserLogin> selsctUserLoginCheck(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userLogin.selectUserLogincheck", userLogin);
	}
	
	/**
	 * @������selsctUserCodeLoginCheck �û���ѯ��Ϣ
	 * @������userName  userCode �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 */
	@Override
	public List<UserLogin> selsctUserCodeLoginCheck(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userLogin.selectUserLogincheckrights", userLogin);
	}
	
	
	
	
}