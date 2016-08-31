package natverkssaker;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8919317408313763692L;
	private int[] content;
	
	public Message(int... args) { //sometimes the msg will contain several instructions, sometimes not. 
	
			content = args;	//potential error if the varargs would result in a int instead of a int[]
	}

	public int[] getContent() {
		return content;
	}

	public void setContent(int[] content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
