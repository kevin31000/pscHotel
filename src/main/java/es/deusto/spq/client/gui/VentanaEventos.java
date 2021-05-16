package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class VentanaEventos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JLabel lTitulo;

	public VentanaEventos(final Controller controller) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		lTitulo = new JLabel("LISTADO DE EVENTOS");
		lTitulo.setFont(new Font("Calibri", Font.BOLD, 25));
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setBounds(10, 31, 764, 50);

		contentpane.add(lTitulo);

		DefaultListModel todosLosEventos = new DefaultListModel<Cliente>();
		ServiceLocator serviceLocator = new ServiceLocator();

		JList listaEventos = new JList(todosLosEventos);
		listaEventos.setBounds(216, 92, 343, 416);
		contentpane.add(listaEventos);

		JButton bDatos = new JButton("VER DATOS");
		bDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		bDatos.setBounds(608, 193, 142, 33);
		contentpane.add(bDatos);

		JButton bCrearEvento = new JButton("CREAR EVENTO");
		bCrearEvento.setBackground(new Color(0, 102, 204));
		bCrearEvento.setFont(new Font("Tahoma", Font.BOLD, 13));
		bCrearEvento.setForeground(SystemColor.text);
		
		bCrearEvento.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new VentanaCrearEvento(controller);
					VentanaEventos.this.dispose();
			}
		});
		
		bCrearEvento.setBounds(608, 475, 142, 33);
		contentpane.add(bCrearEvento);

		JButton bAtras = new JButton("ATRAS");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaAdmin ventanaAdmin;
				try {
					ventanaAdmin = new VentanaAdmin(controller);
					ventanaAdmin.setVisible(true);
					VentanaEventos.this.dispose();
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
		this.setTitle("Eventos");
	}
}
