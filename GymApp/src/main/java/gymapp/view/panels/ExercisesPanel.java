package gymapp.view.panels;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import gymapp.utils.Constants;
import gymapp.utils.UserSession;
import gymapp.utils.thread.Cronometer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

public class ExercisesPanel extends JPanel {

	private JTable tableExercises;
	private DefaultTableModel exercisesModel;
	private JScrollPane scrollPaneeExercises;
	private JLabel lblTimerExercise;
	private JLabel lblTimerWorkout;
	private Cronometer workoutThread;
	private Cronometer exerciseThread;
	private static final long serialVersionUID = 1L;
	boolean isWorkingOut = false;
	boolean isStarted = false;

	/**
	 * Create the panel.
	 */
	public ExercisesPanel(List<JPanel> panels) {

		this.setVisible(true);
		this.setBounds(0, 0, 1114, 599);
		setLayout(null);

		JLabel lblWorkoutsName = new JLabel("WORKOUTS");
		lblWorkoutsName.setForeground(new Color(70, 145, 120));
		lblWorkoutsName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkoutsName.setFont(new Font("SansSerif", Font.BOLD, 39));
		lblWorkoutsName.setBounds(172, 45, 769, 85);
		add(lblWorkoutsName);

		scrollPaneeExercises = new JScrollPane();
		scrollPaneeExercises.setBounds(68, 264, 981, 158);
		add(scrollPaneeExercises);

		exercisesModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableExercises = new JTable(exercisesModel);
		exercisesModel.addColumn("Nombre");
		exercisesModel.addColumn("Series");
		exercisesModel.addColumn("Descripcion");
		exercisesModel.addColumn("Descanso");
		scrollPaneeExercises.setViewportView(tableExercises);

		JLabel lblWorkout = new JLabel("WORKOUT");
		lblWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkout.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWorkout.setBounds(116, 163, 133, 25);
		lblWorkout.setForeground(new Color(70, 145, 120));
		add(lblWorkout);

		JButton btnStop = new JButton("INICIAR");
		btnStop.setFont(new Font("Dialog", Font.BOLD, 20));
		btnStop.setForeground(new Color(255, 255, 255));
		btnStop.setBounds(359, 452, 147, 84);
		btnStop.setBackground(new Color(70, 145, 120));
		add(btnStop);

		JButton btnPause = new JButton("PAUSAR");
		btnPause.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPause.setForeground(new Color(255, 255, 255));
		btnPause.setBounds(615, 452, 147, 84);
		btnPause.setBackground(new Color(70, 145, 120));
		add(btnPause);

		JButton btnReturn = new JButton("Volver");

		btnReturn.setForeground(Color.WHITE);
		btnReturn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnReturn.setBackground(new Color(70, 145, 120));
		btnReturn.setBounds(901, 45, 148, 39);
		add(btnReturn);

		lblTimerWorkout = new JLabel("00.00.00");
		lblTimerWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerWorkout.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTimerWorkout.setBounds(116, 205, 133, 31);
		add(lblTimerWorkout);

		JLabel lblTimerSeries = new JLabel("00.00.00");
		lblTimerSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerSeries.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTimerSeries.setBounds(365, 204, 133, 31);
		add(lblTimerSeries);

		lblTimerExercise = new JLabel("00.00.00");
		lblTimerExercise.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerExercise.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTimerExercise.setBounds(614, 205, 133, 31);
		add(lblTimerExercise);

		JLabel lblSeries = new JLabel("SERIES");
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setForeground(new Color(70, 145, 120));
		lblSeries.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSeries.setBounds(365, 163, 133, 25);
		add(lblSeries);

		JLabel lblExercises = new JLabel("EJERCICIO");
		lblExercises.setHorizontalAlignment(SwingConstants.CENTER);
		lblExercises.setForeground(new Color(70, 145, 120));
		lblExercises.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblExercises.setBounds(614, 163, 133, 25);
		add(lblExercises);

		JLabel lblDescanso = new JLabel("DESCANSO");
		lblDescanso.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescanso.setForeground(new Color(70, 145, 120));
		lblDescanso.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescanso.setBounds(863, 163, 133, 25);
		add(lblDescanso);

		JLabel lblTimerRest = new JLabel("00.00.00");
		lblTimerRest.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerRest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTimerRest.setBounds(863, 205, 133, 31);
		add(lblTimerRest);

		workoutThread = new Cronometer(false, 0, lblTimerWorkout);
		exerciseThread = new Cronometer(false, 0, lblTimerExercise);

		btnStop.addActionListener(new ActionListener() {
			@SuppressWarnings("removal")
			public void actionPerformed(ActionEvent e) {

				if (isWorkingOut) {

					btnStop.setText("INICIAR");

					exerciseThread.setFlag(false);
					workoutThread.setFlag(false);
					isWorkingOut = false;
				} else {
					btnStop.setText("PARAR");
					btnPause.setText("PAUSAR");
					isWorkingOut = true;
					isStarted = true;
					if (workoutThread.isAlive() && exerciseThread.isAlive()) {
						exerciseThread.stop();
						workoutThread.stop();
					}
					exerciseThread = new Cronometer(false, 0, lblTimerExercise);
					workoutThread = new Cronometer(false, 0, lblTimerWorkout);
					exerciseThread.start();
					workoutThread.start();
				}

			}
		});

		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!isStarted) {
					JOptionPane.showMessageDialog(null, "Inicia el cronometro");
				}
				if (isWorkingOut) {
					btnPause.setText("REANUDAR");
					btnStop.setText("INICIAR");
					exerciseThread.setFlag(false);
					workoutThread.setFlag(false);
					isWorkingOut = false;
				} else {
					btnPause.setText("PAUSAR");
					btnStop.setText("PARAR");
					exerciseThread.setFlag(true);
					workoutThread.setFlag(true);
					isWorkingOut = true;
				}
			}
		});

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {

				try {
					exercisesModel.setRowCount(0);
					displaySelectedExerciseOnTable();
					lblWorkoutsName.setText(UserSession.getInstance().getSelectedWorkout().getName());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error");
				}

			}
		});

		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (workoutThread.isAlive() && exerciseThread.isAlive()) {
					exerciseThread.interrupt();
					workoutThread.interrupt();
				}
				lblTimerExercise.setText("00.00.00");
				lblTimerWorkout.setText("00.00.00");
				exercisesModel.setRowCount(0);

				panels.get(Constants.EXERCISES_PANEL_ID).setVisible(false);
				panels.get(Constants.WORKOUTS_PANEL_ID).setVisible(true);

			}
		});

	}

	private void displaySelectedExerciseOnTable() throws Exception {

		Object[] row = { UserSession.getInstance().getSelectedExecise().getName(),
				UserSession.getInstance().getSelectedExecise().getSeries(),
				UserSession.getInstance().getSelectedExecise().getDescription(),
				UserSession.getInstance().getSelectedExecise().getRest() };

		exercisesModel.addRow(row);
	}

}
