package handelser;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import client.Konsol;
import client.Pilar;

public class OppnaKontroller implements Action{
	
	private Pilar pilar;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Runnable runnable = new Runnable(){

			@Override
			public void run() {
				if(pilar == null) pilar = new Pilar();
				else{
					pilar.toFront();
					JOptionPane.showMessageDialog(pilar, "You already have a controller open!");
				}
			}
			
			
		
		};
		
		Thread console_thread = new Thread(runnable);
		console_thread.run();
		
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
