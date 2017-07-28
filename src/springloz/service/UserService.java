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
	 * @������selsctUserLogin �û���ѯ��Ϣ
	 * @������userLogin �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 */
	@Override
	public List<UserLogin> selsctUserLoginCheck(UserLogin userLogin) {
	// TODO Auto-generated method stub
	
	List<UserLogin> list=userDao.selsctUserLoginCheck(userLogin);
	
	return list;
	}
	
	
	
	/**
	 * @������selsctUserCodeLoginCheck �û���ѯ��Ϣ
	 * @������userName  userCode �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 */
	@Override
	public List<UserLogin> selsctUserCodeLoginCheck(UserLogin userLogin) {
	// TODO Auto-generated method stub
	
	List<UserLogin> list=userDao.selsctUserCodeLoginCheck(userLogin);
	
	return list;
	}
	
	
	
	
	
}