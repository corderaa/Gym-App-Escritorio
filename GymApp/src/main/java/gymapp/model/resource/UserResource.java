package gymapp.model.resource;

import java.io.IOException;

import com.google.cloud.firestore.Firestore;

import gymapp.model.Firebase;

public class UserResource {
	
	private Firestore db = null;

	public UserResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
	}
}
