package springloz;

import java.io.Serializable;
import java.util.Date;
/**
 
/

**/
public class ReplyTable implements Serializable {
	
	private int themeid;
	private String replytext;
	private String time;
	private int replyid;
	private int uid;	 
	private int intflag;
	private int count;///所有回帖子总数量
	private String userName;///用户呢称
	private String imagead;//用户头像
	private String title;
	


	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getCount() {
		return count;
	}




	public void setCount(int count) {
		this.count = count;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getImagead() {
		return imagead;
	}




	public void setImagead(String imagead) {
		this.imagead = imagead;
	}




	public int getThemeid() {
		return themeid;
	}




	public void setThemeid(int themeid) {
		this.themeid = themeid;
	}




	public String getReplytext() {
		return replytext;
	}




	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}




	public String getTime() {
		return time;
	}




	public void setTime(String time) {
		this.time = time;
	}




	public int getReplyid() {
		return replyid;
	}




	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}




	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}




	public int getIntflag() {
		return intflag;
	}




	public void setIntflag(int intflag) {
		this.intflag = intflag;
	}



 



 




	public ReplyTable(int themeid, String replytext, String time, int replyid, int uid, int intflag, int count,
			String userName, String imagead, String title) {
		super();
		this.themeid = themeid;
		this.replytext = replytext;
		this.time = time;
		this.replyid = replyid;
		this.uid = uid;
		this.intflag = intflag;
		this.count = count;
		this.userName = userName;
		this.imagead = imagead;
		this.title = title;
	}




	@Override
	public String toString() {
		return "ReplyTable [themeid=" + themeid + ", replytext=" + replytext + ", time=" + time + ", replyid=" + replyid
				+ ", uid=" + uid + ", intflag=" + intflag + ", count=" + count + ", userName=" + userName + ", imagead="
				+ imagead + ", title=" + title + "]";
	}




	public ReplyTable() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	
	
	
	
	
	

}
