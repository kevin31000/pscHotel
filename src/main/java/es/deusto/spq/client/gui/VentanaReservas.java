package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Properties;

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
	private JList listHabitaciones = new JList();
	private DefaultListModel contenidoHabitaciones = new DefaultListModel();
	private JComboBox comboDisponibilidadDia = new JComboBox();
	private JComboBox comboDisponibilidadMes = new JComboBox();
	private JComboBox comboDisponibilidadAnyo = new JComboBox();
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

		contenidoHabitaciones = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<Habitacion> habitaciones = (ArrayList<Habitacion>) controller.obtenerHabitaciones();
		for (Habitacion habitacion : habitaciones) {
			contenidoHabitaciones.addElement(habitacion);
		}
		listHabitaciones.setModel(contenidoHabitaciones);
		listHabitaciones.setBounds(60, 130, 400, 400);
		contentpane.add(listHabitaciones);
	
		//listDisponibilidad.setBounds(690, 130, 300, 340);
		//contentpane.add(listDisponibilidad);
		
		bAtras.setForeground(SystemColor.text);
		bAtras.setBackground(new Color(0, 102, 204));
		bAtras.setBounds(540, 440, 90, 42);
		bAtras.setText("Atras");
		contentpane.add(bAtras);

		bReservar.setForeground(SystemColor.text);
		bReservar.setBackground(new Color(0, 102, 204));
		bReservar.setBounds(770, 220, 190, 125);
		bReservar.setText("Reservar");
		contentpane.add(bReservar);

		listHabitaciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				listHabitaciones = (JList) evt.getSource();
				if (evt.getClickCount() == 1) {

					// Double-click detected
					System.out.println("Click");
				}
			}
		});

		comboDisponibilidadDia.setFont(new Font("Arial", Font.BOLD, 16));
		comboDisponibilidadDia.setBounds(500, 360, 190, 30);
		comboDisponibilidadDia.addItem("ESCOJA EL DIA");
		for (int i = 1; i < 32; i++) {
			comboDisponibilidadDia.addItem(Integer.toString(i));
		}
		contentpane.add(comboDisponibilidadDia);

		comboDisponibilidadMes.setFont(new Font("Arial", Font.BOLD, 16));
		comboDisponibilidadMes.setBounds(500, 260, 190, 30);
		comboDisponibilidadMes.addItem("ESCOJA EL MES");
		for (int i = 1; i < 13; i++) {
			comboDisponibilidadMes.addItem(Integer.toString(i));
		}
		contentpane.add(comboDisponibilidadMes);

		comboDisponibilidadAnyo.setFont(new Font("Arial", Font.BOLD, 16));
		comboDisponibilidadAnyo.setBounds(500, 160, 190, 30);
		comboDisponibilidadAnyo.addItem("ESCOJA EL ANYO");
		for (int i = 2021; i < 2031; i++) {
			comboDisponibilidadAnyo.addItem(Integer.toString(i));
		}
		contentpane.add(comboDisponibilidadAnyo);
		
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
				ArrayList<Reserva> reservas = (ArrayList<Reserva>) controller.obtenerReservas();
				String codigoReserva = "";
    			String codigoHabitacion = "";				
				String emailUsuario = "";
				int dia = 0;
				int mes = 0;
				int anyo = 0;
			
				for (int i = 0; i < reservas.size(); i++) {
					if (i == reservas.size()-1) {
						codigoReserva = "R" + reservas.get(i).getCodigoReserva().charAt(1) + reservas.get(i).getCodigoReserva().charAt(2);
					}
				}
				codigoHabitacion = "H" + Integer.toString(listHabitaciones.getSelectedIndex());
				Properties objetoP = new Properties();
				try {
					objetoP.load(new FileInputStream("prop.properties"));
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (objetoP.getProperty("email") != null) {
					emailUsuario = objetoP.getProperty("email");
				}
				if (comboDisponibilidadDia.getSelectedItem().toString() != "ESCOJA EL DIA") {
					dia = Integer.parseInt(comboDisponibilidadDia.getSelectedItem().toString());
				}
				if (comboDisponibilidadMes.getSelectedItem().toString() != "ESCOJA EL MES") {
					mes = Integer.parseInt(comboDisponibilidadMes.getSelectedItem().toString());
				}
				if (comboDisponibilidadAnyo.getSelectedItem().toString() != "ESCOJA EL ANYO") {
					anyo = Integer.parseInt(comboDisponibilidadAnyo.getSelectedItem().toString());
				}
				
				boolean condicion = existeReserva(reservas, codigoReserva);
				if (condicion == true && codigoHabitacion != "" && emailUsuario != ""
				&& dia != 0 && mes != 0 && anyo != 0) {
					condicion = controller.anadirReserva(codigoReserva, codigoHabitacion, emailUsuario, dia, mes, anyo);
					JOptionPane.showMessageDialog(null, "Reserva registrada correctamente.");
				} else if (condicion == false) { 
					JOptionPane.showMessageDialog(null, "Habitacion ocupada.");
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido registrar la reserva.");
				}
				
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Reservas");
	}

	public static boolean existeReserva(ArrayList<Reserva> reservas, String codigoReserva) {
		boolean condicion = true;

		for (Reserva reserva : reservas) {
			if (codigoReserva == reserva.getCodigoHabitacion()) {
				condicion = false;
			}
		}

		return condicion;
	}

}