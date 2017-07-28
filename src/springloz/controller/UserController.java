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
 * @地址：user/selsctuserlogincheck 查询用户查询信息
   @地址：user/selsctusercodelogincheck 查询用户查询信息
 * 
 */
@RequestMapping("user")
@Controller
public class UserController{
	
	@Autowired
	private IUserService  userService;
	/**
	 * @方法：selectuser 用户查询生产人员信息
	 * @参数：User 用户查询条件
	 * @返回值：查询到生产人员信息
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
	
	
	////////注销
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
	 * @方法：selsctUserLoginCheck 用户查询信息
	 * @参数：userLogin 用户查询条件
	 * @返回值：查询到用户信息
	 */
	

	@RequestMapping(value="selsctuserlogincheck",method=RequestMethod.POST)	
	@ResponseBody
	public List<UserLogin> selsctUserLoginCheck( UserLogin userLogin,HttpServletResponse	response) {
	      	
		
		List<UserLogin> list=userService.selsctUserLoginCheck(userLogin);	
		return list;
		
	}
	
	
	
	
	
	/**
	 * @方法：selsctusercodelogincheck 用户查询信息
	 * * @参数：userName  userCode 用户查询条件
	 * @返回值：查询到用户信息
	 * 
	 */
	

	@RequestMapping(value="selsctusercodelogincheck",method=RequestMethod.POST)	
	@ResponseBody
	public List<UserLogin> selsctUserCodeLoginCheck( UserLogin userLogin,HttpServletResponse	response) {
	      	
		
		List<UserLogin> list=userService.selsctUserLoginCheck(userLogin);	
		return list;
		
	}
	/**
	 * @方法：selectusertime 维持session不失效 25min定时访问
	 * @参数：User 
	 * @返回值：
	 */
	@RequestMapping(value="selectusertime",method=RequestMethod.POST)
	
	@ResponseBody

	public List<User> selectusertime(User user,@CookieValue(value = "JSESSIONID", defaultValue = "123") String cook,HttpServletResponse	response){
		
	List<User> list=null;
	
	return list;
	
	}
	
	
}