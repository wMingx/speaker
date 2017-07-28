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
 * @地址：manager/themetable/selectthemetable 查询 信息?
 * @地址：manager/themetable/selectthemetablelike 查询 信息?
 * @地址：manager/themetable/selectthemeTableuid 查询 信息?
 * 
 * @地址：manager/themetable/insertthemetabletable 插入 信息
 * @地址：manager/themetable/updatethemetable 修改 信息
* @地址：manager/themetable/deletethemetable 删除 信息?
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
	 * @方法：selectthemetable 查询 
	 * @参数：themetable 用户输入的查询条件
	 * @返回值：查询到生 
	
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
	 * @方法：selectthemetablelike 查询 
	 * @参数：themetable 用户输入的查询条件
	 * @返回值：查询 
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
	 * @方法：selectthemeTableuid 查询 
	 * @参数：themetable 用户输入的查询条件
	 * @返回值：查询到  
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
	 * @方法：insertthemetabletable 插入生 
	 * @参数：themetable 插入生产信息
	 * @返回值：插入 
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
	    		logString="标题为空";
	    		return logString;
	    	}
	    	if(themetable.getThemetext().replace(" ", "")=="")
	    	{
	    		logString="内容为空";
	    		return logString;
	    	}
	    	
	    	if(logString==null)
	    	{
	    	newthemetable.setThemetext(themetable.getThemetext());
	    	
	    	newthemetable.setIntflag(0);
	    	
	    	newthemetable.setTitle(themetable.getTitle());
	    	
	    	newthemetable.setBarid(0);
	    	
	    	newthemetable.setTitleflag("正常");
	    	
	    	newthemetable.setUid( Integer.parseInt(SessionHolder.getAttribute("uid").toString()) );
	    	
	    	newthemetable.setUpdatauid(Integer.parseInt(SessionHolder.getAttribute("uid").toString()));
	    	
	    	newthemetable.setUpdatedTime(themetable.getUpdatedTime());
	    	
	 
		    themeTableService.insertThemeTable(newthemetable);	
		    
		    logString="ok";
		    
	    	}else {
	    		logString="发送失败";
			}
    	}catch (Exception e) {
			// TODO: handle exception
    		logString="发帖失败" ;
		}
    	
    	return logString;
	}
    
    
    
    /**
	 * @方法：updatethemetable 修改 信息
	 * @参数：themetable 修改 信息
	 * @返回值：修改 信息
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
  	 * @方法：deletethemetable 删除 息
  	 * @参数：themetable 修改 
  	 * @返回值：修改 
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
