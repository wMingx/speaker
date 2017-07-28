package springloz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.UserLogin;

/**
 * @���ߣ�loz
 * @��ע���û���ѯ��ϢDAO��
 * @UserLoginDao
 */



@Repository
public class UserLoginDao implements IUserLoginDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/**
	 * @������selsctUserLogin �û���ѯ��Ϣ
	 * @������userLogin �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 */
	@Override
	public List<UserLogin> selsctUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userLogin.selectUserLogin", userLogin);
	}
	/**
	 * @������insertUserLogin ����µ��û���Ϣ
	 * @������userLogin ��ӵ��û���Ϣ
	 * @����ֵ����
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
