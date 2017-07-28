/**
 * 
 */
/**
 * @author loz
 *
 */
package springloz.controller;

import java.util.List;

import org.apache.http.impl.cookie.PublicSuffixListParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CookieValue;

import springloz.User;
import springloz.UserLogin;
import springloz.service.IUserService;
import util.SessionHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @��ַ��user/selsctuserlogincheck ��ѯ�û���ѯ��Ϣ
   @��ַ��user/selsctusercodelogincheck ��ѯ�û���ѯ��Ϣ
 * 
 */
@RequestMapping("user")
@Controller
public class UserController{
	
	@Autowired
	private IUserService  userService;
	/**
	 * @������selectuser �û���ѯ������Ա��Ϣ
	 * @������User �û���ѯ����
	 * @����ֵ����ѯ��������Ա��Ϣ
	 */
	@RequestMapping(value="selectuser",method=RequestMethod.POST)
	
	@ResponseBody

	public List<User> selectuser(User user,@CookieValue(value = "JSESSIONID", defaultValue = "123") String cook,HttpServletResponse	response){
		//String name = "JSESSIONID";
		//String value = "vvvaaa";
		//Cookie cookie = new Cookie(name,value);
		//cookie.setMaxAge(3601);
		//response.addCookie(cookie);
		//Object name3 = SessionHolder.getAttribute("name");  
		//SessionHolder.setAttribute("name", "session");  
		
		//String value2=cook;
	List<User> list=userService.selectUser(user);
	
	return list;
	
	}
	
	
	////////ע��
	@RequestMapping(value="logout",method=RequestMethod.GET)
	
	@ResponseBody

	public List<User> logout(User user,@CookieValue(value = "JSESSIONID", defaultValue = "123") String cook,HttpServletResponse	response){
		 
	List<User> list=null;
	
	SessionHolder.invalidate(); 
	try{
	response.sendRedirect("../../speaker/index.html");
	}catch (Exception e) {
		// TODO: handle exception
	}
	return list;
	
	}
	
	/**
	 * @������selsctUserLoginCheck �û���ѯ��Ϣ
	 * @������userLogin �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 */
	

	@RequestMapping(value="selsctuserlogincheck",method=RequestMethod.POST)	
	@ResponseBody
	public List<UserLogin> selsctUserLoginCheck( UserLogin userLogin,HttpServletResponse	response) {
	      	
		
		List<UserLogin> list=userService.selsctUserLoginCheck(userLogin);	
		return list;
		
	}
	
	
	
	
	
	/**
	 * @������selsctusercodelogincheck �û���ѯ��Ϣ
	 * * @������userName  userCode �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 * 
	 */
	

	@RequestMapping(value="selsctusercodelogincheck",method=RequestMethod.POST)	
	@ResponseBody
	public List<UserLogin> selsctUserCodeLoginCheck( UserLogin userLogin,HttpServletResponse	response) {
	      	
		
		List<UserLogin> list=userService.selsctUserLoginCheck(userLogin);	
		return list;
		
	}
	/**
	 * @������selectusertime ά��session��ʧЧ 25min��ʱ����
	 * @������User 
	 * @����ֵ��
	 */
	@RequestMapping(value="selectusertime",method=RequestMethod.POST)
	
	@ResponseBody

	public List<User> selectusertime(User user,@CookieValue(value = "JSESSIONID", defaultValue = "123") String cook,HttpServletResponse	response){
		
	List<User> list=null;
	
	return list;
	
	}
	
	
}