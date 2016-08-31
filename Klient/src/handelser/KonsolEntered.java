package handelser;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import client.Klient;
import client.Konsol;
import natverkssaker.Anslutning;
import natverkssaker.Message;

public class KonsolEntered implements Action{
	
	private Anslutning anslutning;
	private Klient klient;
	
	public KonsolEntered(Klient klient) {
	
		this.klient = klient;
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//hamta texten fran konsollen
		String raw = 		getConsole().getFalt().getText();
		String[] inData = raw.split(" ");
		getConsole().getFalt().setText("");
		
		//analysera
		if(inData[0].equals("drive"))	drive(raw);
		if(inData[0].equals("rotate")) rotate(raw);
		if(inData[0].equals("connect")) connect(raw);
		if(inData[0].equals("exit")) System.exit(0);
	}
	

	private void connect(String raw) {
		
		String ip = raw.split(" ")[1];
		String adress = ip.split(":")[0];
		int port = Integer.parseInt(ip.split(":")[1].trim());
		
		anslutning = new Anslutning(adress, port);
		
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
		this.setEnabled(arg0);
	}
	
	
	
	public Anslutning getAnslutning() {
		return anslutning;
	}

	public void setAnslutning(Anslutning anslutning) {
		this.anslutning = anslutning;
	}

	
	public Konsol getConsole(){
		OppnaKonsol k = klient.getOppna_konsol();
		Konsol ko = k.getKonsol();
		return ko;
	}

	public void drive(String raw){
		
		/*
		 * 
		 * Temporarily this method will be used to blink the LED for time just to check everything concerning the network.
		 * 
		 */
		System.out.println("Method called");
		if(raw.split(" ").length != 1){ //regex var satt till ett kommatecken innan, D: varför det???!?!
			//om ytterligare parametrar gavs
			System.out.println("Passed test");
			
			boolean timed = false;
			int time = -1;
			
			char[] chars = raw.toCharArray();
			
			boolean in_arg = false;
			char arg_char = '0';
			boolean arg_char_taken = false;
			String arg_args = "";
			
			for(int b = 0; b < chars.length; b++){
				System.out.println("processing \"" + chars[b]+ "\"" );

				
				if(in_arg && arg_char_taken){
					
					arg_args += chars[b];
					
				}
				
				if(in_arg && !arg_char_taken){
					arg_char = chars[b];
					arg_char_taken = true;
				}
				
				if(chars[b] == '-'){
					System.out.println("argumetn");
					in_arg = true;
				}
				
				if(chars[b] == ' ' && in_arg){
					//parse this statement
					System.out.println("arg-char==\'"+arg_char+"\'");
					if(arg_char == 't'){
						//timad f�rd
						timed = true;
						arg_args.replace('t', ' ');
						time = Integer.parseInt(arg_args.trim());
						System.out.println(time);
					}
				}
				
			}
			
			//Här är alla parametrar klara
			
			anslutning.send(new Message(anslutning.getProtokol().getForward(),time));
		}else{
			anslutning.send(new Message(anslutning.getProtokol().getForward(),-1));
		}
		
	}
	
	public void rotate(String raw){
		if(raw.split(" ").length != 1){
			//om ytterligare parametrar gavs
			
			
			boolean timed = false;
			int time = -1;
			
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
						//timad f�rd
						timed = true;
						time = Integer.parseInt(arg_args);
					System.out.println("1");
					}else if(arg_char == 'r'){
						
						right = true; left = false;
						
					}else if(arg_char == 'l'){
						
						left = true; right = false;
						
					}
				}
				
			}
			
			
			if(right){				anslutning.send(new Message(anslutning.getProtokol().getRight(),time));			}
			if(left){				anslutning.send(new Message(anslutning.getProtokol().getLeft(),time));			}
			
		}else{
			System.out.println("ERROR: more parameters needed");
		}

		
	}

}
