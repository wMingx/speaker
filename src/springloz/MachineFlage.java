package springloz;

import java.io.Serializable;
/**
 *  @整机装配状态表 整机装配状态
	@排序		intflag	 		int(默认不可改)
	@整机编号	machineCode	 	String
	@整机型号	machineModel 	String  左查询从machineCodeModel表中查出机型
	@整机状态	machineFlag 	String  状态:装配中 装配完成
	@创建时间	createdTime 	datatime
	@修改时间	updatedTime	 	datatime




*/

public class MachineFlage implements Serializable {

	private String intflag;
	private String machineCode;
	private String machineModel;
	private String machineFlag;
	private String createdTime;
	private String updatedTime;
	
	
	
	
	public String getMachineModel() {
		return machineModel;
	}
	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}
	public String getIntflag() {
		return intflag;
	}
	public void setIntflag(String intflag) {
		this.intflag = intflag;
	}
	public String getMachineCode() {
		return machineCode;
	}
	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}
	public String getMachineFlag() {
		return machineFlag;
	}
	public void setMachineFlag(String machineFlag) {
		this.machineFlag = machineFlag;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public MachineFlage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MachineFlage [intflag=" + intflag + ", machineCode="
				+ machineCode + ", machineModel=" + machineModel
				+ ", machineFlag=" + machineFlag + ", createdTime="
				+ createdTime + ", updatedTime=" + updatedTime + "]";
	}
	public MachineFlage(String intflag, String machineCode,
			String machineModel, String machineFlag, String createdTime,
			String updatedTime) {
		super();
		this.intflag = intflag;
		this.machineCode = machineCode;
		this.machineModel = machineModel;
		this.machineFlag = machineFlag;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}
	
	
	
	
}
