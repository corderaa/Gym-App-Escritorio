package gymapp.model.resource;

import java.io.IOException;

import com.google.cloud.firestore.Firestore;
import gymapp.model.Firebase;

public class ExerciseResource {

	private Firestore db = null;

	public ExerciseResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
	}
}
