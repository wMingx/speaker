/**
 * 
 */
/**
 * @author loz
 *
 */
package springloz;

import java.io.Serializable;

public class User implements Serializable 
{
	private String userName;
	private String address;
	private String age;
	private String sex;
	private String code;
	private String remark;
	
	public User() {
		super();
		// TODO 自动生成的构造函数存根
		
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
/*	public User(String userName, String address, int age, String sex) {
		super();
		this.userName = userName;
		this.address = address;
		this.age = age;
		this.sex = sex;
	}*/
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public User(String userName, String address, String age, String sex, String code,
		String remark) {
	super();
	this.userName = userName;
	this.address = address;
	this.age = age;
	this.sex = sex;
	this.code = code;
	this.remark = remark;
}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", address=" + address + ", age="
				+ age + ", sex=" + sex + ", code=" + code + ", remark="
				+ remark + "]";
	}
	
	
	
	
	
}

