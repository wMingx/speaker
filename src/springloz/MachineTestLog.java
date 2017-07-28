package springloz;

import java.io.Serializable;

/**         @产品测试记录表 整机测试记录
            @测试编码	    machineModel				String
			@名称	   		machineName				String
			@原始值			originalValue			String
			@系数     		ratio					String
			@数据	        data 					String
			@数据下限		dataMin					String
			@数据上限		dataMax					String
			@故障标示		faultFlag					String
			@测试时间		testTime///旧参数 尽量不使用	String
			@创建时间		createdTime					datatime
*/
public class MachineTestLog implements Serializable {

	
	private String machineModel;
	private String machineName;
	private String originalValue;
	private String ratio;
	private String data;
	private String dataMin;
	private String dataMax;
	private String faultFlag;
	private String testTime;
	private String createdTime;
	public String getMachineModel() {
		return machineModel;
	}
	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(String originalValue) {
		this.originalValue = originalValue;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDataMin() {
		return dataMin;
	}
	public void setDataMin(String dataMin) {
		this.dataMin = dataMin;
	}
	public String getDataMax() {
		return dataMax;
	}
	public void setDataMax(String dataMax) {
		this.dataMax = dataMax;
	}
	public String getFaultFlag() {
		return faultFlag;
	}
	public void setFaultFlag(String faultFlag) {
		this.faultFlag = faultFlag;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "MachineTestLog [machineModel=" + machineModel
				+ ", machineName=" + machineName + ", originalValue="
				+ originalValue + ", ratio=" + ratio + ", data=" + data
				+ ", dataMin=" + dataMin + ", dataMax=" + dataMax
				+ ", faultFlag=" + faultFlag + ", testTime=" + testTime
				+ ", createdTime=" + createdTime + "]";
	}
	public MachineTestLog(String machineModel, String machineName,
			String originalValue, String ratio, String data, String dataMin,
			String dataMax, String faultFlag, String testTime,
			String createdTime) {
		super();
		this.machineModel = machineModel;
		this.machineName = machineName;
		this.originalValue = originalValue;
		this.ratio = ratio;
		this.data = data;
		this.dataMin = dataMin;
		this.dataMax = dataMax;
		this.faultFlag = faultFlag;
		this.testTime = testTime;
		this.createdTime = createdTime;
	}
	public MachineTestLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
