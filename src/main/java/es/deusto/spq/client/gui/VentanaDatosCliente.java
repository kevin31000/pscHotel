package es.deusto.spq.client.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.server.DBManager;

public class VentanaDatosCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel ldni;
	JTextField tdni;
	JLabel lnombre;
	JTextField tnombre;
	JLabel lapellido;
	JTextField tapellido;
	JLabel lemail;
	JTextField temail;
	JLabel lpassword;
	JPasswordField ppassword;
	JButton crear;
	JButton cancelar;

	public VentanaDatosCliente() {

		ldni = new JLabel("DNI");
		tdni = new JTextField(20);
		tdni.setEditable(false);
		
		lnombre = new JLabel("Nombre");
		tnombre = new JTextField(20);
		
		lapellido = new JLabel("Apellido");
		tapellido = new JTextField(20);
		
		lemail = new JLabel("Email");
		temail = new JTextField(20);

		lpassword = new JLabel("Contraseña");
		ppassword = new JPasswordField(20);	
		
		crear = new JButton("Guardar");

		
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				

			}

		});
		
		
		cancelar = new JButton("Cancelar");

		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.setLayout(new GridLayout(6, 2));
		add(ldni);
		add(tdni);
		add(lnombre);
		add(tnombre);
		add(lapellido);
		add(tapellido);
		add(lemail);
		add(temail);
		add(lpassword);
		add(ppassword);
		add(crear);
		add(cancelar);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Editar Datos");
		pack();
		setLocationRelativeTo(null);
		// setLocation(700, 300);
		setVisible(true);
	}
}