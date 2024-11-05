package gymapp.view.panels;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import gymapp.model.domain.User;
import gymapp.service.UserService;
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

		JCheckBox chckbxNewCheckBox = new JCheckBox("Recuerdame");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxNewCheckBox.setForeground(new Color(58, 126, 98));
		chckbxNewCheckBox.setBounds(389, 387, 97, 23);
		add(chckbxNewCheckBox);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					userService = new UserService();
					User user = new User();
					user.setLogin(textUserName.getText());
					user.setPassword(textPassword.getText());

					if (userService.checkCredentials(user)) {

						UserSession.getInstance().setUser(userService.find(user));
						changePanel(Constants.WORKOUTS_PANEL_ID, panels);
						JOptionPane.showMessageDialog(null, "is correct"); // TODO: BORRAR PARA CAMBIAR DE PANEL

					} else {
						JOptionPane.showMessageDialog(null, "ERROR: Algun campo esta mal introducido");
					}
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "ERROR: " + e2.getMessage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
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
