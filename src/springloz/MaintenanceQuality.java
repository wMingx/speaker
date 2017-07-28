package springloz;

import java.io.Serializable;
/**
 *  @维修定性表 maintenanceQuality_table
 *  @故障定性 		quality		String
	@序号			intflag		int --------nochange
	
	



*/
public class MaintenanceQuality implements Serializable {

	private String quality;	
	private String intflag;
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getIntflag() {
		return intflag;
	}
	public void setIntflag(String intflag) {
		this.intflag = intflag;
	}
	@Override
	public String toString() {
		return "MaintenanceQuality [quality=" + quality + ", intflag="
				+ intflag + "]";
	}
	public MaintenanceQuality(String quality, String intflag) {
		super();
		this.quality = quality;
		this.intflag = intflag;
	}
	public MaintenanceQuality() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
