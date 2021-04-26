package es.deusto.spq.client.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Controller;
import es.deusto.spq.client.Habitacion;
import es.deusto.spq.client.ServiceLocator;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class VentanaAdmin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JLabel lTitulo;
	private ArrayList clientes; 
	
	
	public VentanaAdmin(final Controller controller)
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

