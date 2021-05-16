package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;

public class VentanaAdmin extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton buttonCliente = new JButton();
	private JButton buttonReserva = new JButton();
	private JButton buttonEventos = new JButton();
	private JButton buttonSalir = new JButton();
	
	public VentanaAdmin(final Controller controller){
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lTitulo = new JLabel("Menu Administrador");
		lTitulo.setFont(new Font("Arial", Font.PLAIN, 54));
		lTitulo.setBounds(250, 50, 489, 42);
		contentpane.add(lTitulo);
		        
		buttonReserva.setForeground(SystemColor.text);
		buttonReserva.setBackground(new Color(0, 102, 204));
		buttonReserva.setBounds(400, 280, 200, 42);
		buttonReserva.setText("Reservas");
		contentpane.add(buttonReserva);
		
		buttonCliente.setForeground(SystemColor.text);
		buttonCliente.setBackground(new Color(0, 102, 204));
		buttonCliente.setBounds(400, 200, 200, 42);
		buttonCliente.setText("Clientes");
		contentpane.add(buttonCliente);
		
		buttonEventos.setForeground(SystemColor.text);
		buttonEventos.setBackground(new Color(0, 102, 204));
		buttonEventos.setBounds(400, 360, 200, 42);
		buttonEventos.setText("Eventos");
		contentpane.add(buttonEventos);
		
		buttonSalir.setForeground(SystemColor.text);
		buttonSalir.setBackground(new Color(0, 102, 204));
		buttonSalir.setBounds(10, 500, 200, 42);
		buttonSalir.setText("Salir");
		contentpane.add(buttonSalir);

		buttonReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaReservasAdmin reservas;
				try {		
					reservas = new VentanaReservasAdmin(controller);
					reservas.setVisible(true);
					VentanaAdmin.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		
		buttonCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaUsuariosAdmin usuarios;
				try {		
					usuarios = new VentanaUsuariosAdmin(controller);
					usuarios.setVisible(true);
					VentanaAdmin.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		buttonEventos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEventos usuarios;
				try {		
					usuarios = new VentanaEventos(controller);
					usuarios.setVisible(true);
					VentanaAdmin.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
				
		buttonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaInicioSesion inicio = new VentanaInicioSesion(controller);
				inicio.setVisible(true);
				VentanaAdmin.this.dispose();
				
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Menu Administrador");

	}

}

