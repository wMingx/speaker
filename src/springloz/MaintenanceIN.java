package springloz;

import java.io.Serializable;


/**
 *  @ά������� maintenanceIN_table
 *  @���� 			code		String
	@����			model		String    null
	@������			maintenanceINer	String
	@����ʱ��		timeIN			datatime
	@����ԭ��		maintenanceINReason	String  null
	@״̬			maintenanceFlag		String  ������ ά���� ά����� ����
	@��������		maintenanceINDescribe	datatime  null
	@���			intflag					int --------nochange
	@����ʱ��		createdTime				datatime  --------nochange
	



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
