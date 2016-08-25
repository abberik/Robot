package handelser;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import client.Konsol;

public class OppnaKonsol implements Action{
	
	private Konsol konsol;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Runnable runnable = new Runnable(){

			@Override
			public void run() {
				if(konsol == null) konsol = new Konsol();
				else{
					konsol.toFront();
					JOptionPane.showMessageDialog(konsol, "You already have a console open!");
				}
			}
			
			
		
		};
		
		Thread console_thread = new Thread(runnable);
		console_thread.run();
		
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
	
}
