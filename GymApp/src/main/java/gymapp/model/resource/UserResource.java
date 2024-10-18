package gymapp.model.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.Firestore;
import gymapp.model.Firebase;
import gymapp.model.domain.User;

public class UserResource {

	private Firestore db = null;
	private ObjectMapper mapper = null;

	public UserResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
		mapper = new ObjectMapper();
	}

	public void save(User user) throws InterruptedException, ExecutionException {
		db.collection(gymapp.utils.Constants.USER_COLLECTION).add(mapper.convertValue(user, HashMap.class));
	}
}
