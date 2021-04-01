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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

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
	private JLabel labelAdmin = new JLabel();
	private JTextField textDNI = new JTextField();
	private JTextField textNombre = new JTextField();
	private JTextField textApellido = new JTextField();
	private JTextField textEmail = new JTextField();
	private JTextField textContrasenya = new JTextField();
	private JRadioButton adminSi = new JRadioButton();
	private JRadioButton adminNo = new JRadioButton();
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
		labelAdmin.setFont(new Font("Arial", Font.BOLD, 11));

		labelAdmin.setText(" ¿Es admin?");
		labelAdmin.setBounds(70, 404, 120, 20);
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
		
		grupo = new ButtonGroup();
		
		adminSi.setBounds(214, 404, 143, 20);
		adminSi.setText("Si");
		contentpane.add(adminSi);
		
		adminNo.setBounds(214, 430, 143, 20);
		adminNo.setText("No");
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
