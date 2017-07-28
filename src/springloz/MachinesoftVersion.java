package springloz;

import java.io.Serializable;

public class MachinesoftVersion implements Serializable {
	
	private int inflag;
	private String machineCode;
	private String softVersion;
	private String machineModel;
	public int getInflag() {
		return inflag;
	}
	public void setInflag(int inflag) {
		this.inflag = inflag;
	}
	public String getMachineCode() {
		return machineCode;
	}
	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}
	public String getSoftVersion() {
		return softVersion;
	}
	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}
	public String getMachineModel() {
		return machineModel;
	}
	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}
	@Override
	public String toString() {
		return "MachinesoftVersion [inflag=" + inflag + ", machineCode=" + machineCode + ", softVersion=" + softVersion
				+ ", machineModel=" + machineModel + "]";
	}
	public MachinesoftVersion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MachinesoftVersion(int inflag, String machineCode, String softVersion, String machineModel) {
		super();
		this.inflag = inflag;
		this.machineCode = machineCode;
		this.softVersion = softVersion;
		this.machineModel = machineModel;
	}
	
	

	

}
