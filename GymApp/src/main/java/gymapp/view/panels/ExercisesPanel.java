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

import gymapp.model.domain.Exercise;
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
	private Cronometer serieThread;
	private Cronometer countDown;
	private static final long serialVersionUID = 1L;
	boolean isWorkingOut = false;
	boolean isStarted = false;
	boolean isCountdownStarted = false;
	private int currentExercise = 0;
	private JLabel lblWorkoutText;
	private JLabel lblCountDown;
	private JLabel lblCountDownText;
	private JLabel lblTimerSeries;

	/**
	 * Create the panel.
	 */
	public ExercisesPanel(List<JPanel> panels) {

		this.setVisible(true);
		this.setBounds(0, 0, 1114, 599);
		setLayout(null);

		lblWorkoutText = new JLabel("WORKOUTS");
		lblWorkoutText.setForeground(new Color(70, 145, 120));
		lblWorkoutText.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkoutText.setFont(new Font("SansSerif", Font.BOLD, 39));
		lblWorkoutText.setBounds(172, 45, 769, 85);
		add(lblWorkoutText);

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
		btnStop.setBounds(105, 452, 147, 84);
		btnStop.setBackground(new Color(70, 145, 120));
		add(btnStop);

		JButton btnPause = new JButton("PAUSAR");
		btnPause.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPause.setForeground(new Color(255, 255, 255));
		btnPause.setBounds(357, 452, 147, 84);
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

		lblTimerSeries = new JLabel("00.00.00");
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

		JButton btnNext = new JButton("SIGUIENTE");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNext.setBackground(new Color(70, 145, 120));
		btnNext.setBounds(861, 452, 147, 84);
		add(btnNext);

		JButton btnStartSerie = new JButton("SERIE");
		btnStartSerie.setForeground(Color.WHITE);
		btnStartSerie.setFont(new Font("Dialog", Font.BOLD, 20));
		btnStartSerie.setBackground(new Color(70, 145, 120));
		btnStartSerie.setBounds(609, 452, 147, 84);
		add(btnStartSerie);

		lblCountDownText = new JLabel("INICIAR EN");
		lblCountDownText.setVisible(false);
		lblCountDownText.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountDownText.setForeground(new Color(70, 145, 120));
		lblCountDownText.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCountDownText.setBounds(116, 45, 133, 25);
		add(lblCountDownText);

		lblCountDown = new JLabel("00:00:05");
		lblCountDown.setVisible(false);
		lblCountDown.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountDown.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCountDown.setBounds(116, 82, 133, 31);
		add(lblCountDown);

		workoutThread = new Cronometer(false, 0, lblTimerWorkout, null, null);
		exerciseThread = new Cronometer(false, 0, lblTimerExercise, null, null);
		serieThread = new Cronometer(isCountdownStarted, -5, lblTimerSeries, null, null);
		countDown = new Cronometer(true, 5, lblCountDown, lblCountDownText, "CountDown");

		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isWorkingOut) {

					btnStop.setText("INICIAR");

					exerciseThread.setFlag(false);
					workoutThread.setFlag(false);
					serieThread.setFlag(false);
					isWorkingOut = false;
				} else {
					btnStop.setText("PARAR");
					btnPause.setText("PAUSAR");
					isWorkingOut = true;
					isStarted = true;
					lblTimerSeries.setText("00.00.00");
					if (workoutThread.isAlive() && exerciseThread.isAlive() && serieThread.isAlive()) {
						exerciseThread.interrupt();
						workoutThread.interrupt();
						serieThread.interrupt();
					}
					exerciseThread = new Cronometer(false, 0, lblTimerExercise, null, null);
					workoutThread = new Cronometer(false, 0, lblTimerWorkout, null, null);
					exerciseThread.start();
					workoutThread.start();
					isCountdownStarted = !isCountdownStarted;
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
					serieThread.setFlag(false);
					isWorkingOut = false;
				} else {
					btnPause.setText("PAUSAR");
					btnStop.setText("PARAR");
					exerciseThread.setFlag(true);
					workoutThread.setFlag(true);
					isWorkingOut = true;
					serieThread.setFlag(true);
				}
			}
		});

		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {

				try {
					exercisesModel.setRowCount(0);
					currentExercise = UserSession.getInstance().getSelectedExerciseId();
					displaySelectedExerciseOnTable(currentExercise);
					lblWorkoutText.setText(UserSession.getInstance().getSelectedWorkout().getName());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error");
				}

			}
		});

		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (workoutThread.isAlive() && exerciseThread.isAlive() && serieThread.isAlive()) {
					exerciseThread.interrupt();
					workoutThread.interrupt();
					serieThread.interrupt();
				}
				lblTimerExercise.setText("00.00.00");
				lblTimerWorkout.setText("00.00.00");
				lblTimerSeries.setText("00.00.00");

				panels.get(Constants.EXERCISES_PANEL_ID).setVisible(false);
				panels.get(Constants.WORKOUTS_PANEL_ID).setVisible(true);

			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				currentExercise++;
				if (currentExercise < UserSession.getInstance().getSelectedWorkout().getExercises().size()) {
					try {
						exercisesModel.setRowCount(0);
						displaySelectedExerciseOnTable(currentExercise);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					exerciseThread.interrupt();
					serieThread.interrupt();
					countDown.interrupt();
					lblTimerExercise.setText("00.00.00");
					lblTimerSeries.setText("00.00.00");
					exerciseThread = new Cronometer(false, 0, lblTimerExercise, null, null);
					exerciseThread.start();
					isCountdownStarted = true;
				} else {
					JOptionPane.showMessageDialog(null, "No hay mas ejercicios");
				}

			}
		});

		btnStartSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isCountdownStarted) {
					countDown = new Cronometer(true, 5, lblCountDown, lblCountDownText, "CountDown");
					countDown.start();
					lblCountDownText.setVisible(true);
					lblCountDown.setVisible(true);
					isCountdownStarted = !isCountdownStarted;
					serieThread = new Cronometer(isCountdownStarted, -5, lblTimerSeries, null, null);
					serieThread.start();
				}
			}
		});

	}

	private void displaySelectedExerciseOnTable(int exerciseSelected) throws Exception {

		Exercise selectedExercise = UserSession.getInstance().getSelectedWorkout().getExercises().get(exerciseSelected);

		Object[] row = { selectedExercise.getName(), selectedExercise.getSeries(), selectedExercise.getDescription(),
				selectedExercise.getRest() };

		exercisesModel.addRow(row);
	}
}
