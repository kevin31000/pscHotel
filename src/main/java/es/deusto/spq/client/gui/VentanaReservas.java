package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox comboDisponibilidad = new JComboBox();
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

		comboDisponibilidad.setFont(new Font("Arial", Font.BOLD, 20));
		comboDisponibilidad.setBounds(480, 280, 190, 30);
		contentpane.add(comboDisponibilidad);

		lDisponibilidad.setText("Disponibilidad");
		lDisponibilidad.setFont(new Font("Arial", Font.BOLD, 20));
		lDisponibilidad.setBounds(810, -40, 300, 300);
		contentpane.add(lDisponibilidad);

		DefaultListModel contenidoHabitaciones = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<Habitacion> habitaciones = (ArrayList<Habitacion>) controller.obtenerHabitaciones();
		for (Habitacion habitacion : habitaciones) {
			contenidoHabitaciones.addElement(habitacion);
			/*for (int i = 0; i < habitaciones.size(); i++) {
				if (habitaciones.get(i).getCodigo() == "H1") {
					contenidoHabitaciones.addElement(habitaciones.get(i).toString());
				}
				if (compCodigoHabitacion(habitaciones.get(i).getCodigo(), habitacion.getCodigo())) {
					contenidoHabitaciones.addElement(habitaciones.get(i).toString());
				}
			}*/
		}
		listHabitaciones.setModel(contenidoHabitaciones);
		listHabitaciones.setBounds(60, 130, 400, 400);
		contentpane.add(listHabitaciones);
		
		DefaultListModel contenidoDisponibilidad = new DefaultListModel();
	
		ArrayList<Reserva> reservas = (ArrayList<Reserva>) controller.obtenerReservas();
		for (Reserva reserva : reservas) {
			if (reserva != null) {
				contenidoDisponibilidad.addElement(reserva.toString());
			}
		}
		
		listDisponibilidad.setBounds(690, 130, 300, 340);
		contentpane.add(listDisponibilidad);
		
		bAtras.setForeground(SystemColor.text);
		bAtras.setBackground(new Color(0, 102, 204));
		bAtras.setBounds(690, 487, 95, 42);
		bAtras.setText("Atras");
		contentpane.add(bAtras);

		bReservar.setForeground(SystemColor.text);
		bReservar.setBackground(new Color(0, 102, 204));
		bReservar.setBounds(800, 487, 190, 42);
		bReservar.setText("Reservar");
		contentpane.add(bReservar);

		listHabitaciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				listHabitaciones = (JList) evt.getSource();
				if (evt.getClickCount() == 1) {

					// Double-click detected
					System.out.println("Click");
					String codigoHabitacion = "H" + Integer.toString(listHabitaciones.getSelectedIndex());
					/*for (Reserva reserva : reservas) {
						if (reserva != null) {
							if (reserva.getCodigoHabitacion() != codigoHabitacion) {
								contenidoDisponibilidad.addElement(reserva.toString());
							}
						}
					}*/
				}
			}
		});

		listDisponibilidad.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				listDisponibilidad = (JList) evt.getSource();
				if (evt.getClickCount() == 1) {

					// Double-click detected
					System.out.println("Click");
					int index = listDisponibilidad.locationToIndex(evt.getPoint());
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
				/*ArrayList<Reserva> reservas = (ArrayList<Reserva>) controller.obtenerReservas();
				String codigoReserva;
				for (Habitacion habitacion : habitaciones) {
					codigoReserva = habitacion.getCodigo() + Integer.toString(1);
				}

    			String codigoHabitacion = ;
    			String emailUsuario = ;
    			int dia = ;
    			int mes = ;
    			int anyo = ;

				controller.anadirReserva(codigoReserva, codigoHabitacion, emailUsuario, dia, mes, anyo);
				JOptionPane.showMessageDialog(null, "Reserva registrada correctamente.");*/
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Reservas");
	}

	//Se compara si un codigoHabitacion es superior a otro en 1
	public static boolean compCodigoHabitacion (String c1, String c2) {
		char cadena1[] = {'0', '0'}, cadena2[] = {'0', '0'};
		c1.getChars(1, 2, cadena1, 0);
		c2.getChars(1, 2, cadena2, 0);
		int n1 = Integer.parseInt(c1);
		int n2 = Integer.parseInt(c2);

		if (n1 - n2 == 1) {
			return true;
		} else {
			return false;
		}
	}

	//Devuelve true si esta ocupada, false si esta disponible
	public static boolean estaOcupada (ArrayList<Reserva> reservas, Habitacion h, int dia, int mes, int anyo) {
		for (Reserva reserva : reservas) {
			if (reserva.getCodigoHabitacion() == h.getCodigo() && reserva.getDia() == dia
			&& reserva.getMes() == mes && reserva.getAnyo() == anyo) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}