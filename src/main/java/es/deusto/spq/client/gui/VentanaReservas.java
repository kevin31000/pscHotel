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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Habitacion;

public class VentanaReservas extends JFrame{
    private static final long serialVersionUID = 1L;

    private JPanel contentpane;
    private JLabel lHabitaciones = new JLabel();
    private JLabel lDisponibilidad = new JLabel();
    private JList habitaciones = new JList();
    private JList disponibilidad = new JList();
    private JButton bReservar = new JButton();

    public VentanaReservas() {
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

        Habitacion h1 = new Habitacion("H1", 4, 73, false);
		Habitacion h2 = new Habitacion("H2", 4, 73, false);
		Habitacion h3 = new Habitacion("H3", 4, 67, false);
		Habitacion h4 = new Habitacion("H4", 4, 67, false);
		Habitacion h5 = new Habitacion("H5", 3, 51, false);
		Habitacion h6 = new Habitacion("H6", 3, 51, false);
		Habitacion h7 = new Habitacion("H7", 3, 54, false);
		Habitacion h8 = new Habitacion("H8", 3, 54, false);
		Habitacion h9 = new Habitacion("H9", 2, 85, false);
		Habitacion h10 = new Habitacion("H10", 2, 70, false);
		Habitacion h11 = new Habitacion("H11", 2, 70, false);
		Habitacion h12 = new Habitacion("H12", 2, 65, false);
		Habitacion h13 = new Habitacion("H13", 1, 72, false);
		Habitacion h14 = new Habitacion("H14", 1, 72, false);
		Habitacion h15 = new Habitacion("H15", 1, 68, false);
		Habitacion h16 = new Habitacion("H16", 1, 68, false);

        DefaultListModel contenidoHabitaciones = new DefaultListModel();
        contenidoHabitaciones.addElement(h1);
        contenidoHabitaciones.addElement(h2);
        contenidoHabitaciones.addElement(h3);
        contenidoHabitaciones.addElement(h4);
        contenidoHabitaciones.addElement(h5);
        contenidoHabitaciones.addElement(h6);
        contenidoHabitaciones.addElement(h7);
        contenidoHabitaciones.addElement(h8);
        contenidoHabitaciones.addElement(h9);
        contenidoHabitaciones.addElement(h10);
        contenidoHabitaciones.addElement(h11);
        contenidoHabitaciones.addElement(h12);
        contenidoHabitaciones.addElement(h13);
        contenidoHabitaciones.addElement(h14);
        contenidoHabitaciones.addElement(h15);
        contenidoHabitaciones.addElement(h16);
        habitaciones.setModel(contenidoHabitaciones);
        habitaciones.setBounds(60, 130, 400, 400);
        contentpane.add(habitaciones);

        DefaultListModel contenidoDisponibilidad = new DefaultListModel();
        disponibilidad.setModel(contenidoDisponibilidad);
        disponibilidad.setBounds(590, 130, 400, 340);
        contentpane.add(disponibilidad);

        bReservar.setForeground(SystemColor.text);
        bReservar.setBackground(new Color(0, 102, 204));
        bReservar.setBounds(760, 487, 220, 42);
        bReservar.setText("Reservar");
        contentpane.add(bReservar);

        bReservar.addActionListener(new ActionListener () {
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

    public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new VentanaReservas();
			}
		});
	}
}