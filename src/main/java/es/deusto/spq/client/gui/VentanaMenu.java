package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VentanaMenu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton buttonCliente = new JButton();
	private JButton buttonReserva = new JButton();
	private JButton buttonSalir = new JButton();
	
	public VentanaMenu() {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lTitulo = new JLabel("Menu");
		lTitulo.setFont(new Font("Arial", Font.PLAIN, 54));
		lTitulo.setBounds(430, 32, 309, 42);
		contentpane.add(lTitulo);

		buttonReserva.setForeground(SystemColor.text);
		buttonReserva.setBackground(new Color(0, 102, 204));
		buttonReserva.setBounds(400, 400, 200, 42);
		buttonReserva.setText("Reservar");
		contentpane.add(buttonReserva);
		
		buttonCliente.setForeground(SystemColor.text);
		buttonCliente.setBackground(new Color(0, 102, 204));
		buttonCliente.setBounds(400, 300, 200, 42);
		buttonCliente.setText("Mis datos");
		contentpane.add(buttonCliente);
		
		buttonSalir.setForeground(SystemColor.text);
		buttonSalir.setBackground(new Color(0, 102, 204));
		buttonSalir.setBounds(10, 500, 200, 42);
		buttonSalir.setText("Salir");
		contentpane.add(buttonSalir);

		buttonReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaReservas reserva = new VentanaReservas();
				reserva.setVisible(true);
				VentanaMenu.this.dispose();
				
			}
		});
		
		buttonCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		buttonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaInicioSesion inicio = new VentanaInicioSesion();
				inicio.setVisible(true);
				VentanaMenu.this.dispose();
				
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Menu");

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new VentanaMenu();
			}
		});
	}

}