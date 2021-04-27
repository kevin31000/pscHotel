package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;
import es.deusto.spq.client.Habitacion;
import es.deusto.spq.client.Reserva;
import es.deusto.spq.client.ServiceLocator;

public class VentanaReservas extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel lHabitaciones = new JLabel();
	private JLabel lDisponibilidad = new JLabel();
	private JList listHabitaciones = new JList();
	private JList listDisponibilidad = new JList();
	private JButton bReservar = new JButton();
	private JButton bAtras = new JButton();

	public VentanaReservas(Controller controller) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lTitulo = new JLabel("Reservas");
		lTitulo.setFont(new Font("Arial", Font.PLAIN, 54));
		lTitulo.setBounds(410, 32, 309, 42);
		contentpane.add(lTitulo);

		lHabitaciones.setText("Habitaciones");
		lHabitaciones.setFont(new Font("Arial", Font.BOLD, 20));
		lHabitaciones.setBounds(100, -40, 300, 300);
		contentpane.add(lHabitaciones);

		lDisponibilidad.setText("Disponibilidad");
		lDisponibilidad.setFont(new Font("Arial", Font.BOLD, 20));
		lDisponibilidad.setBounds(810, -40, 300, 300);
		contentpane.add(lDisponibilidad);

		DefaultListModel contenidoHabitaciones = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<Habitacion> habitaciones = (ArrayList<Habitacion>) controller.obtenerHabitaciones();
		for (Habitacion habitacion : habitaciones) {
			if (habitacion != null) {
				contenidoHabitaciones.addElement(habitacion.toString());
			}
		}
		listHabitaciones.setModel(contenidoHabitaciones);
		listHabitaciones.setBounds(60, 130, 400, 400);
		contentpane.add(listHabitaciones);

		DefaultListModel contenidoDisponibilidad = new DefaultListModel();
		/*
		 * ArrayList<Reserva> reservas = (ArrayList<Reserva>)
		 * controller.obtenerReservas(); for (Reserva reserva : reservas) { if (reserva
		 * != null) { //crear abajo un metodo para comprobar que una habitacion esta
		 * ocupada y que refleje //en el programa (como parte de la tarea mostrar
		 * disponibilidad habitaciones) } }
		 */
		listDisponibilidad.setBounds(590, 130, 400, 340);
		contentpane.add(listDisponibilidad);
		
		bAtras.setForeground(SystemColor.text);
		bAtras.setBackground(new Color(0, 102, 204));
		bAtras.setBounds(500, 487, 220, 42);
		bAtras.setText("Atras");
		contentpane.add(bAtras);

		bReservar.setForeground(SystemColor.text);
		bReservar.setBackground(new Color(0, 102, 204));
		bReservar.setBounds(760, 487, 220, 42);
		bReservar.setText("Reservar");
		contentpane.add(bReservar);

		listHabitaciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				listHabitaciones = (JList) evt.getSource();
				if (evt.getClickCount() == 1) {

					// Double-click detected
					System.out.println("Click");
					int index = listHabitaciones.locationToIndex(evt.getPoint());
				}
			}
		});
		
		bAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaMenu menu = new VentanaMenu(controller);
				menu.setVisible(true);
				VentanaReservas.this.dispose();
			}
		});

		bReservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Reservas");
	}
}