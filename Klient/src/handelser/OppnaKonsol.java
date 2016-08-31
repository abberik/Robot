package handelser;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import client.Klient;
import client.Konsol;

public class OppnaKonsol implements Action{
	
	private Konsol konsol;
	
	public OppnaKonsol(Klient klient) {
		Runnable runnable = new Runnable(){

			@Override
			public void run() {
				
				
					konsol = new Konsol();
					konsol.getFalt().setEditable(true);
					
				
			}
			
			
		
		};
		
		Thread console_thread = new Thread(runnable);
		console_thread.run();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		konsol.toFront();
		konsol.setVisible(true);	
		konsol.getFalt().setEditable(true);
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

	public Konsol getKonsol() {
		return konsol;
	}

	public void setKonsol(Konsol konsol) {
		this.konsol = konsol;
	}
	
	
	
}
