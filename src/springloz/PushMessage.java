package springloz;

import java.io.Serializable;
/*
 * ÍÆËÍ²âÊÔ
 * @	pushmessage 	String
 */
public class PushMessage implements Serializable {

	
	private String pushmessage;
	
	private String pushmessageass;

	public String getPushmessageass() {
		return pushmessageass;
	}

	public void setPushmessageass(String pushmessageass) {
		this.pushmessageass = pushmessageass;
	}

	public String getPushmessage() {
		return pushmessage;
	}

	public void setPushmessage(String pushmessage) {
		this.pushmessage = pushmessage;
	}

	public PushMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PushMessage [pushmessage=" + pushmessage + ", pushmessageass="
				+ pushmessageass + "]";
	}

	public PushMessage(String pushmessage, String pushmessageass) {
		super();
		this.pushmessage = pushmessage;
		this.pushmessageass = pushmessageass;
	}


	
	
	
	
}
