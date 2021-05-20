package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelDNI = new JLabel();
	private JLabel labelNombre = new JLabel();
	private JLabel labelApellido = new JLabel();
	private JLabel labelEmail = new JLabel();
	private JLabel labelContrasenya = new JLabel();
	private JLabel labelConfirmar = new JLabel();
	private JTextField textDNI = new JTextField();
	private JTextField textNombre = new JTextField();
	private JTextField textApellido = new JTextField();
	private JTextField textEmail = new JTextField();
	private JPasswordField textContrasenya = new JPasswordField();
	private JPasswordField textConfirmar = new JPasswordField();
	private JButton buttonAceptar = new JButton();
	private JButton buttonLogin = new JButton();

	public class JNumberTextField extends JTextField {
		private static final long serialVersionUID = 1L;
	}

	public VentanaRegistro(final Controller controller) {

		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		labelDNI.setFont(new Font("Arial", Font.BOLD, 11));

		JLabel labelTitle = new JLabel("PSC Hotel");
		labelTitle.setFont(new Font("Arial", Font.PLAIN, 54));
		labelTitle.setBounds(92, 32, 309, 50);
		contentpane.add(labelTitle);

		labelDNI.setText(" DNI:");
		// labelUser.setBackground(Color.white);
		labelDNI.setOpaque(true);
		labelDNI.setBounds(70, 134, 120, 20);
		contentpane.add(labelDNI, BorderLayout.SOUTH);
		labelNombre.setFont(new Font("Arial", Font.BOLD, 11));

		labelNombre.setText(" Nombre:");
		labelNombre.setBounds(70, 188, 120, 20);
		// loselabelPass.setBackground(Color.white);
		labelNombre.setOpaque(true);
		contentpane.add(labelNombre);
		labelApellido.setFont(new Font("Arial", Font.BOLD, 11));

		labelApellido.setText(" Apellido:");
		labelApellido.setBounds(70, 242, 120, 20);
		// loselabelPass.setBackground(Color.white);
		labelApellido.setOpaque(true);
		contentpane.add(labelApellido);
		labelEmail.setFont(new Font("Arial", Font.BOLD, 11));

		labelEmail.setText(" Email:");
		labelEmail.setBounds(70, 296, 120, 20);
		// loselabelPass.setBackground(Color.white);
		labelEmail.setOpaque(true);
		contentpane.add(labelEmail);
		labelContrasenya.setFont(new Font("Arial", Font.BOLD, 11));

		labelContrasenya.setText(" Contraseña:");
		labelContrasenya.setBounds(70, 350, 120, 20);
		// loselabelPass.setBackground(Color.white);
		labelContrasenya.setOpaque(true);
		contentpane.add(labelContrasenya);
		labelConfirmar.setFont(new Font("Arial", Font.BOLD, 11));

		labelConfirmar.setText(" Confirmar contraseña:");
		labelConfirmar.setBounds(70, 404, 130, 20);
		// loselabelPass.setBackground(Color.white);
		labelConfirmar.setOpaque(true);
		contentpane.add(labelConfirmar);

		buttonAceptar.setForeground(SystemColor.text);
		buttonAceptar.setBackground(new Color(0, 102, 204));
		buttonAceptar.setBounds(214, 500, 143, 32);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);

		buttonLogin.setBackground(SystemColor.inactiveCaptionBorder);
		buttonLogin.setBounds(69, 500, 130, 32);
		buttonLogin.setText("Ya tengo cuenta");
		contentpane.add(buttonLogin);

		textDNI.setBounds(214, 134, 143, 20);
		contentpane.add(textDNI);

		textNombre.setBounds(214, 188, 143, 20);
		contentpane.add(textNombre);

		textApellido.setBounds(214, 242, 143, 20);
		contentpane.add(textApellido);

		textEmail.setBounds(214, 296, 143, 20);
		contentpane.add(textEmail);

		textContrasenya.setBounds(214, 350, 143, 20);
		contentpane.add(textContrasenya);

		textConfirmar.setBounds(214, 404, 143, 20);
		contentpane.add(textConfirmar);

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean correcto = false;
				boolean error = false;
				boolean admin;
				String dni = textDNI.getText().toString();
				String nombre = textNombre.getText().toString();
				String apellido = textApellido.getText().toString();

				if (textDNI.getText().equals("") || textNombre.getText().equals("") || textApellido.getText().equals("")
						|| textEmail.getText().equals("") || textContrasenya.toString().equals("")
						|| textConfirmar.toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error",JOptionPane.INFORMATION_MESSAGE);
					VentanaRegistro.this.repaint();
					error = true;

				} else if (dni.matches("^[a-zA-Z]+$")) {

					JOptionPane.showMessageDialog(null, "DNI no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
					error = true;
					VentanaRegistro.this.repaint();

				} else if (nombre.matches("^[0-9]+$")) {

					JOptionPane.showMessageDialog(null, "Nombre no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
					error = true;
					VentanaRegistro.this.repaint();

				} else if (apellido.matches("^[0-9]+$")) {

					JOptionPane.showMessageDialog(null, "Apellido no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
					error = true;
					VentanaRegistro.this.repaint();

				} else if (!textEmail.getText().contains("@") || !(textEmail.getText().contains(".es")
						|| textEmail.getText().contains(".com") || textEmail.getText().contains(".eus"))) {

					JOptionPane.showMessageDialog(null, "Email no válido.", "Error",JOptionPane.INFORMATION_MESSAGE);
					error = true;
					VentanaRegistro.this.repaint();

				} else if (!String.valueOf(textContrasenya.getPassword())
						.equals(String.valueOf(textConfirmar.getPassword()))) {

					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error",JOptionPane.INFORMATION_MESSAGE);
					VentanaRegistro.this.repaint();
					error = true;

				} else if (!error) {

					controller.anadirCliente(textDNI.getText(), textNombre.getText(), textApellido.getText(),
							textEmail.getText(), String.valueOf(textContrasenya.getPassword()), false);
					correcto = true;
				}

				if (correcto) {
					JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.", "Nuevo cliente",JOptionPane.INFORMATION_MESSAGE);
					VentanaInicioSesion inicio = new VentanaInicioSesion(controller);
					inicio.setVisible(true);
					VentanaRegistro.this.dispose();

				} else if (!error) {
					JOptionPane.showMessageDialog(null,
							"El email introducido ya ha sido registrado, pruebe a iniciar sesión.", "Error",JOptionPane.INFORMATION_MESSAGE);
					VentanaRegistro.this.repaint();
				}
			}
		});

		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaInicioSesion(controller);
				dispose();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 600);
		setVisible(true);
		setTitle("Nuevo cliente");
	}
}
