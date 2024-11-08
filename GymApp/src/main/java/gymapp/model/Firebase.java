package gymapp.model;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

import gymapp.utils.CheckConectivity;
import gymapp.utils.Constants;

public class Firebase {

	private static Firebase instance = null;

	private Firestore db = null;

	public Firebase() throws IOException {
		db = makeFirestore();

	}

	/**
	 * Makes the entry to Firestore
	 * 
	 * @return Firestore
	 * @throws IOException
	 */
	public Firestore makeFirestore() throws IOException {
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
				.setProjectId(Constants.FIRESTORE_PROJECT_ID)
				.setCredentials(GoogleCredentials.fromStream(new FileInputStream(Constants.JSON_KEY_PATH))).build();

		return firestoreOptions.getService();
	}

	public static synchronized Firebase getInstance() throws IOException {
		if (instance == null)
			instance = new Firebase();

		return instance;
	}

	public Firestore getDb() {
		return db;
	}
}