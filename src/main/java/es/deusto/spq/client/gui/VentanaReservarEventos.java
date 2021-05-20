package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;
import es.deusto.spq.client.Evento;
import es.deusto.spq.client.ReservaEvento;
import es.deusto.spq.client.ServiceLocator;

public class VentanaReservarEventos extends JFrame {
    private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel lEventos = new JLabel();
	private JList listEventos = new JList();
	private DefaultListModel contenidoEventos = new DefaultListModel();
	private JComboBox comboDisponibilidadDia = new JComboBox();
	private JComboBox comboDisponibilidadMes = new JComboBox();
	private JComboBox comboDisponibilidadAnyo = new JComboBox();
	private JButton bReservar = new JButton();
	private JButton bAtras = new JButton();

	public VentanaReservarEventos(Controller controller) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lTitulo = new JLabel("R. de eventos");
		lTitulo.setFont(new Font("Arial", Font.PLAIN, 54));
		lTitulo.setBounds(385, 32, 350, 42);
		contentpane.add(lTitulo);

		lEventos.setText("Eventos");
		lEventos.setFont(new Font("Arial", Font.BOLD, 20));
		lEventos.setBounds(100, -40, 300, 300);
		contentpane.add(lEventos);

		contenidoEventos = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<Evento> eventos = (ArrayList<Evento>) controller.getEventos();
		for (Evento evento : eventos) {
			contenidoEventos.addElement(evento);
		}
		listEventos.setModel(contenidoEventos);
		listEventos.setBounds(60, 130, 400, 400);
		contentpane.add(listEventos);
		
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
				VentanaMenu menu = new VentanaMenu(controller);
				menu.setVisible(true);
				VentanaReservarEventos.this.dispose();
			}
		});

		bReservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ReservaEvento> reservasEvento = (ArrayList<ReservaEvento>) controller.getReservasEvento();
				ArrayList<Evento> eventos = (ArrayList<Evento>) controller.getEventos();

				String codigoReserva = "";
    			String codigoEvento = "";				
				String emailUsuario = "";
				int dia = 0;
				int mes = 0;
				int anyo = 0;
			
				int nReserva = eventos.size() + 1;
				if (nReserva < 10) {
					codigoReserva = "RE0" + Integer.toString(nReserva);
				} else {
					codigoReserva = "RE" + Integer.toString(nReserva);
				}

				//CodigoEvento sera los caracteres 7 a 9 del Evento seleccionado en listEventos
				for (int i = 7; i < 9; i++) {
					codigoEvento = codigoEvento + listEventos.getSelectedValue().toString().charAt(i);
				}
				
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
				
				boolean condicion = false;
				if (listEventos.isSelectionEmpty() != true && dia != 0 && mes != 0 && anyo != 0) {
					condicion = existeReservaEvento(reservasEvento, eventos, codigoEvento, dia, mes, anyo);
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido registrar la reserva.");
				}
				if (condicion == true) {
					condicion = controller.anadirReserva(codigoReserva, codigoEvento, emailUsuario, dia, mes, anyo);
					JOptionPane.showMessageDialog(null, "Reserva registrada correctamente.");
				}
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1066, 600);
		this.setVisible(true);
		this.setTitle("Reserva de eventos");
	}

	public static boolean existeReservaEvento(ArrayList<ReservaEvento> reservasEvento,
	ArrayList<Evento> eventos, String codigoEvento,int dia, int mes, int anyo) {
		for (ReservaEvento reservaEvento : reservasEvento) {
			if (codigoEvento.equals(reservaEvento.getCodigoEvento()) && dia == reservaEvento.getDia() && mes == reservaEvento.getMes() && anyo == reservaEvento.getAnyo()) {
					JOptionPane.showMessageDialog(null, "Exceso de aforo o reserva repetida.");
					return false;			
			}
		}
		//COMPROBACION DE AFORO

		return true;
	}
}
