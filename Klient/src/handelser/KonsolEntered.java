package handelser;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import client.Konsol;

public class KonsolEntered implements Action{

	private Konsol konsol;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//hamta texten fran konsollen
		String raw = konsol.getFalt().getText();
		String[] inData = raw.split(" ");
		konsol.getFalt().setText("");
		
		//analysera
		if(inData[0].equals("drive"))	drive(raw);
		if(inData[0].equals("rotate")) rotate(raw);
		
	}
	

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void drive(String raw){
		
		if(raw.split(",").length != 1){
			//om ytterligare parametrar gavs
			
			
			boolean timed = false;
			int time = 0;
			
			char[] chars = raw.toCharArray();
			
			boolean in_arg = false;
			char arg_char = '0';
			boolean arg_char_taken = false;
			String arg_args = "";
			
			for(int b = 0; b < chars.length; b++){
				
				if(in_arg && !arg_char_taken){
					arg_char = chars[b];
					arg_char_taken = true;
				}
				
				if(in_arg && arg_char_taken){
					
					arg_args += chars[b];
					
				}
				
				if(chars[b] == '-') in_arg = true;
				
				if(chars[b] == ' ' && in_arg){
					//parse this statement
					if(arg_char != 't'){
						//timad färd
						timed = true;
						time = Integer.parseInt(arg_args);
						
					}
				}
				
			}
			
			
			
		}
		
	}
	
	public void rotate(String raw){
		if(raw.split(",").length != 1){
			//om ytterligare parametrar gavs
			
			
			boolean timed = false;
			int time = 0;
			
			boolean right = false;
			boolean left = false;
			
			char[] chars = raw.toCharArray();
			
			boolean in_arg = false;
			char arg_char = '0';
			boolean arg_char_taken = false;
			String arg_args = "";
			
			for(int b = 0; b < chars.length; b++){
				
				if(in_arg && !arg_char_taken){
					arg_char = chars[b];
					arg_char_taken = true;
				}
				
				if(in_arg && arg_char_taken){
					
					arg_args += chars[b];
					
				}
				
				if(chars[b] == '-') in_arg = true;
				
				if(chars[b] == ' ' && in_arg){
					//parse this statement
					if(arg_char == 't'){
						//timad färd
						timed = true;
						time = Integer.parseInt(arg_args);
						
					}else if(arg_char == 'r'){
						
						right = true; left = false;
						
					}else if(arg_char == 'l'){
						
						left = true; right = false;
						
					}
				}
				
			}
			
			
			
		}
		
	}

}
