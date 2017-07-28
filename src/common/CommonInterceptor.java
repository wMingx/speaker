package common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import springloz.UserLogin;
import util.SessionHolder;

import javax.servlet.*;

import java.io.*;

public class CommonInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		
		if ( SessionHolder.getAttribute("Rights")!= null)
		{		
		 Cookie cookie = new Cookie("timeout", " 没有权限");
		 SessionHolder.setAttribute("Rights", null);
 		cookie.setMaxAge(3601);
 		
 		arg1.addCookie(cookie);
 		
		} 
		arg1.addHeader("Access-Control-Allow-Origin","*");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		//arg1.setCharacterEncoding("utf-8");
	
		
		
		
	/*	HttpSession session = arg0.getSession();
		
        if (session.getAttribute("name") == null)
        {	        	            
        	Cookie cookie = new Cookie("timeout", "nosession 请重新登录");
        	
    		cookie.setMaxAge(3601); 
    		
    		arg1.addCookie(cookie);
    		
    		return;	            	         	            	          
        }
        else 
        {
        	
		}   */
		
		
	//	ServletOutputStream  out = a();
		//Map<String, String[]> map2 =out.p.print(map);*/
		
	/////查询返回值
	/*	Map<String, String[]> map = arg0.getParameterMap();            	
		
    	Set  keySet= map.keySet();

    	Iterator iterator = keySet.iterator();

    	String  testnum="";
    	
        while(iterator.hasNext()) 
        {
        	Object key = iterator.next();
        
              if(key.equals("userPassword"))
              {
            	  Object value[] = map.get(key);
               
            	  testnum=value[0].toString();     
              }
        }
    	
    	
        if(!(testnum.equals("")))
        {	
        	SessionHolder.setAttribute("name", "session");  	
        	
        }*/
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
