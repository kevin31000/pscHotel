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
import javax.ws.rs.core.Response;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Controller;
import es.deusto.spq.server.DBManager;

public class VentanaDatosCliente extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	DBManager dbManager;
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

	public VentanaDatosCliente(final Controller controller, Cliente u) {

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

		//Cliente u = new Cliente("11", "mikel", "castro", "ad","a", true);
		//Cliente u =DBManager.getUsuario(VentanaInicioSesion.cargarEmailUsuario());
		//Cliente u = controller.getUsuario(VentanaInicioSesion.cargarEmailUsuario());
		System.out.println(u);
		tdni.setText(u.getDNI());
		tnombre.setText(u.getNombre());
		tapellido.setText(u.getApellido());
		temail.setText(u.getEmail());
		ppassword.setText(u.getContrasenya());	
		
		System.out.println(ppassword.getText());
		Cliente viejo = controller.getUsuario(temail.getText());
		
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Response ban = controller.borrarCliente(viejo);
				
				Cliente actualizarClient = new Cliente(tdni.getText(), tnombre.getText(), tapellido.getText(), temail.getText(), ppassword.getText(), false);
				
				System.out.println(actualizarClient.getContrasenya());
				
				controller.anadirCliente(actualizarClient.getDNI(), actualizarClient.getNombre(), actualizarClient.getApellido(),
						actualizarClient.getEmail(), actualizarClient.getContrasenya(), false);
				
				JOptionPane.showMessageDialog(null, "Cliente actualizado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				VentanaDatosCliente.this.dispose();
			}

		});
		
		
		cancelar = new JButton("Cancelar");

		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaDatosCliente.this.dispose();
			
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
