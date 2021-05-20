package es.deusto.spq.client.gui;

import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import es.deusto.spq.client.Controller;
import es.deusto.spq.client.RWException;


public class VentanaEstadisticas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane sp;

	private String[] columns = { "Code", "Info" };
	private Object[][] data = null;

	public VentanaEstadisticas(Controller controller) {

		this.setTitle("VentanaEstadisticas");
		this.setSize(600, 300);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// JLabel superior titulo
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Estadisticas");
		lblTitulo.setBounds(250, 40, 100, 20);
		getContentPane().add(lblTitulo);

		// tabla
		try {
			data = new Object[es.deusto.spq.client.EstadisticaFeedback.ReadAndLoad().size()][2];
			for (int i = 0; i < es.deusto.spq.client.EstadisticaFeedback.ReadAndLoad().size(); i++) {
				// primeras 2 filas (0 y 1)
				if (i == 0) {
					data[i][1] = String.format("%.2f", es.deusto.spq.client.EstadisticaFeedback.ReadAndLoad().get(i + 1)) + " /5";
					// fila n 2
				} else if ((i >= 1) && (i <= 2)) {
					data[i][1] = String.format("%.2f", es.deusto.spq.client.EstadisticaFeedback.ReadAndLoad().get(i + 1)) + " %";
				} else if (i == 3) {
					// fila n 3
					data[i][1] = String.format("%.0f", es.deusto.spq.client.EstadisticaFeedback.ReadAndLoad().get(i + 1));
				} else {
					// por ahora las demas
					data[i][1] = String.format("%.2f", es.deusto.spq.client.EstadisticaFeedback.ReadAndLoad().get(i + 1));
				}
				// Las filas, a mano 
				data[0][0] = "Valoracion sobre 5:";
				data[1][0] = "Recomendarias? Si:";
				data[2][0] = "Recomendarias? No:";
				data[3][0] = "Numero de feedbacks:";
			}
			for (int z = 0; z < data.length; z++) {
				for (int y = 0; y < columns.length; y++) {
					
				}
			}
		} catch (RWException e) {
			es.deusto.spq.server.Main.loggerGeneral.log(Level.INFO, e.toString());
			e.printStackTrace();
		}

		table = new JTable(data, columns) { 

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};

		table.setCellSelectionEnabled(true);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		sp = new JScrollPane(table);
		sp.setBounds(100, 85, 400, 100);
		getContentPane().add(sp);
		// hasta aqui tabla

	}
}