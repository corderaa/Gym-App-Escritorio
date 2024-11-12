package gymapp.utils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class CheckConectivity {

	public void checkConnection() throws IOException {
		URL url = new URL("http://www.google.com");
		URLConnection connection = url.openConnection();
		connection.connect();
	}
}
