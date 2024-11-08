package gymapp.view.panels;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExercisesPanel extends JPanel {

	private JTable tableExercises;
	private DefaultTableModel exercisesModel;
	private JScrollPane scrollPaneeExercises;
	private static final long serialVersionUID = 1L;

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
		lblWorkout.setBounds(178, 163, 133, 25);
		lblWorkout.setForeground(new Color(70, 145, 120));
		add(lblWorkout);
		
		JButton btnStop = new JButton("PARAR");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		JLabel lblNewLabel_1_2 = new JLabel("00.00.00");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(178, 205, 133, 31);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("00.00.00");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_1.setBounds(489, 204, 133, 31);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("00.00.00");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_2.setBounds(800, 205, 133, 31);
		add(lblNewLabel_1_2_2);
		
		JLabel lblSeries = new JLabel("SERIES");
		lblSeries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeries.setForeground(new Color(70, 145, 120));
		lblSeries.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSeries.setBounds(489, 163, 133, 25);
		add(lblSeries);
		
		JLabel lblExercises = new JLabel("EJERCICIO");
		lblExercises.setHorizontalAlignment(SwingConstants.CENTER);
		lblExercises.setForeground(new Color(70, 145, 120));
		lblExercises.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblExercises.setBounds(800, 163, 133, 25);
		add(lblExercises);
		
	}
}
