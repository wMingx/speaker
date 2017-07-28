package springloz;

import java.io.Serializable;
/**
 *  @来源表 maintenanceQuality_table
 *  @来源 		sourceIN	String
 *  @去向 		gone		String null
 *  @条码 		code		String
 *  @创建时间 	createdTime	datatime
	@序号		intflag		int --------nochange
	
	



*/
public class MaintenanceSourceINOUT implements Serializable {

	private String sourceIN;	
	private String gone;
	private String code;
	private String createdTime;
	private String intflag;
	public String getSourceIN() {
		return sourceIN;
	}
	public void setSourceIN(String sourceIN) {
		this.sourceIN = sourceIN;
	}
	public String getGone() {
		return gone;
	}
	public void setGone(String gone) {
		this.gone = gone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getIntflag() {
		return intflag;
	}
	public void setIntflag(String intflag) {
		this.intflag = intflag;
	}
	@Override
	public String toString() {
		return "MaintenanceSourceINOUT [sourceIN=" + sourceIN + ", gone="
				+ gone + ", code=" + code + ", createdTime=" + createdTime
				+ ", intflag=" + intflag + "]";
	}
	public MaintenanceSourceINOUT(String sourceIN, String gone, String code,
			String createdTime, String intflag) {
		super();
		this.sourceIN = sourceIN;
		this.gone = gone;
		this.code = code;
		this.createdTime = createdTime;
		this.intflag = intflag;
	}
	public MaintenanceSourceINOUT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
