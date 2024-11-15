package gymapp.view.panels;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import gymapp.model.domain.User;
import gymapp.service.ExerciseService;
import gymapp.service.UserService;
import gymapp.service.WorkoutService;
import gymapp.utils.Backup;
import gymapp.utils.CheckConectivity;
import gymapp.utils.Constants;
import gymapp.utils.UserSession;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private UserService userService = null;
	private WorkoutService workoutService = null;
	private JTextField textUserName;
	private JTextField textPassword;

	/**
	 * Create the panel.
	 */
	public LoginPanel(List<JPanel> panels) {
		this.setVisible(true);
		this.setBounds(0, 0, 1114, 599);
		this.setLayout(null);

		JLabel lblLoginTitle = new JLabel("Iniciar sesion");
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginTitle.setFont(new Font("SansSerif", Font.PLAIN, 39));
		lblLoginTitle.setBounds(389, 61, 352, 85);
		add(lblLoginTitle);

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblUser.setBounds(389, 185, 100, 23);
		add(lblUser);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblPassword.setBounds(389, 292, 100, 23);
		add(lblPassword);

		textUserName = new JTextField();
		textUserName.setBounds(389, 219, 352, 39);
		add(textUserName);
		textUserName.setColumns(10);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(389, 326, 352, 39);
		add(textPassword);

		JButton btnLogin = new JButton("Iniciar sesion");
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(70, 145, 120));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(389, 432, 352, 39);
		add(btnLogin);

		JButton btnRegister = new JButton("Registrate");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnRegister.setBackground(new Color(74, 74, 74));
		btnRegister.setBounds(435, 513, 259, 30);
		add(btnRegister);

		JLabel lblNewLabel = new JLabel("¿No tienes cuenta? Registrate aqui");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(389, 486, 352, 14);
		add(lblNewLabel);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User user = new User();
					user.setLogin(textUserName.getText());
					user.setPassword(textPassword.getText());

					if (CheckConectivity.hasConectivity()) {
						userService = new UserService();
						workoutService = new WorkoutService();
						if (userService.checkCredentials(user)) {

							UserSession.getInstance().setUser(userService.find(user));
							Backup.getInstance().setUser(userService.find(user));
							Backup.getInstance().backupWorkouts(workoutService.findAll());

							changePanel(Constants.WORKOUTS_PANEL_ID, panels);
							JOptionPane.showMessageDialog(null, "iniciado sesion correctamente"); // TODO: BORRAR PARA
																									// CAMBIAR DE PANEL

						} else {
							UserSession.getInstance().setUser(Backup.getInstance().getUser());
							JOptionPane.showMessageDialog(null, "ERROR: Algun campo esta mal introducido");
						}
					} else {

						changePanel(Constants.WORKOUTS_PANEL_ID, panels);
						JOptionPane.showMessageDialog(null, "is correct"); // TODO: BORRAR PARA CAMBIAR DE PANEL
					}

				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
					e2.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				changePanel(Constants.REGISTER_PANEL_ID, panels);
			}
		});
	}

	private void changePanel(int panelNumber, List<JPanel> panels) {
		panels.get(panelNumber).setVisible(true);
		panels.get(Constants.LOGIN_PANEL_ID).setVisible(false);
		;
	}
}
