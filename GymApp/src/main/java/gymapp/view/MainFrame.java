package gymapp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gymapp.view.panels.LoginPanel;
import gymapp.view.panels.RegisterPanel;
import gymapp.view.panels.WorkoutsPanel;

import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<JPanel> panels = null;

	public void run() {
		try {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor of the Main Frame
	 */
	public MainFrame() {
		panels = new ArrayList<JPanel>();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 1130, 638);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 638);
		contentPane.setLayout(null);

		LoginPanel loginPanel = new LoginPanel(panels);
		loginPanel.setBounds(0, 0, 1114, 599);
		panels.add(loginPanel);
		contentPane.add(loginPanel);

		RegisterPanel registerPanel = new RegisterPanel(panels);
		registerPanel.setBounds(0, 0, 1114, 599);
		panels.add(registerPanel);
		contentPane.add(registerPanel);
		
		WorkoutsPanel workoutsPanel = new WorkoutsPanel(panels);
		workoutsPanel.setBounds(0, 0, 1114, 599);
		panels.add(workoutsPanel);
		contentPane.add(workoutsPanel);
		workoutsPanel.setVisible(false);

	}

}
