package springloz;

import java.io.Serializable;


/**         @整机测试记录日志
 * 
@首次测试人员 	firstTestName	String
@测试编码 	    code			String
@首次测试结果   firstTestResult	String
@首次测试用例	firstTestEX		String
@首次测试时间   firstTestTime	String

@最后测试时间   lastTestTime	String
@最后测试人员 	lastTestName	String
@最后测试用例 	lastTestEX		String
@最后测试结果  	lastTestResult	String


*/
public class TestOverview implements Serializable {

	private String firstTestName;
	private String code;
	private String firstTestResult;
	private String firstTestEX;
	private String firstTestTime;
	
	private String lastTestTime;
	private String lastTestName;
	private String lastTestEX;
	private String lastTestResult;
	public String getFirstTestName() {
		return firstTestName;
	}
	public void setFirstTestName(String firstTestName) {
		this.firstTestName = firstTestName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirstTestResult() {
		return firstTestResult;
	}
	public void setFirstTestResult(String firstTestResult) {
		this.firstTestResult = firstTestResult;
	}
	public String getFirstTestEX() {
		return firstTestEX;
	}
	public void setFirstTestEX(String firstTestEX) {
		this.firstTestEX = firstTestEX;
	}
	public String getFirstTestTime() {
		return firstTestTime;
	}
	public void setFirstTestTime(String firstTestTime) {
		this.firstTestTime = firstTestTime;
	}
	public String getLastTestTime() {
		return lastTestTime;
	}
	public void setLastTestTime(String lastTestTime) {
		this.lastTestTime = lastTestTime;
	}
	public String getLastTestName() {
		return lastTestName;
	}
	public void setLastTestName(String lastTestName) {
		this.lastTestName = lastTestName;
	}
	public String getLastTestEX() {
		return lastTestEX;
	}
	public void setLastTestEX(String lastTestEX) {
		this.lastTestEX = lastTestEX;
	}
	public String getLastTestResult() {
		return lastTestResult;
	}
	public void setLastTestResult(String lastTestResult) {
		this.lastTestResult = lastTestResult;
	}
	public TestOverview() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestOverview [firstTestName=" + firstTestName + ", code="
				+ code + ", firstTestResult=" + firstTestResult
				+ ", firstTestEX=" + firstTestEX + ", firstTestTime="
				+ firstTestTime + ", lastTestTime=" + lastTestTime
				+ ", lastTestName=" + lastTestName + ", lastTestEX="
				+ lastTestEX + ", lastTestResult=" + lastTestResult + "]";
	}
	public TestOverview(String firstTestName, String code,
			String firstTestResult, String firstTestEX, String firstTestTime,
			String lastTestTime, String lastTestName, String lastTestEX,
			String lastTestResult) {
		super();
		this.firstTestName = firstTestName;
		this.code = code;
		this.firstTestResult = firstTestResult;
		this.firstTestEX = firstTestEX;
		this.firstTestTime = firstTestTime;
		this.lastTestTime = lastTestTime;
		this.lastTestName = lastTestName;
		this.lastTestEX = lastTestEX;
		this.lastTestResult = lastTestResult;
	}
	
	
	
}
