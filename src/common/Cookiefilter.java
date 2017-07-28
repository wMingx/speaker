package common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;

import springloz.UserLogin;
import springloz.service.IUserLoginService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
/**
 * Servlet Filter implementation class cookiefilter
 */

@WebFilter("/cookiefilter")
public class Cookiefilter implements Filter {

    /**
     * Default constructor. 
     */
	public Cookiefilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	private String excludedUrls;
	    
	public String getExcludedUrls()
	{			
		return excludedUrls;	
			 
	}

    public void setExcludedUrls(String excludedUrls) 
    {
 		this.excludedUrls = excludedUrls;		 
    }

    public static String getTime(String user_time) {
			  
    	String re_time = null;
			  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
			  
    	Date d;
			 
    	try {
				 
    		Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
			        .parse(user_time);				  
				  
    		Date date2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
			        .parse("1970/01/01 08:00:00");			        
				  
    		long l = date1.getTime() - date2.getTime() > 0 ? date1.getTime()
			        - date2.getTime() : date2.getTime() - date1.getTime();			       			         
			      
			re_time=Long.toString(l/1000) ;						
			  
    	} 
    	catch (ParseException e) 
    	{
			   // TODO Auto-generated catch block			   
    		e.printStackTrace();			  
    	}
			  
    	return re_time;			 
    }
		
		 
	    
	@Autowired
    private IUserLoginService userLoginService ; 
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		ServletRequest requesttest;		
		
		excludedUrls= config.getInitParameter("excludedUrls");  
		
		HttpServletRequest httprequesttest=(HttpServletRequest)request;
		
		HttpServletResponse httpresponsetest=(HttpServletResponse)response;
		
		String requestUri = httprequesttest.getRequestURI();        
		
		Cookie cook = new Cookie("timeout", null); 
		cook.setMaxAge(0);
		//httpresponsetest.addCookie(cook); 
		
	////判断是否访问登录页面
            if (requestUri.endsWith(excludedUrls)) {            	
            	System.out.println(requestUri); 
            	
            	if (httprequesttest.getHeader("x-forwarded-for") == null) {  
            		
            		System.out.println(httprequesttest.getRemoteAddr()); 
                }  
            	else {
            		System.out.println(httprequesttest.getHeader("x-forwarded-for"));
				}
            	 
            	
            	requesttest=request;         	
            
        		chain.doFilter(requesttest, response);
        		
        		// return;        		
            }
            else 
            {
            	  
               	/* if (requestUri.endsWith("/speaker/manager/themetable/insertthemetabletable"))
 	            {
 	            	requesttest=request;
 	            	chain.doFilter(requesttest, response);
 	            	return;
 	            }*/
            	 if (requestUri.endsWith("/speaker/manager/themetable/selectthemetable"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
            	 if (requestUri.endsWith("/speaker/manager/themetable/selectthemetablelike"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
            	 if (requestUri.endsWith("/speaker/manager/replyTable/selectReplyTablethemeid"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
            	/* if (requestUri.endsWith("/speaker/manager/replyTable/insertReplyTable"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }*/
            	 if (requestUri.endsWith("/speaker/manager/userlogin/selsctuserloginsession"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
            	 if (requestUri.endsWith("/speaker/manager/userlogin/insertuserlogin"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
            	 if (requestUri.endsWith("speaker/user/logout"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
            	 
             
            	
	            if (requestUri.endsWith("/speaker/"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
	            if (requestUri.endsWith("/speaker/html/"))
	            {
	            	requesttest=request;
	            	chain.doFilter(requesttest, response);
	            	return;
	            }
	            else 
	            { 	request.setCharacterEncoding("utf-8");
	            	/////查询时间戳	            	
	            	Map<String, String[]> map = request.getParameterMap();            	
	            	
	            	Set  keySet= map.keySet();

	            	Iterator iterator = keySet.iterator();

	            	String  testnum="";
	            	
	                while(iterator.hasNext()) 
	                {
	                	Object key = iterator.next();
	                
	                      if(key.equals("t"))
	                      {
	                    	  Object value[] = map.get(key);
	                       
	                    	  testnum=value[0].toString();     
	                      }
	                }	                
	                if(!(testnum.equals("")))
	                {	                	
	                	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
              	  
	                	String timechaS=getTime(df.format(new Date()));
               
	                	long lch = Long.parseLong(timechaS)-Long.parseLong(testnum); 
              	 
	                	if (lch>500) 
	                	{
	                		Cookie cookie = new Cookie("timeout", "timeout 超时");
	                		cookie.setMaxAge(3601);
	                		httpresponsetest.addCookie(cookie);
	                		 return;
	                	}else 
	                	{
	                	
	                		////判断session 是否登录	                		         		       
	            			HttpSession session = httprequesttest.getSession();
	            			
	            	        if (session.getAttribute("name") == null)
	            	        {	        	            
	            	        	Cookie cookie = new Cookie("timeout", "nosession 请重新登录");
	            	        	
	                    		cookie.setMaxAge(3601);
	                    		
	                    		httpresponsetest.addCookie(cookie);
	                    		
	                    		return;	            	         	            	          
	            	        }
	            	        else 
	            	        {
	            	        	requesttest=request;
	            	        	// pass the request along the filter chain
	            	       
	            	        	//response.setCharacterEncoding("utf-8");
	            	    		chain.doFilter(requesttest, response);	 	            	        	
	            			}    
						}
	                	
	                }
	                else
	                {  	                	
	                	if(requestUri.endsWith(".css")||requestUri.endsWith(".js")
	                			||requestUri.endsWith(".eot")||requestUri.endsWith(".svg")
	                			||requestUri.endsWith(".ttf")||requestUri.endsWith(".woff")
	                			||requestUri.endsWith(".html")||requestUri.endsWith(".xlsx")
	                			||requestUri.endsWith(".gif")||requestUri.endsWith(".jpg")
	                			||requestUri.endsWith(".png"))
	                	{
	                		requesttest=request;
	                		
	                		chain.doFilter(requesttest, response);	 
	                	}
	                	else 
	                	{ 
	                		if(requestUri.endsWith(".see"))	                	
	                		{
	                			requesttest=request;
	                			chain.doFilter(requesttest, response);	 
	                			
	                		}
	                		
		                	Cookie cookie = new Cookie("timeout", "notime 请重新登录");
	                		cookie.setMaxAge(3601);
	                		httpresponsetest.addCookie(cookie);
	                		 return;               		 
	                		
	                	}
	                	
	                }
	                	            	
				}
            	            	
			}
   
        
		
		
	}
	


	public FilterConfig config;
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		   config = fConfig;
	}

}
