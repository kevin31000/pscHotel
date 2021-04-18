package es.deusto.spq.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;

public class VentanaAdmin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	
	public VentanaAdmin(final Controller controller){
		contentpane = new JPanel();
		
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Administración");
	}

}
