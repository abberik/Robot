package client;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Konsol extends JFrame {

	private JTextArea area;
	private JTextField falt;
	
	private JScrollPane scrollPane;
	
	public Konsol() {
		
		this.setSize(640,480);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		area = new JTextArea();
		area.setEditable(false);
		falt = new JTextField();
		
		scrollPane = new JScrollPane(area);
		this.setLayout(new BorderLayout());
		
		this.add(area,BorderLayout.CENTER);
		this.add(falt, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void setSubmit(Action action){
		falt.setAction(action);
	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	public JTextField getFalt() {
		return falt;
	}

	public void setFalt(JTextField falt) {
		this.falt = falt;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	
}
