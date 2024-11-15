package gymapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadProcess {

	public static void main(String args[]) {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new FileInputStream(new File(Constants.EXERCISE_BACKUP_FILE_NAME)));

			System.out.print(objectInputStream.readObject());

			objectInputStream.close();
		} catch (Exception e) {
			// T
		}
	}
}
