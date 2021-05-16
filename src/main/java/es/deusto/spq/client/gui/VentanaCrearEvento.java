package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;

public class VentanaCrearEvento extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton bCrearEvento = new JButton();
	private JButton bCancelar = new JButton();
	private final JLabel lNombreEvento = new JLabel("Nombre del evento: ");
	private final JTextField tNombreEvento = new JTextField();
	private final JLabel lDescripciónEvento = new JLabel("Descripción del evento: ");
	private final JTextArea tDescripciónEvento = new JTextArea(5, 5);
	private final JLabel lParticipantesMaximos = new JLabel("Participantes maximos: ");
	private JComboBox<String> cParticipantesMaximos;
	private final JLabel lFechaEventos = new JLabel("Fecha del evento: ");
	private final JLabel lAnyo = new JLabel("Año ");
	private JComboBox<String> cAnyo;
	private final JLabel lMes = new JLabel("Mes ");
	private JComboBox<String> cMes;
	private final JLabel lDia = new JLabel("Día ");
	private JComboBox<String> cDia;
	private final JLabel lEventoNuevo = new JLabel("EVENTO NUEVO");

	public VentanaCrearEvento(Controller controller) {

		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		lNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lNombreEvento.setBounds(218, 73, 150, 26);

		tNombreEvento.setColumns(10);
		tNombreEvento.setBounds(370, 79, 550, 19);

		contentpane.add(lNombreEvento);
		contentpane.add(tNombreEvento);

		lDescripciónEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDescripciónEvento.setBounds(218, 109, 200, 26);

		tDescripciónEvento.setLineWrap(true);
		tDescripciónEvento.setBounds(370, 115, 550, 90);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		tDescripciónEvento
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		contentpane.add(lDescripciónEvento);
		contentpane.add(tDescripciónEvento);

		lParticipantesMaximos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lParticipantesMaximos.setBounds(218, 217, 158, 26);

		cParticipantesMaximos = new JComboBox<String>();
		cParticipantesMaximos.setBounds(370, 222, 70, 20);

		cParticipantesMaximos.addItem("1");
		cParticipantesMaximos.addItem("2");
		cParticipantesMaximos.addItem("3");
		cParticipantesMaximos.addItem("4");
		cParticipantesMaximos.addItem("5");
		cParticipantesMaximos.addItem("6");
		cParticipantesMaximos.addItem("7");
		cParticipantesMaximos.addItem("8");
		cParticipantesMaximos.addItem("9");
		cParticipantesMaximos.addItem("10");
		cParticipantesMaximos.addItem("11");
		cParticipantesMaximos.addItem("12");
		cParticipantesMaximos.addItem("13");
		cParticipantesMaximos.addItem("14");
		cParticipantesMaximos.addItem("15");
		cParticipantesMaximos.addItem("16");
		cParticipantesMaximos.addItem("17");
		cParticipantesMaximos.addItem("18");
		cParticipantesMaximos.addItem("19");
		cParticipantesMaximos.addItem("20");
		cParticipantesMaximos.addItem("21");
		cParticipantesMaximos.addItem("22");
		cParticipantesMaximos.addItem("23");
		cParticipantesMaximos.addItem("24");
		cParticipantesMaximos.addItem("25");
		cParticipantesMaximos.addItem("26");
		cParticipantesMaximos.addItem("27");
		cParticipantesMaximos.addItem("28");
		cParticipantesMaximos.addItem("29");
		cParticipantesMaximos.addItem("30");
		cParticipantesMaximos.addItem("31");
		cParticipantesMaximos.addItem("32");
		cParticipantesMaximos.addItem("33");
		cParticipantesMaximos.addItem("34");
		cParticipantesMaximos.addItem("35");
		cParticipantesMaximos.addItem("36");
		cParticipantesMaximos.addItem("37");
		cParticipantesMaximos.addItem("38");
		cParticipantesMaximos.addItem("39");
		cParticipantesMaximos.addItem("40");
		cParticipantesMaximos.addItem("41");
		cParticipantesMaximos.addItem("42");
		cParticipantesMaximos.addItem("43");
		cParticipantesMaximos.addItem("44");
		cParticipantesMaximos.addItem("45");
		cParticipantesMaximos.addItem("46");
		cParticipantesMaximos.addItem("47");
		cParticipantesMaximos.addItem("48");
		cParticipantesMaximos.addItem("49");
		cParticipantesMaximos.addItem("50");
		cParticipantesMaximos.addItem("51");
		cParticipantesMaximos.addItem("52");
		cParticipantesMaximos.addItem("53");
		cParticipantesMaximos.addItem("54");
		cParticipantesMaximos.addItem("55");
		cParticipantesMaximos.addItem("56");
		cParticipantesMaximos.addItem("57");
		cParticipantesMaximos.addItem("58");
		cParticipantesMaximos.addItem("59");
		cParticipantesMaximos.addItem("60");
		cParticipantesMaximos.addItem("61");
		cParticipantesMaximos.addItem("62");
		cParticipantesMaximos.addItem("63");
		cParticipantesMaximos.addItem("64");
		cParticipantesMaximos.addItem("65");
		cParticipantesMaximos.addItem("66");
		cParticipantesMaximos.addItem("67");
		cParticipantesMaximos.addItem("68");
		cParticipantesMaximos.addItem("69");
		cParticipantesMaximos.addItem("70");

		contentpane.add(lParticipantesMaximos);
		contentpane.add(cParticipantesMaximos);

		lFechaEventos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lFechaEventos.setBounds(218, 277, 158, 26);

		lAnyo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lAnyo.setBounds(384, 254, 158, 26);

		cAnyo = new JComboBox<String>();
		cAnyo.setBounds(370, 282, 70, 20);

		cAnyo.addItem("2021");
		cAnyo.addItem("2022");
		cAnyo.addItem("2023");
		cAnyo.addItem("2024");
		cAnyo.addItem("2025");
		cAnyo.addItem("2026");
		cAnyo.addItem("2027");
		cAnyo.addItem("2028");
		cAnyo.addItem("2029");
		cAnyo.addItem("2030");

		contentpane.add(lFechaEventos);

		contentpane.add(lAnyo);
		contentpane.add(cAnyo);

		lMes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lMes.setBounds(508, 254, 158, 26);

		cMes = new JComboBox<String>();
		cMes.setBounds(498, 282, 55, 20);

		cMes.addItem("1");
		cMes.addItem("2");
		cMes.addItem("3");
		cMes.addItem("4");
		cMes.addItem("5");
		cMes.addItem("6");
		cMes.addItem("7");
		cMes.addItem("8");
		cMes.addItem("9");
		cMes.addItem("10");
		cMes.addItem("11");
		cMes.addItem("12");

		contentpane.add(lMes);
		contentpane.add(cMes);

		lDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDia.setBounds(622, 254, 158, 26);

		cDia = new JComboBox<String>();
		cDia.setBounds(611, 282, 55, 20);

		cDia.addItem("1");
		cDia.addItem("2");
		cDia.addItem("3");
		cDia.addItem("4");
		cDia.addItem("5");
		cDia.addItem("6");
		cDia.addItem("7");
		cDia.addItem("8");
		cDia.addItem("9");
		cDia.addItem("10");
		cDia.addItem("11");
		cDia.addItem("12");
		cDia.addItem("13");
		cDia.addItem("14");
		cDia.addItem("15");
		cDia.addItem("16");
		cDia.addItem("17");
		cDia.addItem("18");
		cDia.addItem("19");
		cDia.addItem("20");
		cDia.addItem("21");
		cDia.addItem("22");
		cDia.addItem("23");
		cDia.addItem("24");
		cDia.addItem("25");
		cDia.addItem("26");
		cDia.addItem("27");
		cDia.addItem("28");
		cDia.addItem("29");
		cDia.addItem("30");
		cDia.addItem("31");

		contentpane.add(lDia);
		contentpane.add(cDia);

		bCancelar.setForeground(SystemColor.text);
		bCancelar.setBackground(new Color(0, 102, 204));
		bCancelar.setBounds(778, 349, 142, 33);
		bCancelar.setText("CANCELAR");
		contentpane.add(bCancelar);

		bCrearEvento.setForeground(SystemColor.text);
		bCrearEvento.setBackground(new Color(0, 102, 204));
		bCrearEvento.setFont(new Font("Tahoma", Font.BOLD, 13));
		bCrearEvento.setBounds(218, 349, 142, 33);
		bCrearEvento.setText("CREAR EVENTO");
		contentpane.add(bCrearEvento);

		lEventoNuevo.setFont(new Font("Tahoma", Font.BOLD, 19));
		lEventoNuevo.setBounds(127, 23, 300, 26);

		contentpane.add(lEventoNuevo);

		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaEventos ventanaEvento;
				ventanaEvento = new VentanaEventos(controller);
				ventanaEvento.setVisible(true);
				VentanaCrearEvento.this.dispose();
				JOptionPane.showMessageDialog(null, "Nuevo evento cancelado.", "Crear evento",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		bCrearEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setVisible(true);
		this.setTitle("Crear evento");

	}
}
