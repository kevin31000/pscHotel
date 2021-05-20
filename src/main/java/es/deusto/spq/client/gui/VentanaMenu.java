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

public class VentanaMenu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton buttonCliente = new JButton();
	private JButton buttonReserva = new JButton();
	private JButton buttonEventos = new JButton();
	private JButton buttonValorar = new JButton();
	private JButton buttonSalir = new JButton();
	
	public VentanaMenu(final Controller controller){
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lTitulo = new JLabel("Menu");
		lTitulo.setFont(new Font("Arial", Font.PLAIN, 54));
		lTitulo.setBounds(430, 50, 309, 42);
		contentpane.add(lTitulo);
	
		buttonCliente.setForeground(SystemColor.text);
		buttonCliente.setBackground(new Color(0, 102, 204));
		buttonCliente.setBounds(400, 166, 200, 42);
		buttonCliente.setText("Mis datos");
		contentpane.add(buttonCliente);

		buttonReserva.setForeground(SystemColor.text);
		buttonReserva.setBackground(new Color(0, 102, 204));
		buttonReserva.setBounds(400, 240, 200, 42);
		buttonReserva.setText("Reservar");
		contentpane.add(buttonReserva);
		
		buttonEventos.setForeground(SystemColor.text);
		buttonEventos.setBackground(new Color(0, 102, 204));
		buttonEventos.setBounds(400, 318, 200, 42);
		buttonEventos.setText("Reservar eventos");
		contentpane.add(buttonEventos);

		buttonValorar.setText("Valorar App");
		buttonValorar.setForeground(Color.WHITE);
		buttonValorar.setBackground(new Color(0, 102, 204));
		buttonValorar.setBounds(400, 393, 200, 42);
		contentpane.add(buttonValorar);

		buttonSalir.setForeground(SystemColor.text);
		buttonSalir.setBackground(new Color(0, 102, 204));
		buttonSalir.setBounds(10, 500, 200, 42);
		buttonSalir.setText("Salir");
		contentpane.add(buttonSalir);

		buttonReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaReservas reserva;
				try {
					reserva = new VentanaReservas(controller);
					reserva.setVisible(true);
					VentanaMenu.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		
		buttonCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaDatosCliente datosCliente;
				try {
					datosCliente = new VentanaDatosCliente(controller, controller.getUsuario(VentanaInicioSesion.cargarEmailUsuario()));
					datosCliente.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});

		buttonEventos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaReservarEventos evento;
				try {
					evento = new VentanaReservarEventos(controller);
					evento.setVisible(true);
					VentanaMenu.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
			
		buttonValorar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					VentanaFeedback feedback;
					try {
						feedback = new VentanaFeedback(controller);
						feedback.setVisible(true);
						VentanaMenu.this.dispose();
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
				VentanaMenu.this.dispose();
				
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Menu");

	}
}
