package springloz;

import java.io.Serializable;

/**         @测试记录表 test_record
			@型号编码 	code	String
			@型号 	    model	String
			@测试人员   testName	String
			@测试日期	 testTime	datatime
			@测试结果   testResults	String
			@旧时间标示   oldtesttime	String






*/
public class TestRecord implements Serializable {
	private String code;
	private String model;
	private String testName;
	private String testTime;
	private String testResults;
	private String oldtesttime;
	
	public String getOldtesttime() {
		return oldtesttime;
	}
	public void setOldtesttime(String oldtesttime) {
		this.oldtesttime = oldtesttime;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	public String getTestResults() {
		return testResults;
	}
	public void setTestResults(String testResults) {
		this.testResults = testResults;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public TestRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestRecord [code=" + code + ", model=" + model + ", testName="
				+ testName + ", testTime=" + testTime + ", testResults="
				+ testResults + ", oldtesttime=" + oldtesttime + "]";
	}
	public TestRecord(String code, String model, String testName,
			String testTime, String testResults, String oldtesttime) {
		super();
		this.code = code;
		this.model = model;
		this.testName = testName;
		this.testTime = testTime;
		this.testResults = testResults;
		this.oldtesttime = oldtesttime;
	}
	


	
	
	
}
