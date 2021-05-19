package es.deusto.spq.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaFeedback extends JFrame{

	private JPanel contentpane;
	private ButtonGroup bgEstrellas, bgRecomendacion;
	
	
	public VentanaFeedback(final Controller controller) {
		
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel lTitulo = new JLabel("VALORACION:");
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lTitulo.setToolTipText("");
		lTitulo.setBounds(154, 11, 229, 35);
		contentpane.add(lTitulo);
		
		JRadioButton rd1 = new JRadioButton("1*");
		rd1.setActionCommand("1");
		rd1.setBounds(66, 62, 44, 23);
		contentpane.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("2*");
		rd2.setActionCommand("2");
		rd2.setBounds(157, 62, 57, 23);
		contentpane.add(rd2);
		
		JRadioButton rd3 = new JRadioButton("3*");
		rd3.setActionCommand("3");
		rd3.setBounds(247, 62, 44, 23);
		contentpane.add(rd3);
		
		JRadioButton rd4 = new JRadioButton("4*");
		rd4.setActionCommand("4");
		rd4.setBounds(339, 62, 44, 23);
		contentpane.add(rd4);
		
		JRadioButton rd5 = new JRadioButton("5*");
		rd5.setActionCommand("5");
		rd5.setBounds(430, 62, 44, 23);
		contentpane.add(rd5);
		
		bgEstrellas = new ButtonGroup();
		bgEstrellas.add(rd1);
		bgEstrellas.add(rd2);
		bgEstrellas.add(rd3);
		bgEstrellas.add(rd4);
		bgEstrellas.add(rd5);
		
		
		JLabel lRecomendar = new JLabel("\u00BFLo recomendar\u00EDas?");
		lRecomendar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lRecomendar.setBounds(86, 132, 148, 23);
		contentpane.add(lRecomendar);
		
		JRadioButton rdSi = new JRadioButton("S\u00ED");
		rdSi.setActionCommand("si");
		rdSi.setBounds(247, 134, 57, 23);
		contentpane.add(rdSi);
		
		JRadioButton rdNo = new JRadioButton("No");
		rdNo.setActionCommand("no");
		rdNo.setBounds(339, 134, 57, 23);
		contentpane.add(rdNo);
		
		bgRecomendacion = new ButtonGroup();
		bgRecomendacion.add(rdSi);
		bgRecomendacion.add(rdNo);
		
		JLabel lblError = new JLabel("Falta valoraci\u00F3n o recomendaci\u00F3n");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setBounds(188, 166, 161, 14);
		contentpane.add(lblError);
		
		JButton bEnviar = new JButton("ENVIAR");
		bEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setVisible(false);
				if (!bgEstrellas.isSelected(null) && !bgRecomendacion.isSelected(null)) {
					lblError.setVisible(false);
					es.deusto.spq.server.Main.crearFicheroLog();
					es.deusto.spq.server.Main.logFeedback
							.println("Puntuacion: " + bgEstrellas.getSelection().getActionCommand() + "\n" + "Si/No: "
									+ bgRecomendacion.getSelection().getActionCommand());
					try {
						es.deusto.spq.server.DBManager.registrarFeedback(es.deusto.spq.client.gui.VentanaInicioSesion.cargarEmailUsuario(),
								bgEstrellas.getSelection().getActionCommand(),
								bgRecomendacion.getSelection().getActionCommand());
					} catch (Exception e1) {
						es.deusto.spq.server.Main.loggerGeneral.log(Level.INFO, e1.toString());
						e1.printStackTrace();
					}
					VentanaMenu menu;
					try {
						menu = new VentanaMenu(controller);
						menu.setVisible(true);
						VentanaFeedback.this.dispose();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					JOptionPane.showMessageDialog(null, "Mandado correctamente.", "Dar Feedback",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (bgEstrellas.isSelected(null) || bgRecomendacion.isSelected(null)) {
					lblError.setVisible(true);
				}
			}
		});
		bEnviar.setBounds(371, 185, 103, 26);
		contentpane.add(bEnviar);
		
		JButton bAtras = new JButton("ATRAS");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaMenu menu;
				try {
					menu = new VentanaMenu(controller);
					menu.setVisible(true);
					VentanaFeedback.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		bAtras.setBounds(66, 184, 103, 29);
		contentpane.add(bAtras);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(560, 300);
		this.setVisible(true);
		this.setTitle("Valoracion");
		
		
	}
}
