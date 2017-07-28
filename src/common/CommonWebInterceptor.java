package common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import util.SessionHolder;

public class CommonWebInterceptor implements WebRequestInterceptor {

	@Override
	public void afterCompletion(WebRequest arg0, Exception arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(WebRequest arg0, ModelMap arg1) throws Exception {
		// TODO Auto-generated method stub

	
		
    	Set  keySet= arg1.keySet();

    	Iterator iterator = keySet.iterator();

    	String  testnum="";
    	
        while(iterator.hasNext()) 
        {
        	Object key = iterator.next();
        
              if(key.equals("userPassword"))
              {
            	  Object value = arg1.get(key);
               
            	  testnum=value.toString();     
              }
        }
    	
    	
        if(!(testnum.equals("")))
        {	
        	SessionHolder.setAttribute("name", "session");  	
        	
        }
		
		
		
	}

	@Override
	public void preHandle(WebRequest arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
