package springloz.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import springloz.ReplyTable;
import springloz.ThemeTable;
import springloz.UserLogin;
import springloz.service.IReplyTableService;
import springloz.service.IThemeTableService;
import springloz.service.IUserLoginService;
import springloz.service.IUserService;
import util.SessionHolder;

/**
 * @��ַ��manager/themetable/selectthemetable ��ѯ ��Ϣ?
 * @��ַ��manager/themetable/selectthemetablelike ��ѯ ��Ϣ?
 * @��ַ��manager/themetable/selectthemeTableuid ��ѯ ��Ϣ?
 * 
 * @��ַ��manager/themetable/insertthemetabletable ���� ��Ϣ
 * @��ַ��manager/themetable/updatethemetable �޸� ��Ϣ
* @��ַ��manager/themetable/deletethemetable ɾ�� ��Ϣ?
 */

@RequestMapping("manager/themetable")
@Controller
public class ThemeTableController {

	@Autowired
	private IThemeTableService themeTableService ;	
	
	@Autowired
	private IUserService  userService;
	
	@Autowired
	private IUserLoginService userLoginService ;
	
	@Autowired
	private IReplyTableService replyTableService ;
	
	/**
	 * @������selectthemetable ��ѯ 
	 * @������themetable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ���� 
	
	 */
	
    @RequestMapping(value="selectthemetable",method=RequestMethod.POST)	
	@ResponseBody
	public List<ThemeTable> selsctThemeTable(@RequestBody ThemeTable themetable)
	{
	
	List<ThemeTable> list=themeTableService.selsctThemeTable(themetable); 
	
	
	int themeTablecount=themeTableService.selectthemeTablecount(themetable); 
	
	
	
	for(int i=0;i<list.size();i++)
	{
		
		ReplyTable replyTable=new ReplyTable();
		
		replyTable.setThemeid(list.get(i).getThemeid());
		
		int replyTablecount=replyTableService.selectReplyTablecount(replyTable);
		
		UserLogin userLogin=new UserLogin();
		
		userLogin.setUid(list.get(i).getUid());
		
		List<UserLogin> UserLoginlist=userService.selsctUserLoginCheck(userLogin);	
		
		list.get(i).setCount(themeTablecount);		
		
		list.get(i).setReplycount(replyTablecount);		
		 
		if(UserLoginlist.size()>0)
		{
		list.get(i).setImagead(UserLoginlist.get(0).getImagead());
		
		list.get(i).setUserName(UserLoginlist.get(0).getUserName());
		}
	}
	
	return list;
	
	}

	/**
	 * @������selectthemetablelike ��ѯ 
	 * @������themetable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ 
	 */
	
    @RequestMapping(value="selectthemetablelike",method=RequestMethod.POST)	
	@ResponseBody
	public List<ThemeTable> selsctThemeTableLike(@RequestBody ThemeTable themetable)
	{
	
	List<ThemeTable> list=themeTableService.selsctThemeTableLike(themetable);
	
	UserLogin userLogin=new UserLogin();
	
	userLogin.setUid(list.get(0).getUid());
	
	List<UserLogin> UserLoginlist=userService.selsctUserLoginCheck(userLogin);	
	
	list.get(0).setUserName(UserLoginlist.get(0).getUserName());
	
	list.get(0).setImagead(UserLoginlist.get(0).getImagead());
	
	return list;
	
	}
    
	/**
	 * @������selectthemeTableuid ��ѯ 
	 * @������themetable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ��  
	 */
	
    @RequestMapping(value="selectthemeTableuid",method=RequestMethod.POST)	
	@ResponseBody
	public List<ThemeTable> selectthemeTableuid(@RequestBody ThemeTable themetable)
	{
    	
	List<ThemeTable> list=themeTableService.selectthemeTableuid(themetable);
    	
    int themeTablecount=themeTableService.selectthemeTableuidcount(themetable); 
    
	for(int i=0;i<list.size();i++)
	{		 
		list.get(i).setCount(themeTablecount);	
	}   
	
	return list;
	
	}
    
	/**
	 * @������insertthemetabletable ������ 
	 * @������themetable ����������Ϣ
	 * @����ֵ������ 
	 */
    @RequestMapping(value="insertthemetabletable",method=RequestMethod.POST)
	
	@ResponseBody
	public String  insertThemeTable(@RequestBody ThemeTable themetable)
	{
    	String logString=null;
    	
    	try{
	    	ThemeTable newthemetable= new ThemeTable();
	    	if(themetable.getTitle().replace(" ", "")=="")
	    	{
	    		logString="����Ϊ��";
	    		return logString;
	    	}
	    	if(themetable.getThemetext().replace(" ", "")=="")
	    	{
	    		logString="����Ϊ��";
	    		return logString;
	    	}
	    	
	    	if(logString==null)
	    	{
	    	newthemetable.setThemetext(themetable.getThemetext());
	    	
	    	newthemetable.setIntflag(0);
	    	
	    	newthemetable.setTitle(themetable.getTitle());
	    	
	    	newthemetable.setBarid(0);
	    	
	    	newthemetable.setTitleflag("����");
	    	
	    	newthemetable.setUid( Integer.parseInt(SessionHolder.getAttribute("uid").toString()) );
	    	
	    	newthemetable.setUpdatauid(Integer.parseInt(SessionHolder.getAttribute("uid").toString()));
	    	
	    	newthemetable.setUpdatedTime(themetable.getUpdatedTime());
	    	
	 
		    themeTableService.insertThemeTable(newthemetable);	
		    
		    logString="ok";
		    
	    	}else {
	    		logString="����ʧ��";
			}
    	}catch (Exception e) {
			// TODO: handle exception
    		logString="����ʧ��" ;
		}
    	
    	return logString;
	}
    
    
    
    /**
	 * @������updatethemetable �޸� ��Ϣ
	 * @������themetable �޸� ��Ϣ
	 * @����ֵ���޸� ��Ϣ
	 */
    @RequestMapping(value="updatethemetable",method=RequestMethod.POST)
	
	@ResponseBody
	public String updateThemeTable(ThemeTable themetable)
	{
    	String logString=null;
    	Object	name= SessionHolder.getAttribute("userRights");
    	int i=0;
	    
    	i=	themeTableService.updateThemeTable(themetable);	
 
    	
    	return logString;
	}
      
    
    
    
    /**
  	 * @������deletethemetable ɾ�� Ϣ
  	 * @������themetable �޸� 
  	 * @����ֵ���޸� 
  	 */
    @RequestMapping(value="deletethemetable",method=RequestMethod.POST)  	
  	@ResponseBody
  	public String deletethemetable(ThemeTable themetable)
  	{
      	String logString=null;
      	Object	name= SessionHolder.getAttribute("userRights");
 
  	    		int i=0;
  	    	i=	themeTableService.deletedateThemeTable(themetable);	
   
      	
      	return logString;
  	}
    

}
