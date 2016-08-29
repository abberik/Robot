package client;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pilar extends JFrame{

	/*
	 *	Skiss over utseende: L betyder 'label' och representerar en JLabel som enbart inneholler ett mellanslag
	 *	'V','H','U','N' motsvarar en knapp i en riktning som man forhoppningsvis kan lista ut.
	 * 
	 * 	LUL
	 * 	VLH
	 * 	 
	 */
	
	private JButton framKnapp;
	private JButton hogerKnapp;
	private JButton vansterKnapp;
	
	private KeyListener keyListener = new KeyListener(){

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			int kc = arg0.getKeyCode();
			if(kc == KeyEvent.VK_ESCAPE){
				dispose(); //close the controls dialog
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public Pilar() {
		
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(320,320);
		
		framKnapp = new JButton("^");
		hogerKnapp = new JButton(">");
		vansterKnapp = new JButton("<");
		
		this.setLayout(new GridLayout(2,3));
		
		this.add(new JLabel(" ")); //ovre vanstra hornet
		this.add(framKnapp);
		this.add(new JLabel(" ")); //ovre hogra hornet
		this.add(vansterKnapp);
		this.add(new JLabel(" ")); //mitten
		this.add(hogerKnapp);
		
		this.setVisible(true);
	}

	public JButton getFramKnapp() {
		return framKnapp;
	}

	public void setFramKnapp(JButton framKnapp) {
		this.framKnapp = framKnapp;
	}

	public JButton getHogerKnapp() {
		return hogerKnapp;
	}

	public void setHogerKnapp(JButton hogerKnapp) {
		this.hogerKnapp = hogerKnapp;
	}

	public JButton getVansterKnapp() {
		return vansterKnapp;
	}

	public void setVansterKnapp(JButton vansterKnapp) {
		this.vansterKnapp = vansterKnapp;
	}
	
	
	
}
