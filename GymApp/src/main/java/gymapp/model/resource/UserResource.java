package gymapp.model.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import gymapp.model.Firebase;
import gymapp.model.domain.User;
import gymapp.utils.DateUtils;
import gymapp.utils.UserSession;

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
	public void update(User user) throws Exception {
		String login = null;
		login = UserSession.getInstance().getUser().getLogin();

		ApiFuture<QuerySnapshot> query = db.collection(gymapp.utils.Constants.USER_COLLECTION)
				.whereEqualTo("login", login).get();
		
		QuerySnapshot querySnapshot = query.get();
		
		QueryDocumentSnapshot userDocument = querySnapshot.getDocuments().get(0);
		
		db.collection(gymapp.utils.Constants.USER_COLLECTION).document(userDocument.getId())
        .update("password", user.getPassword());
		db.collection(gymapp.utils.Constants.USER_COLLECTION).document(userDocument.getId())
        .update("name", user.getName());
		db.collection(gymapp.utils.Constants.USER_COLLECTION).document(userDocument.getId())
        .update("mail", user.getMail());
		db.collection(gymapp.utils.Constants.USER_COLLECTION).document(userDocument.getId())
        .update("lastName", user.getLastName());
		db.collection(gymapp.utils.Constants.USER_COLLECTION).document(userDocument.getId())
        .update("birthDate", DateUtils.dateToLong(user.getBirthDate()));
	}

	@Override
	public void delete(User t) throws Exception {
		// TODO Auto-generated method stub

	}
}
