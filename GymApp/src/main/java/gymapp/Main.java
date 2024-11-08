package gymapp;

import java.io.IOException;

import gymapp.utils.CheckConectivity;
import gymapp.view.MainFrame;

public class Main {

	public static void main(String[] args) {
		CheckConectivity checkConectivity = new CheckConectivity();
		try {
			checkConectivity.checkConnection();
		} catch (IOException e) {
			// Iniciar proceso de backup
			e.printStackTrace();
		}
		new MainFrame().run();
	}

}
