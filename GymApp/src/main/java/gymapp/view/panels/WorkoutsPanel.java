package gymapp.view.panels;

import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import gymapp.model.domain.User;
import gymapp.model.domain.Workout;
import gymapp.service.WorkoutService;
import gymapp.utils.Constants;
import gymapp.utils.UserSession;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

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
	public WorkoutsPanel(List<JPanel> panels, User user) {

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
		workoutsModel.addColumn("Nivel");
		workoutsModel.addColumn("Descripcion");
		workoutsModel.addColumn("Video");
		workoutsModel.addColumn("Numero de ejercicios");
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
		exerciseModel.addColumn("Series");
		exerciseModel.addColumn("Descripcion");
		exerciseModel.addColumn("Descanso");
		scrollPaneExercicesDetails.setViewportView(tableExercises);

		JLabel lblUserLevel = new JLabel("Nivel usuario:");
		lblUserLevel.setForeground(new Color(70, 145, 120));
		lblUserLevel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblUserLevel.setBounds(66, 89, 111, 14);
		add(lblUserLevel);

		textFieldLevel = new JTextField();
		textFieldLevel.setBounds(173, 88, 48, 20);
		textFieldLevel.setEditable(false);
		add(textFieldLevel);
		textFieldLevel.setColumns(10);

		JButton btnHistory = new JButton("Historico");
		btnHistory.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnHistory.setBackground(new Color(70, 145, 120));
		btnHistory.setForeground(new Color(255, 255, 255));
		btnHistory.setBounds(483, 432, 148, 39);
		add(btnHistory);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnInicio.setBackground(new Color(70, 145, 120));
		btnInicio.setBounds(899, 432, 148, 39);
		add(btnInicio);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnVolver.setBackground(new Color(70, 145, 120));
		btnVolver.setBounds(66, 432, 148, 39);
		add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(Constants.LOGIN_PANEL_ID).setVisible(true);
				panels.get(Constants.WORKOUTS_PANEL_ID).setVisible(false);
			}
		});

		tableWorkouts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});

		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Err, Selecciona un workout porfavor");
				}
			}
		});

		// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				try {
					workoutsModel.setRowCount(0);
					displayWorkoutsTable(workoutsModel);
					textFieldLevel.setText(String.valueOf(UserSession.getInstance().getUser().getLevel()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error, no hay workouts");
				}

			}
		});

	}

	private void displayWorkoutsTable(DefaultTableModel workoutsModel) throws Exception {

		WorkoutService workoutService = new WorkoutService();

		List<Workout> workoutList = workoutService.getfilteredWorkouts();

		if (null != workoutList) {
			for (int i = 0; i < workoutList.size(); i++) {
				if (workoutList.get(i) != null) {

					Object[] row = { workoutList.get(i).getName(), workoutList.get(i).getLevel(),
							workoutList.get(i).getDescription(), workoutList.get(i).getVideoURL(),
							workoutList.get(i).getExercises().size() };

					workoutsModel.addRow(row);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Err, No hay Workouts");
		}
	}

	private void displayExerciseTable(DefaultTableModel exerciseModel) {

		
		
		
	}
}
