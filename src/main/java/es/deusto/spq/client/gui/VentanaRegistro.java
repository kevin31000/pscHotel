package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Controller;

public class VentanaRegistro extends JFrame{

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
	private JLabel labelAdmin = new JLabel();
	private JTextField textDNI = new JTextField();
	private JTextField textNombre = new JTextField();
	private JTextField textApellido = new JTextField();
	private JTextField textEmail = new JTextField();
	private JPasswordField textContrasenya = new JPasswordField();
	private JPasswordField textConfirmar = new JPasswordField();
	private JRadioButton adminSi = new JRadioButton("Si", false);
	private JRadioButton adminNo = new JRadioButton("No",true);
	private ButtonGroup grupo = new ButtonGroup();
	private JButton buttonAceptar = new JButton();
	private JButton buttonLogin = new JButton();

	public VentanaRegistro(final Controller controller) {

		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		labelDNI.setFont(new Font("Arial", Font.BOLD, 11));

		JLabel labelTitle = new JLabel("PSC Hotel");
		labelTitle.setFont(new Font("Arial", Font.PLAIN, 54));
		labelTitle.setBounds(92, 32, 309, 42);
		contentpane.add(labelTitle);

		labelDNI.setText(" DNI:");
		//labelUser.setBackground(Color.white);
		labelDNI.setOpaque(true);
		labelDNI.setBounds(70, 134, 120, 20);
		contentpane.add(labelDNI, BorderLayout.SOUTH);
		labelNombre.setFont(new Font("Arial", Font.BOLD, 11));

		labelNombre.setText(" Nombre:");
		labelNombre.setBounds(70, 188, 120, 20);
		//loselabelPass.setBackground(Color.white);
		labelNombre.setOpaque(true);
		contentpane.add(labelNombre);
		labelApellido.setFont(new Font("Arial", Font.BOLD, 11));

		labelApellido.setText(" Apellido:");
		labelApellido.setBounds(70, 242, 120, 20);
		//loselabelPass.setBackground(Color.white);
		labelApellido.setOpaque(true);
		contentpane.add(labelApellido);
		labelEmail.setFont(new Font("Arial", Font.BOLD, 11));

		labelEmail.setText(" Email:");
		labelEmail.setBounds(70, 296, 120, 20);
		//loselabelPass.setBackground(Color.white);
		labelEmail.setOpaque(true);
		contentpane.add(labelEmail);
		labelContrasenya.setFont(new Font("Arial", Font.BOLD, 11));

		labelContrasenya.setText(" Contrasenya:");
		labelContrasenya.setBounds(70, 350, 120, 20);
		//loselabelPass.setBackground(Color.white);
		labelContrasenya.setOpaque(true);
		contentpane.add(labelContrasenya);
		labelConfirmar.setFont(new Font("Arial", Font.BOLD, 11));
		
		labelConfirmar.setText(" Confirmar contrasenya:");
		labelConfirmar.setBounds(70, 404, 120, 20);
		//loselabelPass.setBackground(Color.white);
		labelConfirmar.setOpaque(true);
		contentpane.add(labelConfirmar);
		labelAdmin.setFont(new Font("Arial", Font.BOLD, 11));

		labelAdmin.setText(" ¿Es admin?");
		labelAdmin.setBounds(70, 454, 120, 20);
		//loselabelPass.setBackground(Color.white);
		labelAdmin.setOpaque(true);
		contentpane.add(labelAdmin);
		

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
		
		grupo = new ButtonGroup();
		
		adminSi.setBounds(214, 454, 143, 20);
		contentpane.add(adminSi);
		
		adminNo.setBounds(214, 480, 143, 20);
		contentpane.add(adminNo);
		
		grupo.add(adminSi);
		grupo.add(adminNo);
		

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaInicioSesion(controller);
				dispose();
			}
		});
		buttonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean correcto = false;
				boolean error = false;
				boolean admin;
				
				if (adminSi.isSelected()) {
					admin = true;	
				} else {
					admin = false;
				}
				if (textDNI.getText().equals("") || textNombre.getText().equals("") ||textApellido.getText().equals("") ||textEmail.getText().equals("") 
						||textContrasenya.toString().equals("") ||textConfirmar.toString().equals("") ) {
					JOptionPane.showMessageDialog(null, "Error. Rellena todos los campos");
					VentanaRegistro.this.repaint();
					error = true;
				}else if(!textEmail.getText().contains("@") && !(textEmail.getText().contains(".es") || textEmail.getText().contains(".com"))){
					JOptionPane.showMessageDialog(null, "Email no válido");
					error = true;
					VentanaRegistro.this.repaint();
				}else if (!String.valueOf(textContrasenya.getPassword()).equals(String.valueOf(textConfirmar.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Error. Las contraseñas no coinciden");
					VentanaRegistro.this.repaint();
					error = true;
				}else if (!error){
					controller.anadirCliente(textDNI.getText(), textNombre.getText(), textApellido.getText(), textEmail.getText(), String.valueOf(textContrasenya.getPassword()), admin);
					
					correcto = true;
				}
				
				
				if ( correcto) {
					
					JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
					
					
					VentanaInicioSesion inicio = new VentanaInicioSesion(controller); 

					inicio.setVisible(true);
					
					VentanaRegistro.this.dispose();
					
				}else if (!error){
						JOptionPane.showMessageDialog(null, "Ese email ya ha sido registrado");
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
		setTitle("PSC Hotel");

	}	

}
