package gymapp.view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gymapp.model.domain.User;
import gymapp.service.UserService;
import gymapp.utils.Constants;

import javax.swing.JScrollPane;

public class RegisterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private UserService userService = null;
	private JTextField textLogin;
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textEmail;
	private JTextField textBirthDate;
	private JTextField textPassword;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public RegisterPanel(List<JPanel> panels) {
		this.setVisible(false);
		this.setBounds(0, 0, 1114, 599);
		this.setLayout(null);

		JLabel lblRegisterTitle = new JLabel("Registrarse");
		lblRegisterTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterTitle.setFont(new Font("SansSerif", Font.PLAIN, 39));
		lblRegisterTitle.setBounds(389, 61, 352, 85);
		add(lblRegisterTitle);

		JButton btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnRegister.setBackground(new Color(70, 145, 120));
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setBounds(389, 432, 352, 39);
		add(btnRegister);

		JButton btnLogin = new JButton("Iniciar sesion");

		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(74, 74, 74));
		btnLogin.setBounds(435, 513, 259, 30);
		add(btnLogin);

		JLabel lblNewLabel = new JLabel(" ¿Ya tienes cuenta? Inicia sesion aqui");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(389, 486, 352, 14);
		add(lblNewLabel);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Recuerdame");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxNewCheckBox.setForeground(new Color(58, 126, 98));
		chckbxNewCheckBox.setBounds(389, 387, 97, 23);
		add(chckbxNewCheckBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(389, 157, 352, 223);
		add(scrollPane);

		JPanel scrollPanel = new JPanel();
		scrollPanel.setPreferredSize(new Dimension(223, 400));
		scrollPanel.setLayout(null);
		scrollPane.setViewportView(scrollPanel);

		JLabel lblLogin = new JLabel("Nombre de usuario");
		lblLogin.setBounds(10, 11, 120, 14);
		scrollPanel.add(lblLogin);

		textLogin = new JTextField();
		textLogin.setBounds(10, 36, 313, 28);
		scrollPanel.add(textLogin);
		textLogin.setColumns(10);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(10, 100, 313, 28);
		scrollPanel.add(textName);

		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(10, 75, 120, 14);
		scrollPanel.add(lblName);

		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(10, 164, 313, 28);
		scrollPanel.add(textLastName);

		JLabel lblLastName = new JLabel("Apellidos");
		lblLastName.setBounds(10, 139, 120, 14);
		scrollPanel.add(lblLastName);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(10, 228, 313, 28);
		scrollPanel.add(textEmail);

		JLabel lblEmail = new JLabel("Correo electronico");
		lblEmail.setBounds(10, 203, 120, 14);
		scrollPanel.add(lblEmail);

		textBirthDate = new JTextField();
		textBirthDate.setColumns(10);
		textBirthDate.setBounds(10, 292, 313, 28);
		scrollPanel.add(textBirthDate);

		JLabel lblBirthDate = new JLabel("Fecha de nacimiento (YYYY/MM/DD)");
		lblBirthDate.setBounds(10, 267, 120, 14);
		scrollPanel.add(lblBirthDate);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(10, 356, 313, 28);
		scrollPanel.add(textPassword);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(10, 331, 120, 14);
		scrollPanel.add(lblPassword);

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					userService = new UserService();

					if (areTextFieldsFilled()) {

						User newUser = userService.createUser(textName.getText(), textLastName.getText(),
								textLogin.getText(), textEmail.getText(), textPassword.getText(),
								textBirthDate.getText());
						if (!userService.isUserPresent(newUser)) {
							userService.save(newUser);
							JOptionPane.showMessageDialog(null, "Usuario registrado con exito!!!");
							changePanel(Constants.LOGIN_PANEL_ID, panels);
						} else
							JOptionPane.showMessageDialog(null, "Error: El usuario ya existe");
					} else
						JOptionPane.showMessageDialog(null, "Error: Algun campo esta sin rellenar");
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Porfavor, comprueba si la fecha tiene el formato correcto");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
				}
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(Constants.LOGIN_PANEL_ID, panels);
			}
		});
	}

	private void changePanel(int panelNumber, List<JPanel> panels) {
		panels.get(panelNumber).setVisible(true);
		panels.get(Constants.REGISTER_PANEL_ID).setVisible(false);
	}

	private boolean areTextFieldsFilled() {
		if (!textBirthDate.getText().isBlank() || !textBirthDate.getText().isEmpty() || !textLogin.getText().isBlank()
				|| !textLogin.getText().isEmpty() || !textName.getText().isBlank() || !textName.getText().isEmpty()
				|| !textLastName.getText().isBlank() || !textLastName.getText().isEmpty()
				|| !textEmail.getText().isBlank() || !textEmail.getText().isEmpty() || !textPassword.getText().isBlank()
				|| !textPassword.getText().isEmpty()) {
			return true;
		}
		return false;
	}
}
