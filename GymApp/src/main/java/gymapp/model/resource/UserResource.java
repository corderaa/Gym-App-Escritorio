package gymapp.model.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import gymapp.model.Firebase;
import gymapp.model.domain.User;

public class UserResource implements ResourceInterface<User> {

	private Firestore db = null;
	private ObjectMapper mapper = null;

	public UserResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
		mapper = new ObjectMapper();
	}

	public void save(User user) throws Exception {
		Map<String, Object> map = mapper.convertValue(user, new HashMap<String, Object>().getClass());

		map.remove("id");
		db.collection(gymapp.utils.Constants.USER_COLLECTION).add(map);
		db.close();
	}	

	public List<User> findAll() throws Exception {
		List<User> ret = new ArrayList<User>();

		List<QueryDocumentSnapshot> userDocuments = db.collection(gymapp.utils.Constants.USER_COLLECTION).get().get()
				.getDocuments();

		for (QueryDocumentSnapshot userDocument : userDocuments) {
			ret.add(mapper.convertValue(userDocument.getData(), User.class));
		}

		return ret;
	}

	public User find(User user) throws Exception {
		User ret = new User();

		List<QueryDocumentSnapshot> userDocuments = db.collection(gymapp.utils.Constants.USER_COLLECTION)
				.whereEqualTo(gymapp.utils.Constants.USER_LOGIN_FIELD, user.getLogin()).get().get().getDocuments();

		for (QueryDocumentSnapshot userDocument : userDocuments) {
			ret = mapper.convertValue(userDocument.getData(), User.class);
		}

		return ret;
	}

	@Override
	public void update(User t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User t) throws Exception {
		// TODO Auto-generated method stub

	}
}
