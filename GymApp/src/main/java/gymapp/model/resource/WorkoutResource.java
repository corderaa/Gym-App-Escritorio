package gymapp.model.resource;

import java.io.IOException;

import com.google.cloud.firestore.Firestore;

import gymapp.model.Firebase;

public class WorkoutResource {

	private Firestore db = null;

	public WorkoutResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
	}
}
