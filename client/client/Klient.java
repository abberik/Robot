package client;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import handelser.OppnaKonsol;
import handelser.OppnaKontroller;

public class Klient extends JFrame{

	public static void main(String[] args) {
		new Klient();
	}
	
	private JToolBar toolbar;
	private JMenu open_menu;
	private JMenuBar menu_bar;
	private JMenu client_menu;
	
	OppnaKonsol oppna_konsol;
	OppnaKontroller oppna_kontroller;
	
	private JMenuItem open_console_menu_item; 
	private JMenuItem open_controls_menu_item;

	public Klient() {
		
		oppna_konsol = new OppnaKonsol();
		oppna_kontroller = new OppnaKontroller();
		
		this.setSize(640,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		this.toolbar = new JToolBar();
		this.open_menu = new JMenu("Open");
		this.client_menu = new JMenu("Client");
		this.open_menu.setEnabled(true);
		this.open_menu.setVisible(true);
		this.menu_bar = new JMenuBar();
		

		open_console_menu_item = new JMenuItem("Open developer console.");
		open_console_menu_item.addActionListener(oppna_konsol);
		open_console_menu_item.setMnemonic('s');
		open_controls_menu_item = new JMenuItem("Open controls");
		open_controls_menu_item.addActionListener(oppna_kontroller);
		open_controls_menu_item.setMnemonic('t');
		
		open_menu.add(open_console_menu_item);
		open_menu.add(open_controls_menu_item);
		open_menu.setMnemonic('o');
		
		menu_bar.add(open_menu);
		menu_bar.add(client_menu);
		this.add(menu_bar,BorderLayout.NORTH);

		
		this.setVisible(true);
		
	}
	
}
