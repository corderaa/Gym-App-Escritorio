package gymapp.view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gymapp.model.domain.User;
import gymapp.service.UserService;
import gymapp.utils.Constants;
import gymapp.utils.UserSession;

public class ProfilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private UserService userService = null;
	private JTextField textLogin;
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textEmail;
	private JTextField textBirthDate;
	private JTextField textPassword;
	private boolean isConfirmed = false;

	/**
	 * Create the panel.
	 */
	public ProfilePanel(List<JPanel> panels) {
		this.setVisible(false);
		this.setBounds(0, 0, 1114, 599);
		this.setLayout(null);

		JLabel lblProfileTitle = new JLabel("Perfil");
		lblProfileTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfileTitle.setFont(new Font("SansSerif", Font.PLAIN, 39));
		lblProfileTitle.setBounds(389, 61, 352, 85);
		add(lblProfileTitle);

		JButton btnModify = new JButton("Modificar");
		btnModify.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnModify.setBackground(new Color(70, 145, 120));
		btnModify.setForeground(new Color(0, 0, 0));
		btnModify.setBounds(389, 432, 352, 39);
		add(btnModify);

		JButton btnReturn = new JButton("Volver");
		btnReturn.setForeground(new Color(255, 255, 255));
		btnReturn.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnReturn.setBackground(new Color(74, 74, 74));
		btnReturn.setBounds(435, 513, 259, 30);
		add(btnReturn);

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
		textLogin.setEditable(false);
		textLogin.setColumns(10);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(10, 100, 313, 28);
		textName.setEditable(false);
		scrollPanel.add(textName);

		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(10, 75, 120, 14);
		scrollPanel.add(lblName);

		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setEditable(false);
		textLastName.setBounds(10, 164, 313, 28);
		scrollPanel.add(textLastName);

		JLabel lblLastName = new JLabel("Apellidos");
		lblLastName.setBounds(10, 139, 120, 14);
		scrollPanel.add(lblLastName);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setEditable(false);
		textEmail.setBounds(10, 228, 313, 28);
		scrollPanel.add(textEmail);

		JLabel lblEmail = new JLabel("Correo electronico");
		lblEmail.setBounds(10, 203, 120, 14);
		scrollPanel.add(lblEmail);

		textBirthDate = new JTextField();
		textBirthDate.setColumns(10);
		textBirthDate.setEditable(false);
		textBirthDate.setBounds(10, 292, 313, 28);
		scrollPanel.add(textBirthDate);

		JLabel lblBirthDate = new JLabel("Fecha de nacimiento (YYYY/MM/DD)");
		lblBirthDate.setBounds(10, 267, 120, 14);
		scrollPanel.add(lblBirthDate);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setEditable(false);
		textPassword.setBounds(10, 356, 313, 28);
		scrollPanel.add(textPassword);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(10, 331, 120, 14);
		scrollPanel.add(lblPassword);
		
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(Constants.WORKOUTS_PANEL_ID).setVisible(true);
				panels.get(Constants.PROFILE_PANEL_ID).setVisible(false);
			}
		});
		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isConfirmed) {
					btnModify.setText("Confirmar");
					textName.setEditable(true);
					textLastName.setEditable(true);
					textEmail.setEditable(true);
					textBirthDate.setEditable(true);
					textPassword.setEditable(true);
					isConfirmed = !isConfirmed;
				} else {
					try {

						userService = new UserService();

						if (areTextFieldsFilled()) {

							User modifiedUser = userService.createUser(textName.getText(), textLastName.getText(),
									textLogin.getText(), textEmail.getText(), textPassword.getText(),
									textBirthDate.getText());
								userService.upodate(modifiedUser);
								btnModify.setText("Modificar");
								textName.setEditable(false);
								textLastName.setEditable(false);
								textEmail.setEditable(false);
								textBirthDate.setEditable(false);
								textPassword.setEditable(false);
								isConfirmed = !isConfirmed;
						} else
							JOptionPane.showMessageDialog(null, "Error: Algun campo esta sin rellenar");
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, comprueba si la fecha tiene el formato correcto");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
					}
				}
			}
		});
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				try {
					User userInfo = UserSession.getInstance().getUser();
					textLogin.setText(userInfo.getLogin());
					textName.setText(userInfo.getName());
					textLastName.setText(userInfo.getLastName());
					textEmail.setText(userInfo.getMail());
					textBirthDate.setText(userInfo.getBirthDate().toString());
					textPassword.setText(userInfo.getPassword());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error, no hay workouts");
				}

			}
		});
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
