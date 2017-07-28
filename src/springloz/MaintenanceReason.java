package springloz;

import java.io.Serializable;
/**
 *  @故障原因表 maintenanceQuality_table
 *  @故障原因 		reason		String
	@序号			intflag		int --------nochange
	
	



*/
public class MaintenanceReason implements Serializable {
	private String reason;	
	private String intflag;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getIntflag() {
		return intflag;
	}
	public void setIntflag(String intflag) {
		this.intflag = intflag;
	}
	@Override
	public String toString() {
		return "MaintenanceReason [reason=" + reason + ", intflag=" + intflag
				+ "]";
	}
	public MaintenanceReason(String reason, String intflag) {
		super();
		this.reason = reason;
		this.intflag = intflag;
	}
	public MaintenanceReason() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
