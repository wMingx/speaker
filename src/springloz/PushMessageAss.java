package springloz;

import java.io.Serializable;

public class PushMessageAss implements Serializable {

	private String pushmessagere;

	public String getPushmessagere() {
		return pushmessagere;
	}

	public void setPushmessagere(String pushmessagere) {
		this.pushmessagere = pushmessagere;
	}

	public PushMessageAss() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PushMessageAss(String pushmessagere) {
		super();
		this.pushmessagere = pushmessagere;
	}

	@Override
	public String toString() {
		return "PushMessageRe [pushmessagere=" + pushmessagere + "]";
	}
	
	
	
}
