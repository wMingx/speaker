package springloz;

import java.io.Serializable;
/**
 *  @来源参数表 maintenanceQuality_table
 *  @来源参数 		source		String
	@序号			intflag		int --------nochange
	
	



*/
public class MaintenanceSource implements Serializable {
	private String source;	
	private String intflag;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIntflag() {
		return intflag;
	}
	public void setIntflag(String intflag) {
		this.intflag = intflag;
	}
	@Override
	public String toString() {
		return "MaintenanceSource [source=" + source + ", intflag=" + intflag
				+ "]";
	}
	public MaintenanceSource(String source, String intflag) {
		super();
		this.source = source;
		this.intflag = intflag;
	}
	public MaintenanceSource() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
