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
        lHabitaciones.setBounds(175, 20, 300, 300);
        contentpane.add(lHabitaciones);

        lDisponibilidad.setText("Disponibilidad");
        lDisponibilidad.setFont(new Font("Arial", Font.BOLD, 20));
        lDisponibilidad.setBounds(733, 20, 300, 300);
        contentpane.add(lDisponibilidad);

        DefaultListModel contListHabitaciones = new DefaultListModel();
        habitaciones.setModel(contListHabitaciones);
        habitaciones.setBounds(92, 200, 300, 320);
        contentpane.add(habitaciones);

        DefaultListModel contListDisponibilidad = new DefaultListModel();
        disponibilidad.setModel(contListDisponibilidad);
        disponibilidad.setBounds(650, 200, 300, 320);
        contentpane.add(disponibilidad);

        bReservar.setForeground(SystemColor.text);
        bReservar.setBackground(new Color(0, 102, 204));
        bReservar.setBounds(420, 400, 200, 42);
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