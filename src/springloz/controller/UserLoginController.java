package springloz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.runtime.internal.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import springloz.PushMessageRe;
import springloz.User;
import springloz.UserLogin;
import springloz.service.IUserLoginService;
import springloz.service.IUserService;
import util.*;
import java.util.regex.*;

/**
 * @��ַ��manager/userlogin/selsctuserlogin ��ѯ�û���ѯ��Ϣ
 * @��ַ��manager/userlogin/selsctuserloginsession �жϵ�¼���
 * @��ַ��manager/userlogin/insertuserlogin ����µ��û���Ϣ
 * 
 */

@RequestMapping("manager/userlogin")
@Controller
public class UserLoginController {
	
	@Autowired
	private IUserLoginService userLoginService ;
	
	@Autowired
	private IUserService  userService;
	
	/**
	 * @������selsctUserLogin �û���ѯ��Ϣ
	 * @������userLogin �û���ѯ����
	 * @����ֵ����ѯ���û���Ϣ
	 */
	

	@RequestMapping(value="selsctuserlogin",method=RequestMethod.POST)	
	@ResponseBody
	public List<UserLogin> selsctUserLogin(@RequestBody UserLogin userLogin,HttpServletResponse	response) {
	       

		Object name="" ;
		List<UserLogin> list=userLoginService.selsctUserLogin(userLogin);	
		
		SessionHolder.removeAttribute("name");
		SessionHolder.removeAttribute("userRights");
		SessionHolder.removeAttribute("sessionname");
		SessionHolder.removeAttribute("uid");
		SessionHolder.removeAttribute("img");
		UserLogin tem=new UserLogin();
		
		if(userLogin.getIntflag()==2)
		{		
			for(int i=0;i<list.size();i++)
			{
				if(userLogin.getEmail().equals(list.get(i).getUserName())||userLogin.getEmail().equals(list.get(i).getEmail()))
				{
					SessionHolder.setAttribute("name", "session");  
					SessionHolder.setAttribute("uid", list.get(i).getUid());  
					SessionHolder.setAttribute("userRights", list.get(i).getUserRights());  
					SessionHolder.setAttribute("sessionname", list.get(i).getUserName());  
					SessionHolder.setAttribute("img", list.get(i).getImagead());  
					tem=list.get(i);
				}
			}
		}
		//SessionHolder.setAttribute("name", "session");  
		name= SessionHolder.getAttribute("name");  
		// name = SessionHolder.getAttribute("name");  
		if (name==null)
		{
			list=null;
			
		}else {						
			list.clear();			
			list.add(tem);						
		}
	       
		System.out.println(name);   
		
		return list;
		
	}
	
	
	
	
	/**
	 * @������selsctUserLoginsession �жϵ�¼���
	 *
	 * @����ֵ����ѯ����¼���
	 */	

	@RequestMapping(value="selsctuserloginsession",method=RequestMethod.POST)	
	@ResponseBody
	public List<UserLogin> selsctUserLoginsession(@RequestBody UserLogin userLogin,HttpServletResponse	response) {
	       		
		String name="" ;
		String img="0.jpg" ;
		
		List<UserLogin> list=new ArrayList<UserLogin>();	
		
		UserLogin tem=new UserLogin();	
		
		if(SessionHolder.getAttribute("sessionname")!=null&&SessionHolder.getAttribute("sessionname")!="")
		{
			name= SessionHolder.getAttribute("sessionname").toString(); 
			
			if(SessionHolder.getAttribute("img")!=null)
			{
			  img= SessionHolder.getAttribute("img").toString();  
			}else {
				SessionHolder.setAttribute("img", "/download/0.jpg"); 
			}
			tem.setUserName(name);			
			tem.setImagead(img);
			tem.setUid(Integer.valueOf( SessionHolder.getAttribute("uid").toString()));
			System.out.println(name);  
		}else {
			
			 
		}
		 
		
		list.add(tem);
		
		return list;
		
	}
	
	 public static boolean isEmail( String str ) {
        String regex = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}" ;
        return match( regex ,str );
    }
    /**
     * @param ����֤���ַ���
     * @return ����Ƿ�����ַ��ʽ���ַ���,����<b>true</b>,����Ϊ<b>false</b>
     */
    public static boolean isHomepage( String str ){
        String regex = "http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*" ;
        return match( regex ,str );
    }
    /** 
     * @param regex ������ʽ�ַ���
     * @param str   Ҫƥ����ַ���
     * @return ���str ���� regex��������ʽ��ʽ,����true, ���򷵻� false;
     */
    private static boolean match( String regex ,String str ){
        Pattern pattern = Pattern.compile(regex);
        Matcher  matcher = pattern.matcher( str );
        return matcher.matches();
    }
	
	/**
	 * @������insertUserLogin ����µ��û���Ϣ
	 * @������userLogin ��ӵ��û���Ϣ
	 * @����ֵ����
	 */
	@RequestMapping(value="insertuserlogin",method=RequestMethod.POST)	
	@ResponseBody
	public String insertUserLogin(@RequestBody UserLogin userLogin) {
		String logString=null;
    	try {    		
    		userLogin.setUserName(userLogin.getUserName().replace(" ", ""));
    		
    		userLogin.setEmail(userLogin.getEmail().replace(" ", ""));    		
    		
    		if(!isEmail(userLogin.getEmail()))
    		{
    			logString="email��ʽ����";
    		}
    		if(userLogin.getUserName().equals(""))
    		{
    			logString="�û�����Ϊ��";
    		}
    		if(userLogin.getPassword().length()<6 )
    		{
    			logString="����λ��̫��";
    		}
    		if(!userLogin.getPassword().equals(userLogin.getUserRights()) )
    		{
    			logString="�����������";
    		}
    		if(userLogin.getIntflag()!=2 )
    		{
    			logString="��֤����";
    		}
    		
    		List<UserLogin> listlogin=userService.selsctUserCodeLoginCheck(userLogin);	
    		
    		for(int i=0;i<listlogin.size();i++)
    		{
    			if(userLogin.getUserName().equals(listlogin.get(i).getUserName()))
    			{
    				logString="�û�����ͬ";
    				break;
    			}
    			if(userLogin.getEmail().equals(listlogin.get(i).getEmail()))
    			{
    				logString="��������ʹ��";
    				break;
    			}    			
    		}    		

    		if(logString==null )
    		{
    			UserLogin Login=new UserLogin();
    			Login.setEmail(userLogin.getEmail());
    			Login.setIntflag(0);
    			Login.setUserName(userLogin.getUserName());
    			Login.setPassword(userLogin.getPassword());
    			Login.setUserRights("��ͨ");
    			Login.setUsermessageflag(userLogin.getUsermessageflag());    			
    			userLoginService.insertUserLogin(Login);
    		}
    		    		
    	}
    	catch(Exception log){
    		
    		logString=log.toString();    		
    	}
		
    	return logString;				
	}
	
	@RequestMapping(value="updateUserLoginusername",method=RequestMethod.POST)	
	@ResponseBody
	public String updateUserLoginusername(@RequestBody UserLogin userLogin) {
		String logString=null;
    	try {    		
    		userLogin.setUserName(userLogin.getUserName().replace(" ", ""));
    		
    		userLogin.setEmail(userLogin.getEmail().replace(" ", ""));    		
    		
    		if(!isEmail(userLogin.getEmail()))
    		{
    			logString="email��ʽ����";
    		}
    		if(userLogin.getUserName().equals(""))
    		{
    			logString="�û�����Ϊ��";
    		}
    		List<UserLogin> listlogin=userService.selsctUserCodeLoginCheck(userLogin);	
    		
    		for(int i=0;i<listlogin.size();i++)
    		{
    			if(userLogin.getUserName().equals(listlogin.get(i).getUserName()))
    			{
    				logString="�û�����ͬ";
    				break;
    			}
    			if(userLogin.getEmail().equals(listlogin.get(i).getEmail()))
    			{
    				logString="��������ʹ��";
    				break;
    			}    			
    		}    		

    		if(logString==null )
    		{
    			UserLogin Login=new UserLogin();
    			Login.setEmail(userLogin.getEmail());    			 
    			Login.setUserName(userLogin.getUserName());    			 
    			Login.setUid(Conversions.intValue(SessionHolder.getAttribute("uid")));  
    			userLoginService.updateUserLoginusername(Login);
    			SessionHolder.removeAttribute("sessionname");
    			SessionHolder.setAttribute("sessionname", Login.getUserName());  
    			 
    		}    		    		
    	}
    	catch(Exception log){
    		
    		logString=log.toString();    		
    	}
		
    	return logString;				
	}
	
	@RequestMapping(value="updateUserLoginpass",method=RequestMethod.POST)	
	@ResponseBody
	public String updateUserLoginpass(@RequestBody UserLogin userLogin) {
		String logString=null;
    	try {    		
    
 
    		if(userLogin.getPassword().length()<6 )
    		{
    			logString="����λ��̫��";
    		}
    		if(!userLogin.getPassword().equals(userLogin.getUserRights()) )
    		{
    			logString="�ظ������������";
    		}
    		
    		UserLogin userpass=new UserLogin();
    		
    		userpass.setUid(Conversions.intValue(SessionHolder.getAttribute("uid")));    		
    		
    		List<UserLogin> listlogin=userService.selsctUserLoginCheck(userpass);
    		
    		if(!userLogin.getUserName().equals(listlogin.get(0).getPassword()) )
    		{
    			logString="�������������";
    		}
    		if(userLogin.getPassword().equals(listlogin.get(0).getPassword()) )
    		{
    			logString="���������������ͬ";
    		}
  		

    		if(logString==null )
    		{
    			UserLogin Login=new UserLogin();    			
    			Login.setPassword(userLogin.getPassword());    			 
    			Login.setUid(Conversions.intValue(SessionHolder.getAttribute("uid"))); 
    			userLoginService.updateUserLoginpass(Login);
    		}
    		    		
    	}
    	catch(Exception log){
    		
    		logString=log.toString();    		
    	}
		
    	return logString;				
	}
	
	@RequestMapping(value="updateUserLoginimag",method=RequestMethod.POST)	
	@ResponseBody
	public String updateUserLoginimag(@RequestBody UserLogin userLogin) {
		String logString=null;
    	try { 

    		if(logString==null )
    		{
    			UserLogin Login=new UserLogin();
 
    			Login.setUid(Conversions.intValue(SessionHolder.getAttribute("uid")));    			
    			userLoginService.updateUserLoginimag(Login);
    			 
    		}
    		    		
    	}
    	catch(Exception log){
    		
    		logString=log.toString();    		
    	}
		
    	return logString;				
	}
	
	public static final String FILE_PATH = "/upload/";  
	    
	    //�ļ��ϴ�  
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {  
        String fileName = file.getOriginalFilename();  
        File tempFile = new File(FILE_PATH, new Date().getTime() + String.valueOf(fileName));  
        if (!tempFile.getParentFile().exists()) {  
            tempFile.getParentFile().mkdir();  
        }  
        if (!tempFile.exists()) {  
            tempFile.createNewFile();  
        }  
        file.transferTo(tempFile);  
        //return "/download?fileName=" + tempFile.getName();  
        return "/download/" + tempFile.getName();
    }  
  
    public static File getFile(String fileName) {  
        return new File(FILE_PATH, fileName);  
    } 
    
    
	@RequestMapping(value="selectreplyimgup",method=RequestMethod.POST)	
	@ResponseBody
	public List<UserLogin> selectreplyimgup( UserLogin userLogin  ,ServletRequest request) throws Exception, IOException{

		List<UserLogin> list =new ArrayList<UserLogin>();
		
		try{
	       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
	       
	       MultipartFile multipartFile = multipartRequest.getFile("file");  	       
	       
	       String filePath =  uploadFile(multipartFile, (HttpServletRequest)request);  
	       
	       UserLogin usimag=new UserLogin();
	       
	       usimag.setImagead(filePath);
	       
	       usimag.setUid(Conversions.intValue(SessionHolder.getAttribute("uid"))); 
	       
	       userLoginService.updateUserLoginimag(usimag);
	       
	       list.add(usimag);
	       SessionHolder.removeAttribute("img");
		   SessionHolder.setAttribute("img", usimag.getImagead());  
	       
		}catch (Exception e) {
				// TODO: handle exception
			list=null;
		}
	
	
	return list;
	
	}
}
