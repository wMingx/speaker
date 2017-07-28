package springloz;

import java.io.Serializable;


/**
 *  @维修输入表 maintenanceIN_table
 *  @编码 			code		String
	@机型			model		String    null
	@送修人			maintenanceINer	String
	@送修时间		timeIN			datatime
	@送修原因		maintenanceINReason	String  null
	@状态			maintenanceFlag		String  送修中 维修中 维修完成 报废
	@送修描述		maintenanceINDescribe	datatime  null
	@序号			intflag					int --------nochange
	@创建时间		createdTime				datatime  --------nochange
	



*/
public class MaintenanceIN implements Serializable {

	private String code;
	private String model;
	private String maintenanceINer;
	private String timeIN;
	private String maintenanceINReason;
	private String maintenanceFlag;
	private String maintenanceINDescribe;
	private String intflag;
	private String createdTime;
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
	public String getMaintenanceINer() {
		return maintenanceINer;
	}
	public void setMaintenanceINer(String maintenanceINer) {
		this.maintenanceINer = maintenanceINer;
	}
	public String getTimeIN() {
		return timeIN;
	}
	public void setTimeIN(String timeIN) {
		this.timeIN = timeIN;
	}
	public String getMaintenanceINReason() {
		return maintenanceINReason;
	}
	public void setMaintenanceINReason(String maintenanceINReason) {
		this.maintenanceINReason = maintenanceINReason;
	}
	public String getMaintenanceFlag() {
		return maintenanceFlag;
	}
	public void setMaintenanceFlag(String maintenanceFlag) {
		this.maintenanceFlag = maintenanceFlag;
	}
	public String getMaintenanceINDescribe() {
		return maintenanceINDescribe;
	}
	public void setMaintenanceINDescribe(String maintenanceINDescribe) {
		this.maintenanceINDescribe = maintenanceINDescribe;
	}
	public String getIntflag() {
		return intflag;
	}
	public void setIntflag(String intflag) {
		this.intflag = intflag;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "MaintenanceIN [code=" + code + ", model=" + model
				+ ", maintenanceINer=" + maintenanceINer + ", timeIN=" + timeIN
				+ ", maintenanceINReason=" + maintenanceINReason
				+ ", maintenanceFlag=" + maintenanceFlag
				+ ", maintenanceINDescribe=" + maintenanceINDescribe
				+ ", intflag=" + intflag + ", createdTime=" + createdTime + "]";
	}
	public MaintenanceIN(String code, String model, String maintenanceINer,
			String timeIN, String maintenanceINReason, String maintenanceFlag,
			String maintenanceINDescribe, String intflag, String createdTime) {
		super();
		this.code = code;
		this.model = model;
		this.maintenanceINer = maintenanceINer;
		this.timeIN = timeIN;
		this.maintenanceINReason = maintenanceINReason;
		this.maintenanceFlag = maintenanceFlag;
		this.maintenanceINDescribe = maintenanceINDescribe;
		this.intflag = intflag;
		this.createdTime = createdTime;
	}
	public MaintenanceIN() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
