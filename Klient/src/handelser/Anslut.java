package handelser;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import client.Klient;
import natverkssaker.Anslutning;

public class Anslut implements  Action{

	private Klient klient;
	
	public Anslut(Klient klient) {
		
		this.klient = klient;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Las in adressen
		String inData = JOptionPane.showInputDialog("Ange adress:port.");
		String[] data = inData.split(":");
		int port = Integer.parseInt(data[1].trim());
		String adr = data[0];
		Anslutning ans = new Anslutning(adr, port);
		
		
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}
 
	
	
	
}
