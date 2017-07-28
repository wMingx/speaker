package springloz;

import java.io.Serializable;

/**
 *  @主题信息表    theme_table
 *  @  		intflag		int
	@ 		themeid	int
	@ 		title	String
	@ 		themetext	String
	@ 		uid	       int
	@ 	titleflag	String
	@ 		barid	int
	@ 			updatauid	int
	@ 		time	datatime
	@ 		updatedTime	datatime



*/
public class ThemeTable implements Serializable {
	
	private int intflag;
	private int themeid;
	private String title;
	private String themetext;
	private String titleflag;
	private int barid;
	private int updatauid;
	private String time;
	private int uid;
	private String updatedTime;
	private int count;///所有帖子总数量
	private String userName;///用户呢称
	private String imagead;//用户头像
	private int replycount;///所有回复帖子总数量
	
	
	
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
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
	public int getIntflag() {
		return intflag;
	}
	public void setIntflag(int intflag) {
		this.intflag = intflag;
	}
	public int getThemeid() {
		return themeid;
	}
	public void setThemeid(int themeid) {
		this.themeid = themeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThemetext() {
		return themetext;
	}
	public void setThemetext(String themetext) {
		this.themetext = themetext;
	}
	public String getTitleflag() {
		return titleflag;
	}
	public void setTitleflag(String titleflag) {
		this.titleflag = titleflag;
	}
	public int getBarid() {
		return barid;
	}
	public void setBarid(int barid) {
		this.barid = barid;
	}
	public int getUpdatauid() {
		return updatauid;
	}
	public void setUpdatauid(int updatauid) {
		this.updatauid = updatauid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public ThemeTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ThemeTable [intflag=" + intflag + ", themeid=" + themeid + ", title=" + title + ", themetext="
				+ themetext + ", titleflag=" + titleflag + ", barid=" + barid + ", updatauid=" + updatauid + ", time="
				+ time + ", uid=" + uid + ", updatedTime=" + updatedTime + ", count=" + count + ", userName=" + userName
				+ ", imagead=" + imagead + ", replycount=" + replycount + "]";
	}
	public ThemeTable(int intflag, int themeid, String title, String themetext, String titleflag, int barid,
			int updatauid, String time, int uid, String updatedTime, int count, String userName, String imagead,
			int replycount) {
		super();
		this.intflag = intflag;
		this.themeid = themeid;
		this.title = title;
		this.themetext = themetext;
		this.titleflag = titleflag;
		this.barid = barid;
		this.updatauid = updatauid;
		this.time = time;
		this.uid = uid;
		this.updatedTime = updatedTime;
		this.count = count;
		this.userName = userName;
		this.imagead = imagead;
		this.replycount = replycount;
	}
 
 
	

	
	
	
}
