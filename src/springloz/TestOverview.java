package springloz;

import java.io.Serializable;


/**         @�������Լ�¼��־
 * 
@�״β�����Ա 	firstTestName	String
@���Ա��� 	    code			String
@�״β��Խ��   firstTestResult	String
@�״β�������	firstTestEX		String
@�״β���ʱ��   firstTestTime	String

@������ʱ��   lastTestTime	String
@��������Ա 	lastTestName	String
@���������� 	lastTestEX		String
@�����Խ��  	lastTestResult	String


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
