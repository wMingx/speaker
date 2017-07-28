package springloz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springloz.ReplyTable;
import springloz.ThemeTable;
import springloz.UserLogin;
import springloz.service.IReplyTableService;
import springloz.service.IThemeTableService;
import springloz.service.IUserLoginService;
import springloz.service.IUserService;
import util.SessionHolder;



/**
 * @地址：manager/replyTable/selectReplyTablethemeid   
 * @地址：manager/replyTable/selectReplyTableuid  
 * @地址：manager/replyTable/selectReplyTablereplyid  
 * @地址：manager/replyTable/insertReplyTable 插入 信息
 * @地址：manager/replyTable/updateReplyTable 修改 信息
 */

@RequestMapping("manager/replyTable")
@Controller
public class ReplyTableController {

	@Autowired
	private IReplyTableService replyTableService ;
	
	@Autowired
	private IThemeTableService themeTableService ;	
	
	@Autowired
	private IUserService  userService;
	
	@Autowired
	private IUserLoginService userLoginService ;
	/**
	 * @方法：selectReplyTablethemeid 库查询信息 分页返回
	 * @参数：replyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	
		@RequestMapping(value="selectReplyTablethemeid",method=RequestMethod.POST)	
		@ResponseBody
		@Transactional(readOnly = true,timeout=20,rollbackFor=Exception.class)	
		public List<ReplyTable> selectReplyTablethemeid(@RequestBody ReplyTable replyTable,HttpServletRequest	request)
		{						 
			 List<ReplyTable> list =replyTableService.selsctReplyTable(replyTable);
			 
			 int replyTablecount= replyTableService.selectReplyTablecount(replyTable);
			
			 for(int i=0;i<list.size();i++)
			{
				UserLogin userLogin=new UserLogin();
				
				userLogin.setUid(list.get(i).getUid());
				
				List<UserLogin> UserLoginlist=userService.selsctUserLoginCheck(userLogin);	
				
				list.get(i).setCount(replyTablecount);		
				 
				if(UserLoginlist.size()>0)
				{
				list.get(i).setImagead(UserLoginlist.get(0).getImagead());
				
				list.get(i).setUserName(UserLoginlist.get(0).getUserName());
				}
			}
			 
		    return list;		 		 
		}
	
	
	
	
	/**
	 * @方法：selectReplyTableuid 库查询信息
	 * @参数：replyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	
		@RequestMapping(value="selectReplyTableuid",method=RequestMethod.POST)	
		@ResponseBody
		public List<ReplyTable> selectReplyTableuid(@RequestBody ReplyTable replyTable)
		{
		 List<ReplyTable> list =replyTableService.selectReplyTableuid(replyTable);	
		 
		 int replyTablecount= replyTableService.selectReplyTableuidcount(replyTable);
		 
		 for(int i=0;i<list.size();i++)
		 {
			
		  list.get(i).setCount(replyTablecount);
		  
		  ThemeTable themetable= new ThemeTable(); 
		  
		  themetable.setThemeid(list.get(i).getThemeid());
		  
		  List<ThemeTable> listthemetable=themeTableService.selsctThemeTableLike(themetable);
		  
			if(listthemetable.size()>0)
			{
				list.get(i).setTitle(listthemetable.get(0).getTitle());
			}
		 }
		 
		 return list;
		 
		 
		}
	
		/**
		 * @方法：selectReplyTablereplyid 非模糊库查询信息
		 * @参数：replyTable 用户输入的查询条件
		 * @返回值：查询到库信息
		 */
		
		@RequestMapping(value="selectReplyTablereplyid",method=RequestMethod.POST)	
		@ResponseBody
		public List<ReplyTable> selectReplyTablereplyid(@RequestBody ReplyTable replyTable)
		{
			List<ReplyTable> list =replyTableService.selectReplyTablereplyid(replyTable);
			 
			return list;			 
			 
		}
		
		
		/**
		 * @方法：updateReplyTable 更新新的库信息
		 * @参数：replyTable 用户添加的库信息
		 * @返回值：无
		 */
		@RequestMapping(value="updatedeliverytable",method=RequestMethod.POST)	
		@ResponseBody
		public void updateReplyTable(@RequestBody ReplyTable replyTable) {
			
			replyTableService.updateReplyTable(replyTable);
			
		}
		
		
		/**
		 * @方法：insertReplyTable 添加新的库信息
		 * @参数：replyTable 用户添加的库信息
		 * @返回值：无
		 */
	    @RequestMapping(value="insertReplyTable",method=RequestMethod.POST)
		
		@ResponseBody
		@Transactional(readOnly = true,timeout=20,rollbackFor=Exception.class)	
		public String  insertReplyTable(@RequestBody ReplyTable replyTable)
		{
	    	String logString=null;
	    	try {	    	
	    		ThemeTable themetable=new ThemeTable();
	    		
	    		replyTable.setUid(Integer.parseInt(SessionHolder.getAttribute("uid").toString()));
	    		
	    		replyTableService.insertReplyTable(replyTable);
	    		
	    		themetable.setThemeid(replyTable.getThemeid()); 	
	    		
	    		themeTableService.updatethemeTabletime(themetable);	
	    		logString="ok";
		    	}
		    	catch(Exception log)
		    	{
		    		 logString=log.toString();
		    		
		    	}
	    	
	    	return logString;
	    	
		}
	
}
