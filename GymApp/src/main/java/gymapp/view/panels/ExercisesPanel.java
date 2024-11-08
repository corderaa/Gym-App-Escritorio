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
		
		JLabel lblWorkoutsTitle = new JLabel("WORKOUTS");
		lblWorkoutsTitle.setForeground(new Color(70, 145, 120));
		lblWorkoutsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkoutsTitle.setFont(new Font("SansSerif", Font.BOLD, 39));
		lblWorkoutsTitle.setBounds(381, 45, 352, 85);
		add(lblWorkoutsTitle);
		
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
		
		JLabel lblNewLabel = new JLabel("WORKOUT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(178, 163, 133, 25);
		lblNewLabel.setForeground(new Color(70, 145, 120));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("PARAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(359, 452, 147, 84);
		btnNewButton.setBackground(new Color(70, 145, 120));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PAUSAR");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(615, 452, 147, 84);
		btnNewButton_1.setBackground(new Color(70, 145, 120));
		add(btnNewButton_1);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("SERIES");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(70, 145, 120));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(489, 163, 133, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("EJERCICIO");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(70, 145, 120));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(800, 163, 133, 25);
		add(lblNewLabel_1_1);
		
	}
}
