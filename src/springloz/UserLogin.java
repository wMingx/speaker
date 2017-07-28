package springloz;

import java.io.Serializable;

/**



*/



public class UserLogin implements Serializable {
	
	private int intflag;
	private String userName;
	private int uid;
	private String userRights;
	private String password;
	private String time;
	private String email;
	private int usermessageflag;
	private String imagead;
	

	
	public String getImagead() {
		return imagead;
	}




	public void setImagead(String imagead) {
		this.imagead = imagead;
	}




	public int getUsermessageflag() {
		return usermessageflag;
	}




	public void setUsermessageflag(int usermessageflag) {
		this.usermessageflag = usermessageflag;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getIntflag() {
		return intflag;
	}




	public void setIntflag(int intflag) {
		this.intflag = intflag;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}




	public String getUserRights() {
		return userRights;
	}




	public void setUserRights(String userRights) {
		this.userRights = userRights;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getTime() {
		return time;
	}




	public void setTime(String time) {
		this.time = time;
	}		


	public UserLogin(int intflag, String userName, int uid, String userRights, String password, String time,
			String email, int usermessageflag, String imagead) {
		super();
		this.intflag = intflag;
		this.userName = userName;
		this.uid = uid;
		this.userRights = userRights;
		this.password = password;
		this.time = time;
		this.email = email;
		this.usermessageflag = usermessageflag;
		this.imagead = imagead;
	}




	@Override
	public String toString() {
		return "UserLogin [intflag=" + intflag + ", userName=" + userName + ", uid=" + uid + ", userRights="
				+ userRights + ", password=" + password + ", time=" + time + ", email=" + email + ", usermessageflag="
				+ usermessageflag + ", imagead=" + imagead + "]";
	}




	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
