package springloz;

import java.io.Serializable;

public class MachineCodeModel implements Serializable {

	private String machineCode;
	private String machineModel;
	private String time;
	private String intflag;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getMachineModel() {
		return machineModel;
	}
	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


	
	
	public MachineCodeModel(String machineCode, String machineModel,
			String time, String intflag, String name) {
		super();
		this.machineCode = machineCode;
		this.machineModel = machineModel;
		this.time = time;
		this.intflag = intflag;
		this.name = name;
	}
	@Override
	public String toString() {
		return "MachineCodeModel [machineCode=" + machineCode
				+ ", machineModel=" + machineModel + ", time=" + time
				+ ", intflag=" + intflag + ", name=" + name + "]";
	}
	public MachineCodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
