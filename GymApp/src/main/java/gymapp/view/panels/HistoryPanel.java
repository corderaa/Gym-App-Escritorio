package gymapp.view.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import gymapp.model.domain.User;

public class HistoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPaneHistory;
	private DefaultTableModel historyModel;
	private JTable tableWorkouts;

	/**
	 * Create the panel.
	 */
	public HistoryPanel(List<JPanel> panels, User user) {
		this.setVisible(true);
		this.setBounds(0, 0, 1114, 599);
		setLayout(null);
		
		JLabel lblHistoryTitle = new JLabel("HISTORICO");
		lblHistoryTitle.setForeground(new Color(70, 145, 120));
		lblHistoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoryTitle.setFont(new Font("SansSerif", Font.BOLD, 39));
		lblHistoryTitle.setBounds(381, 45, 352, 85);
		add(lblHistoryTitle);
		
		scrollPaneHistory = new JScrollPane();
		scrollPaneHistory.setBounds(66, 125, 981, 158);
		add(scrollPaneHistory);

		historyModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableWorkouts = new JTable(historyModel);
		historyModel.addColumn("Nombre");
		historyModel.addColumn("Nivel");
		historyModel.addColumn("Descripcion");
		historyModel.addColumn("Video");
		historyModel.addColumn("Numero de ejercicios");
		scrollPaneHistory.setViewportView(tableWorkouts);

	}

}
