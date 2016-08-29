package natverkssaker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Protokol {

	private int forward;
	private int backward;
	private int left;
	private int right;
	private int disconnect;
	
	private String protocol_location;
	
	public Protokol(String protocol_location) {
	
		//las protokol
		parse_protocol();
		this.protocol_location = protocol_location;
		
	}

	private void parse_protocol() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(protocol_location));
			
			while(true){
				
				char[] chars = br.readLine().toCharArray();
				
				String from_brackets = "";
				short value = -1;
				
				boolean in_content = false;
		
				
				for(int i = 0; i < chars.length; i++){	//cut out the content
					
					//add the content to the string
					if(in_content) from_brackets+=chars[i];					
					
					//Keep track of the content
					if(chars[i] == '{') in_content = true;				
					if(chars[i] == '}') in_content = false;
					
				}
				
				String[] inData = from_brackets.split(",");
				String name = "";
				
				in_content = false;
				
				chars = inData[0].toCharArray();
				
				for(int i = 0; i < chars.length; i++){	//cut out the content
					
					//add the content to the string
					if(in_content) name+=chars[i];					
					
					//Keep track of the content
					if(chars[i] == '"') in_content = true;				
					if(chars[i] == '"' && in_content) in_content = false;
					
				}
				
				value = Short.parseShort(inData[1]);
				
				if(name.equals("TOGGLE_FORWARD")) forward = value;
				if(name.equals("TOGGLE_BACKWARD")) backward = value;
				if(name.equals("TOGGLE_LEFT")) left = value;
				if(name.equals("TOGGLE_RIGHT")) right = value;
				if(name.equals("GOODBYE")) disconnect = value;
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	public int getForward() {
		return forward;
	}

	public void setForward(short forward) {
		this.forward = forward;
	}

	public int getBackward() {
		return backward;
	}

	public void setBackward(short backward) {
		this.backward = backward;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(short left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(short right) {
		this.right = right;
	}

	public String getProtocol_location() {
		return protocol_location;
	}

	public void setProtocol_location(String protocol_location) {
		this.protocol_location = protocol_location;
	}
	
	
}
