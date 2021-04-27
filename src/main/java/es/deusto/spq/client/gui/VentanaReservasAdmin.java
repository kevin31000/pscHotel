package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Controller;
import es.deusto.spq.client.ServiceLocator;


public class VentanaReservasAdmin extends JFrame{
		
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JLabel lTitulo;
	private ArrayList clientes; 
		
		
	public VentanaReservasAdmin(final Controller controller)
	{
		contentpane = new JPanel();
			
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
			
		lTitulo = new JLabel("LISTADO DE RESERVAS");
		lTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setBounds(10, 31, 764, 50);
			
		contentpane.add(lTitulo);
			
			
		JList listaCliente = new JList();
		listaCliente.setBounds(216, 92, 343, 416);
		contentpane.add(listaCliente);
			
		DefaultListModel todosLosClientes = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) controller.obtenerClientes();
		for (Cliente cliente : clientes) {
			if (cliente != null) {
				todosLosClientes.addElement(cliente.toString());
			}
		}
		listaCliente.setModel(todosLosClientes);
			
			
		JButton bDatos = new JButton("VER DATOS");
		bDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bDatos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					
					
			}
		});
		bDatos.setBounds(608, 193, 142, 33);
		contentpane.add(bDatos);
			
		JButton bBanear = new JButton("BANEAR");
		bBanear.setBackground(new Color(255, 182, 193));
		bBanear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bBanear.setForeground(new Color(255, 0, 0));
		bBanear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					
					
			}
		});
		bBanear.setBounds(608, 475, 142, 33);
		contentpane.add(bBanear);
			
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setTitle("Administración");
	}


}
