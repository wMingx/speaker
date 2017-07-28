package springloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.UserLogin;
import springloz.dao.IUserLoginDao;



/**
 * @���ߣ�loz
 * @��ע���û���ѯ��ϢService��
 * @UserLoginService
 */



@Repository
public class UserLoginService implements IUserLoginService {

	//�û���ѯ��Ϣdao������ע��
	@Autowired		
	private IUserLoginDao userLoginDao;
	
			/**
			 * @������selsctUserLogin �û���ѯ��Ϣ
			 * @������userLogin �û���ѯ����
			 * @����ֵ����ѯ���û���Ϣ
			 */
	@Override
	public List<UserLogin> selsctUserLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub
		
		List<UserLogin> list=userLoginDao.selsctUserLogin(userLogin);
		
		return list;
	}

	
	
	/**
	 * @������insertUserLogin ����µ��û���Ϣ
	 * @������userLogin ��ӵ��û���Ϣ
	 * @����ֵ����
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
