package util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @备注：session工具�?
 */
public class SessionHolder {
	
	//私有的构造方法，防止其被实例�?
	private SessionHolder() {
		super();
	}
	
	//获取当前session
	private static HttpSession getSession() {
		 
		ServletRequestAttributes servletRequestAttributes = 
				(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return servletRequestAttributes.getRequest().getSession();
	}
	
	/**
	 * @方法：getAttribute 获取session中的�?
	 * @参数：key �?要获取的值的key
	 * @返回值：根据key获取到的值，若没有对应的key则返回null
	 */
	public static Object getAttribute(String key) {
		return getSession().getAttribute(key);
	}
	
	/**
	 * @方法：getAttributeText 获取字符串类型的�?
	 * @参数：key �?要获取的值的key
	 * @返回值：根据key获取到�?�，然后调用该�?�的toString()方法，若为null则返�?""
	 */
	public static String getAttributeText(String key) {
		Object obj = getSession().getAttribute(key);
		return null != obj ? obj.toString() : "";
	}
	
	/**
	 * @方法：setAttribute 将键值对放入session
	 * @参数：key �?
	 * @参数：value �?
	 * @返回值：�?
	 */
	public static void setAttribute(String key, Object value) {
		getSession().setAttribute(key, value);
	}
	
	/**
	 * @方法：removeAttribute 删除session中对应key的�??
	 * @参数：key �?要删除的值的key
	 */
	public static void removeAttribute(String key) {
		getSession().removeAttribute(key);
	}
	
	/**
	 * @方法：invalidate 删除当前session对象
	 * @参数：无
	 * @返回值：�?
	 */
	public static void invalidate() {
		getSession().invalidate();
	}
	
}
