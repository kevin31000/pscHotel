package es.deusto.spq.client.gui;

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
import es.deusto.spq.client.Reserva;
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
			
		DefaultListModel todasLasReservas = new DefaultListModel<Reserva>();
		ServiceLocator serviceLocator = new ServiceLocator();
		
		JList listaReserva = new JList(todasLasReservas);
		listaReserva.setBounds(216, 92, 343, 416);
		contentpane.add(listaReserva);
		
		
		for (Reserva reserva : controller.obtenerReservas()) {
			if (reserva != null) {
				todasLasReservas.addElement(reserva.toString());
			}
		}		
		
		JButton bDatos = new JButton("VER DATOS");
		bDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bDatos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				VentanaMostrarReservas datosReserva;
				String r =  listaReserva.getSelectedValue().toString();
				Reserva reserva = controller.getReserva(r);
				datosReserva = new VentanaMostrarReservas(controller, reserva);
				datosReserva.setVisible(true);
				VentanaReservasAdmin.this.dispose();
				
			}
		});
		bDatos.setBounds(608, 193, 142, 33);
		contentpane.add(bDatos);
		
		JButton bAtras = new JButton("ATRAS");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAdmin ventanaAdmin;
				try {
					ventanaAdmin = new VentanaAdmin(controller);
					ventanaAdmin.setVisible(true);
					VentanaReservasAdmin.this.dispose();
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
		this.setTitle("Reservas");
	}


}
