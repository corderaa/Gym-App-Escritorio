package gymapp.view.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import gymapp.model.domain.History;
import gymapp.model.domain.User;
import gymapp.service.HistoryService;
import gymapp.utils.Constants;
import gymapp.utils.UserSession;

public class HistoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPaneHistory;
	private DefaultTableModel historyModel;
	private JTable tableWorkouts;
	private JTextField textFieldLevel;

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
		historyModel.addColumn("Tiempo");
		historyModel.addColumn("Tiempo estimado");
		historyModel.addColumn("Fecha");
		historyModel.addColumn("Video");
		historyModel.addColumn("Progreso");
		scrollPaneHistory.setViewportView(tableWorkouts);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnVolver.setBackground(new Color(70, 145, 120));
		btnVolver.setBounds(66, 432, 148, 39);
		add(btnVolver);
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				try {
					historyModel.setRowCount(0);
					displayHistoryTable(historyModel);
					textFieldLevel.setText(String.valueOf(UserSession.getInstance().getUser().getLevel()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error, no hay workouts");
				}

			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(Constants.WORKOUTS_PANEL_ID).setVisible(true);
				panels.get(Constants.HISTORY_PANEL_ID).setVisible(false);
				historyModel.setRowCount(0);
			}
		});

	}
	
	private void displayHistoryTable(DefaultTableModel historyModel) throws Exception {

		HistoryService historyService = new HistoryService();

		List<History> historyList = historyService.getfilteredHistory();

		if (historyList == null || historyList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Err, No hay Workouts");

		} else {
			for (int i = 0; i < historyList.size(); i++) {
				if (historyList.get(i) != null) {

					Object[] row = { historyList.get(i).getName(), historyList.get(i).getLevel(),
							historyList.get(i).getTime(), historyList.get(i).getEstimatedTime(), 
							historyList.get(i).getDate(), historyList.get(i).getVideoURL(), 
							historyList.get(i).getCompletionProgress()};

					historyModel.addRow(row);
				} else {
					JOptionPane.showMessageDialog(null, "Err, No hay ejercicios");
				}
				
			}
		}

	}

}
