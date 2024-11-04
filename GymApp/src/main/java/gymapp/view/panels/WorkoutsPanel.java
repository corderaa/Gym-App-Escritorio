package gymapp.view.panels;

import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WorkoutsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableWorkouts;
	private JTable tableExercises;
	private JScrollPane scrollPaneWorkouts;
	private JScrollPane scrollPaneExercicesDetails;
	private DefaultTableModel workoutsModel;
	private DefaultTableModel exerciseModel;
	private JTextField textFieldLevel;

	/**
	 * Create the panel.
	 */
	public WorkoutsPanel(List<JPanel> panels) {

		this.setVisible(true);
		this.setBounds(0, 0, 1114, 599);
		setLayout(null);
		
		JLabel lblWorkoutsTitle = new JLabel("WORKOUTS");
		lblWorkoutsTitle.setForeground(new Color(70, 145, 120));
		lblWorkoutsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkoutsTitle.setFont(new Font("SansSerif", Font.BOLD, 39));
		lblWorkoutsTitle.setBounds(381, 45, 352, 85);
		add(lblWorkoutsTitle);
		
		/**
		 * First table
		 */
		
		scrollPaneWorkouts = new JScrollPane();
		scrollPaneWorkouts.setBounds(66, 125, 981, 158);
		add(scrollPaneWorkouts);
		
		workoutsModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableWorkouts = new JTable(workoutsModel);
		workoutsModel.addColumn("Nombre");
		workoutsModel.addColumn("Series");
		workoutsModel.addColumn("Descripcion");
		workoutsModel.addColumn("Descanso");
		scrollPaneWorkouts.setViewportView(tableWorkouts);
		
		/**
		 * Second table
		 */
		
		scrollPaneExercicesDetails = new JScrollPane();
		scrollPaneExercicesDetails.setBounds(66, 295, 981, 98);
		add(scrollPaneExercicesDetails);
		
		exerciseModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableExercises = new JTable(exerciseModel);
		exerciseModel.addColumn("Nombre");
		exerciseModel.addColumn("Numero de ejercicios");
		exerciseModel.addColumn("Nivel");
		exerciseModel.addColumn("Video");
		scrollPaneExercicesDetails.setViewportView(tableExercises);
		
		JLabel lblNewLabel = new JLabel("Nivel:");
		lblNewLabel.setForeground(new Color(70, 145, 120));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(66, 89, 48, 14);
		add(lblNewLabel);
		
		textFieldLevel = new JTextField();
		textFieldLevel.setBounds(111, 88, 48, 20);
		add(textFieldLevel);
		textFieldLevel.setColumns(10);
		
		JButton btnHistory = new JButton("Historico");
		btnHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnHistory.setBackground(new Color(70, 145, 120));
		btnHistory.setForeground(new Color(255, 255, 255));
		btnHistory.setBounds(483, 432, 148, 39);
		add(btnHistory);


	}
}
