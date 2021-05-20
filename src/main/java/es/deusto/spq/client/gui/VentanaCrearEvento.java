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
	private final JLabel lCodigoEvento = new JLabel("Codigo del evento: ");
	private final JTextField tCodigoEvento = new JTextField();
	private final JLabel lDescripcionEvento = new JLabel("Descripción del evento: ");
	private final JTextArea tDescripcionEvento = new JTextArea(5, 5);
	private final JLabel lPMax = new JLabel("Participantes maximos: ");
	private JComboBox<String> cPMax;
	private final JLabel lFechaEventos = new JLabel("Fecha del evento: ");
	private final JLabel lAnyo = new JLabel("Año ");
	private JComboBox<String> cAnyo;
	private final JLabel lMes = new JLabel("Mes ");
	private JComboBox<String> cMes;
	private final JLabel lDia = new JLabel("Día ");
	private JComboBox<String> cDia;
	private final JLabel lHoraEvento = new JLabel("Hora del evento: ");
	private final JTextField tHoraEvento = new JTextField();
	private final JLabel lEventoNuevo = new JLabel("EVENTO NUEVO");

	public VentanaCrearEvento(Controller controller) {

		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		lNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lNombreEvento.setBounds(218, 73, 150, 26);

		tNombreEvento.setColumns(10);
		tNombreEvento.setBounds(370, 79, 280, 19);

		contentpane.add(lNombreEvento);
		contentpane.add(tNombreEvento);

		lCodigoEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lCodigoEvento.setBounds(685, 73, 140, 26);

		tCodigoEvento.setColumns(10);
		tCodigoEvento.setBounds(832, 79, 88, 19);

		contentpane.add(lCodigoEvento);
		contentpane.add(tCodigoEvento);

		lDescripcionEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDescripcionEvento.setBounds(218, 109, 200, 26);

		tDescripcionEvento.setLineWrap(true);
		tDescripcionEvento.setBounds(370, 115, 550, 90);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		tDescripcionEvento.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));


		contentpane.add(lDescripcionEvento);
		contentpane.add(tDescripcionEvento);

		lPMax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lPMax.setBounds(218, 217, 158, 26);

		cPMax = new JComboBox<String>();
		cPMax.setBounds(370, 222, 70, 20);
		
		cPMax.addItem("ESCOJA EL NUM");
		cPMax.addItem("1");	cPMax.addItem("2");	cPMax.addItem("3");	cPMax.addItem("4");	cPMax.addItem("5");	cPMax.addItem("6");	cPMax.addItem("7");	
		cPMax.addItem("8");	cPMax.addItem("9");	cPMax.addItem("10"); cPMax.addItem("11"); cPMax.addItem("12"); cPMax.addItem("13"); cPMax.addItem("14"); 
		cPMax.addItem("15"); cPMax.addItem("16"); cPMax.addItem("17"); cPMax.addItem("18"); cPMax.addItem("19"); cPMax.addItem("20"); cPMax.addItem("21"); 
		cPMax.addItem("22"); cPMax.addItem("23"); cPMax.addItem("24"); cPMax.addItem("25"); cPMax.addItem("26"); cPMax.addItem("27"); cPMax.addItem("28");
		cPMax.addItem("29"); cPMax.addItem("30"); cPMax.addItem("31"); cPMax.addItem("32"); cPMax.addItem("33"); cPMax.addItem("34"); cPMax.addItem("35");
		cPMax.addItem("36"); cPMax.addItem("37"); cPMax.addItem("38"); cPMax.addItem("39"); cPMax.addItem("40"); cPMax.addItem("41"); cPMax.addItem("42"); 
		cPMax.addItem("43"); cPMax.addItem("44"); cPMax.addItem("45"); cPMax.addItem("46"); cPMax.addItem("47"); cPMax.addItem("48"); cPMax.addItem("49"); 
		cPMax.addItem("50"); cPMax.addItem("51"); cPMax.addItem("52"); cPMax.addItem("53"); cPMax.addItem("54"); cPMax.addItem("55"); cPMax.addItem("56");
		cPMax.addItem("57"); cPMax.addItem("58"); cPMax.addItem("59"); cPMax.addItem("60"); cPMax.addItem("61"); cPMax.addItem("62"); cPMax.addItem("63"); 
		cPMax.addItem("64"); cPMax.addItem("65"); cPMax.addItem("66"); cPMax.addItem("67"); cPMax.addItem("68"); cPMax.addItem("69"); cPMax.addItem("70");

		contentpane.add(lPMax);
		contentpane.add(cPMax);

		lFechaEventos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lFechaEventos.setBounds(218, 277, 158, 26);

		lAnyo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lAnyo.setBounds(384, 254, 158, 26);
		
		cAnyo = new JComboBox<String>();
		cAnyo.setBounds(370, 282, 70, 20);

		cAnyo.addItem("ESCOJA EL ANYO");
		cAnyo.addItem("2021"); cAnyo.addItem("2022"); cAnyo.addItem("2023"); cAnyo.addItem("2024"); cAnyo.addItem("2025"); cAnyo.addItem("2026");
		cAnyo.addItem("2027"); cAnyo.addItem("2028"); cAnyo.addItem("2029");cAnyo.addItem("2030");

		contentpane.add(lFechaEventos);

		contentpane.add(lAnyo);
		contentpane.add(cAnyo);

		lMes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lMes.setBounds(508, 254, 158, 26);

		cMes = new JComboBox<String>();
		cMes.setBounds(498, 282, 55, 20);
		cMes.addItem("ESCOJA EL MES");
		cMes.addItem("1"); cMes.addItem("2"); cMes.addItem("3"); cMes.addItem("4"); cMes.addItem("5"); cMes.addItem("6"); cMes.addItem("7");
		cMes.addItem("8"); cMes.addItem("9"); cMes.addItem("10"); cMes.addItem("11"); cMes.addItem("12");

		contentpane.add(lMes);
		contentpane.add(cMes);

		lDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDia.setBounds(622, 254, 158, 26);

		cDia = new JComboBox<String>();
		cDia.setBounds(611, 282, 55, 20);
		cDia.addItem("ESCOJA EL DIA");
		cDia.addItem("1"); cDia.addItem("2"); cDia.addItem("3"); cDia.addItem("4"); cDia.addItem("5"); cDia.addItem("6"); cDia.addItem("7"); cDia.addItem("8");
		cDia.addItem("9"); cDia.addItem("10"); cDia.addItem("11"); cDia.addItem("12"); cDia.addItem("13"); cDia.addItem("14"); cDia.addItem("15"); cDia.addItem("16");
		cDia.addItem("17"); cDia.addItem("18"); cDia.addItem("19"); cDia.addItem("20"); cDia.addItem("21"); cDia.addItem("22"); cDia.addItem("23"); cDia.addItem("24");
		cDia.addItem("25");	cDia.addItem("26"); cDia.addItem("27"); cDia.addItem("28"); cDia.addItem("29"); cDia.addItem("30"); cDia.addItem("31");

		contentpane.add(lDia);
		contentpane.add(cDia);
		
		lHoraEvento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lHoraEvento.setBounds(218, 315, 140, 26);

		tHoraEvento.setColumns(10);
		tHoraEvento.setBounds(370, 321, 71, 19);

		contentpane.add(lHoraEvento);
		contentpane.add(tHoraEvento);


		bCancelar.setForeground(SystemColor.text);
		bCancelar.setBackground(new Color(0, 102, 204));
		bCancelar.setBounds(218, 450, 142, 33);
		bCancelar.setText("CANCELAR");
		contentpane.add(bCancelar);

		bCrearEvento.setForeground(SystemColor.text);
		bCrearEvento.setBackground(new Color(0, 102, 204));
		bCrearEvento.setFont(new Font("Tahoma", Font.BOLD, 13));
		bCrearEvento.setBounds(218, 389, 142, 33);
		bCrearEvento.setText("CREAR EVENTO");
		contentpane.add(bCrearEvento);

		lEventoNuevo.setFont(new Font("Tahoma", Font.BOLD, 19));
		lEventoNuevo.setBounds(127, 23, 300, 26);

		contentpane.add(lEventoNuevo);
		
		JButton bAtras = new JButton();
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEventos eventos;
				try {
					eventos = new VentanaEventos(controller);
					eventos.setVisible(true);
					VentanaCrearEvento.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		bAtras.setText("ATRAS");
		bAtras.setForeground(Color.WHITE);
		bAtras.setBackground(new Color(0, 102, 204));
		bAtras.setBounds(778, 389, 142, 33);
		contentpane.add(bAtras);

		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaEventos ventanaEvento;
				ventanaEvento = new VentanaEventos(controller);
				ventanaEvento.setVisible(true);
				VentanaCrearEvento.this.dispose();
				JOptionPane.showMessageDialog(null, "Creación de evento cancelada.", "Crear evento",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		bCrearEvento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean error = false;
				boolean correcto = false;
				int num = 0;
				int anyo = 0;
				int mes = 0;
				int dia = 0;
				
				
				if (cAnyo.getSelectedItem().toString() != "ESCOJA EL ANYO") {
					anyo = Integer.parseInt(cAnyo.getSelectedItem().toString());
				}
				if (cPMax.getSelectedItem().toString() != "ESCOJA EL NUM") {
					num = Integer.parseInt(cPMax.getSelectedItem().toString());
				}
				if (cMes.getSelectedItem().toString() != "ESCOJA EL MES") {
					mes = Integer.parseInt(cMes.getSelectedItem().toString());
				}
				if (cDia.getSelectedItem().toString() != "ESCOJA EL DIA") {
					dia = Integer.parseInt(cDia.getSelectedItem().toString());
				}
				
				if(tNombreEvento.getText().equals("") || tCodigoEvento.getText().equals("") || tDescripcionEvento.getText().equals("") 
						|| cPMax.getSelectedItem().toString().isEmpty() || cAnyo.getSelectedItem().toString().isEmpty() || 
						cMes.getSelectedItem().toString().isEmpty() || cDia.getSelectedItem().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error",JOptionPane.INFORMATION_MESSAGE);
					VentanaCrearEvento.this.repaint();
					error = true;
				}else if (!error) {
					controller.anadirEvento(tNombreEvento.getText(), tDescripcionEvento.getText(), dia, mes, anyo ,num );
					correcto= true;
				}
				
				if (correcto) {
					JOptionPane.showMessageDialog(null, "Evento registrado correctamente.");
				}

			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setVisible(true);
		this.setTitle("Crear evento");

	}
}
