package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Controller;
import es.deusto.spq.client.GetProperties;
import es.deusto.spq.client.ServiceLocator;

public class VentanaInicioSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelUser = new JLabel();
	private JLabel labelPass = new JLabel();
	private JTextField textUser = new JTextField();
	private JTextField textPass = new JTextField();
	private JButton buttonAceptar = new JButton();
	private JButton buttonRegistrar = new JButton();
	private Client client;

	public VentanaInicioSesion(final Controller controller){
		client = ClientBuilder.newClient();
		GetProperties properties = new GetProperties();
		String url = "";
		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		labelUser.setFont(new Font("Arial", Font.BOLD, 11));

		JLabel labelTitle = new JLabel("PSC Hotel");
		labelTitle.setFont(new Font("Arial", Font.PLAIN, 54));
		labelTitle.setBounds(92, 32, 309, 42);
		contentpane.add(labelTitle);

		labelUser.setText(" Email:");
		// labelUser.setBackground(Color.white);
		labelUser.setOpaque(true);
		labelUser.setBounds(70, 134, 120, 20);
		contentpane.add(labelUser, BorderLayout.SOUTH);
		labelPass.setFont(new Font("Arial", Font.BOLD, 11));

		labelPass.setText(" Contraseña:");
		labelPass.setBounds(70, 188, 120, 20);
		// loselabelPass.setBackground(Color.white);
		labelPass.setOpaque(true);
		contentpane.add(labelPass);

		buttonAceptar.setForeground(SystemColor.text);
		buttonAceptar.setBackground(new Color(0, 102, 204));
		buttonAceptar.setBounds(214, 243, 143, 32);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);

		buttonRegistrar.setBackground(SystemColor.inactiveCaptionBorder);
		buttonRegistrar.setBounds(69, 243, 121, 32);
		buttonRegistrar.setText("Registro");
		contentpane.add(buttonRegistrar);

		textUser.setBounds(214, 134, 143, 20);
		contentpane.add(textUser);

		textPass.setBounds(214, 188, 143, 20);
		contentpane.add(textPass);

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int correcto = controller.iniciarSesion(textUser.getText(), textPass.getText());
				if(correcto == 1) {
					VentanaMenu menu;
					try {
						menu = new VentanaMenu(controller);
						menu.setVisible(true);
						VentanaInicioSesion.this.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}




				}else if(correcto == 2) {
					//Aqui redireccionar a la vemtana Admin
				}else if(correcto == 0) {
					JOptionPane.showMessageDialog(null, "Usuario incorrecto");
				}
			}
		});

		buttonRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaRegistro(controller);
				dispose();

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 355);
		setVisible(true);
		setTitle("PSC Hotel");
	}
	
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						VentanaInicioSesion window = new VentanaInicioSesion(null);
//						window.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

	

}
