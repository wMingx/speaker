package springloz;

import java.io.Serializable;
/**
 *  @维修表 maintenanceMachine_table/maintenancePcb_table
 *  @编码 			code		String
	@机型			model		String    null
	@故障定性		failureProperty	String null
	@处理方案		solution		String null
	@维修人			maintenancer	String  
	@维修时间		timeEnd		datatime--------nochange	
	@序号			intflag		int --------nochange
	@送修时间       timeIN      datatime
	@唯一时间标志       timeflag      datatime



*/
public class MaintenanceMachinePcb implements Serializable {

	private String code;
	private String model;
	private String failureProperty;
	private String solution;
	private String maintenancer;
	private String timeEnd;
	private String intflag;
	private String timeIN;
	public String getTimeflag() {
		return timeflag;
	}
	public void setTimeflag(String timeflag) {
		this.timeflag = timeflag;
	}
	private String timeflag;
	public String getTimeIN() {
		return timeIN;
	}
	public void setTimeIN(String timeIN) {
		this.timeIN = timeIN;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFailureProperty() {
		return failureProperty;
	}
	public void setFailureProperty(String failureProperty) {
		this.failureProperty = failureProperty;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getMaintenancer() {
		return maintenancer;
	}
	public void setMaintenancer(String maintenancer) {
		this.maintenancer = maintenancer;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getIntflag() {
		return intflag;
	}
	public void setIntflag(String intflag) {
		this.intflag = intflag;
	}
	


	public MaintenanceMachinePcb(String code, String model,
			String failureProperty, String solution, String maintenancer,
			String timeEnd, String intflag, String timeIN, String timeflag) {
		super();
		this.code = code;
		this.model = model;
		this.failureProperty = failureProperty;
		this.solution = solution;
		this.maintenancer = maintenancer;
		this.timeEnd = timeEnd;
		this.intflag = intflag;
		this.timeIN = timeIN;
		this.timeflag = timeflag;
	}
	@Override
	public String toString() {
		return "MaintenanceMachinePcb [code=" + code + ", model=" + model
				+ ", failureProperty=" + failureProperty + ", solution="
				+ solution + ", maintenancer=" + maintenancer + ", timeEnd="
				+ timeEnd + ", intflag=" + intflag + ", timeIN=" + timeIN
				+ ", timeflag=" + timeflag + "]";
	}
	public MaintenanceMachinePcb() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
