package es.deusto.spq.client.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.core.Response;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Controller;
import es.deusto.spq.client.Habitacion;
import es.deusto.spq.client.ServiceLocator;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class VentanaUsuariosAdmin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JLabel lTitulo;
	private ArrayList clientes; 
	
	
	public VentanaUsuariosAdmin(final Controller controller)
	{
		contentpane = new JPanel();
		
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		lTitulo = new JLabel("LISTADO DE CLIENTES");
		lTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setBounds(10, 31, 764, 50);
		
		contentpane.add(lTitulo);
		
		DefaultListModel todosLosClientes = new DefaultListModel<Cliente>();
		ServiceLocator serviceLocator = new ServiceLocator();
		
		JList listaCliente = new JList(todosLosClientes);
		listaCliente.setBounds(216, 92, 343, 416);
		contentpane.add(listaCliente);
		
		
		for (Cliente cliente : controller.obtenerClientes()) {
			if (cliente != null) {
				todosLosClientes.addElement(cliente.toString());
			}
		}		
		
		JButton bDatos = new JButton("VER DATOS");
		bDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bDatos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				VentanaDatosCliente datosCliente;
				String c =  listaCliente.getSelectedValue().toString();
				Cliente cl = controller.getUsuario(c);
				datosCliente = new VentanaDatosCliente(controller, cl);
				datosCliente.setVisible(true);
				
			}
		});
		bDatos.setBounds(608, 193, 142, 33);
		contentpane.add(bDatos);
		
		JButton bBanear = new JButton("BANEAR");
		bBanear.setBackground(new Color(255, 182, 193));
		bBanear.setFont(new Font("Tahoma", Font.BOLD, 13));
		bBanear.setForeground(new Color(255, 0, 0));
		bBanear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String c = listaCliente.getSelectedValue().toString();
				System.out.println(c);
				Cliente cl = controller.getUsuario(c);
				System.out.println(cl);
				Response ban = controller.borrarCliente(cl);
				
				VentanaAdmin ventanaAdmin;
				try {
					ventanaAdmin = new VentanaAdmin(controller);
					ventanaAdmin.setVisible(true);
					VentanaUsuariosAdmin.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				JOptionPane.showMessageDialog(null, "Cliente borrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		bBanear.setBounds(608, 475, 142, 33);
		contentpane.add(bBanear);
		
		JButton bAtras = new JButton("ATRAS");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAdmin ventanaAdmin;
				try {
					ventanaAdmin = new VentanaAdmin(controller);
					ventanaAdmin.setVisible(true);
					VentanaUsuariosAdmin.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		bAtras.setBounds(35, 475, 142, 33);
		contentpane.add(bAtras);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setTitle("Administración");
	}
}

