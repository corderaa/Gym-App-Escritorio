package gymapp.utils;

import java.net.URL;
import java.net.URLConnection;

public class CheckConectivity {

	public static boolean hasConectivity() {
		try {
			URL url = new URL("http://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
