package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.core.Response;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Controller;
import es.deusto.spq.client.Reserva;

public class VentanaMostrarReservas extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton bGuardarCambios = new JButton();
	private JButton bAtras = new JButton();
	private final JLabel lDni = new JLabel("DNI: ");
	private final JTextField tDni = new JTextField();
	private final JLabel lEmail = new JLabel("EMAIL: ");
	private final JTextField tEmail = new JTextField();
	private final JButton bCancelarReserva = new JButton();
	private final JLabel lCodigoReserva = new JLabel("CODIGO RESERVA: ");
	private final JTextField tCodigoReserva = new JTextField();
	private final JLabel lNumeroHabitacion = new JLabel("NUMERO HABITACION: ");
	private final JLabel lDia = new JLabel("D: ");
	private final JLabel lCodigoReserva_1_1_1 = new JLabel("M: ");
	private final JLabel lCodigoReserva_1_1_2 = new JLabel("A:");
	private final JTextField tCogidoHabitacion = new JTextField();
	private final JTextField tDia = new JTextField();
	private final JTextField tMes = new JTextField();
	private final JTextField tAnyo = new JTextField();
	private final JLabel lblNewLabel = new JLabel("RESERVAS");
	
	public VentanaMostrarReservas(Controller controller, Reserva reserva)
	{
		tEmail.setBounds(513, 79, 412, 19);
		tEmail.setColumns(10);
		tDni.setBounds(265, 79, 167, 19);
		tDni.setColumns(10);

		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		bAtras.setForeground(SystemColor.text);
		bAtras.setBackground(new Color(0, 102, 204));
		bAtras.setBounds(759, 349, 200, 42);
		bAtras.setText("ATRAS");
		contentpane.add(bAtras);
			
		bGuardarCambios.setForeground(SystemColor.text);
		bGuardarCambios.setBackground(new Color(0, 102, 204));
		bGuardarCambios.setBounds(221, 349, 200, 42);
		bGuardarCambios.setText("GUARDAR CAMBIOS");
		contentpane.add(bGuardarCambios);
		lDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDni.setBounds(221, 73, 34, 26);
		
		contentpane.add(lDni);
		
		contentpane.add(tDni);
		lEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lEmail.setBounds(459, 73, 50, 26);
		
		contentpane.add(lEmail);
		
		contentpane.add(tEmail);
		bCancelarReserva.setText("CANCELAR RESERVA");
		bCancelarReserva.setForeground(Color.WHITE);
		bCancelarReserva.setBackground(new Color(0, 102, 204));
		bCancelarReserva.setBounds(489, 349, 200, 42);
		
		contentpane.add(bCancelarReserva);
		lCodigoReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lCodigoReserva.setBounds(221, 109, 135, 26);
		
		contentpane.add(lCodigoReserva);
		tCodigoReserva.setColumns(10);
		tCodigoReserva.setBounds(352, 115, 573, 19);
		
		contentpane.add(tCodigoReserva);
		lNumeroHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lNumeroHabitacion.setBounds(221, 145, 158, 26);
		
		contentpane.add(lNumeroHabitacion);
		lDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDia.setBounds(221, 187, 24, 26);
		
		contentpane.add(lDia);
		lCodigoReserva_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lCodigoReserva_1_1_1.setBounds(286, 187, 21, 26);
		
		contentpane.add(lCodigoReserva_1_1_1);
		lCodigoReserva_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lCodigoReserva_1_1_2.setBounds(352, 187, 21, 26);
		
		contentpane.add(lCodigoReserva_1_1_2);
		tCogidoHabitacion.setColumns(10);
		tCogidoHabitacion.setBounds(374, 151, 551, 19);
		
		contentpane.add(tCogidoHabitacion);
		tDia.setColumns(10);
		tDia.setBounds(242, 193, 34, 19);
		
		contentpane.add(tDia);
		tMes.setColumns(10);
		tMes.setBounds(308, 193, 34, 19);
		
		contentpane.add(tMes);
		tAnyo.setColumns(10);
		tAnyo.setBounds(373, 193, 59, 19);
		
		contentpane.add(tAnyo);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(127, 23, 107, 26);
		
		contentpane.add(lblNewLabel);

		Cliente c = controller.getUsuario(reserva.getEmailUsuario());
		tDni.setText(c.getDNI());
		tEmail.setText(reserva.getEmailUsuario());
		tCodigoReserva.setText(reserva.getCodigoReserva());
		tCogidoHabitacion.setText(reserva.getCodigoHabitacion());
		tDia.setText(Integer.toString(reserva.getDia()));
		tMes.setText(Integer.toString(reserva.getMes()));
		tAnyo.setText(Integer.toString(reserva.getAnyo()));
		
		
		bAtras.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaReservasAdmin ventanaAdmin;
				try {
					ventanaAdmin = new VentanaReservasAdmin(controller);
					ventanaAdmin.setVisible(true);
					VentanaMostrarReservas.this.dispose();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
					
				}
			});
		
		bCancelarReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r = tCodigoReserva.getText();
				System.out.println(r);
				Reserva reserva = controller.getReserva(r);
				System.out.println(r);
				Response ban = controller.borrarReserva(reserva);
				
				VentanaAdmin ventanaAdmin;
				try {
					ventanaAdmin = new VentanaAdmin(controller);
					ventanaAdmin.setVisible(true);
					VentanaMostrarReservas.this.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				JOptionPane.showMessageDialog(null, "Reserva cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
		bGuardarCambios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaUsuariosAdmin usuarios;
				try {		

				} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			});

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(1066, 600);
			this.setVisible(true);
			this.setTitle("Reservas");

	}
}
