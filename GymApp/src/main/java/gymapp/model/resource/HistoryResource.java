package gymapp.model.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import gymapp.model.Firebase;
import gymapp.model.domain.Exercise;
import gymapp.model.domain.History;
import gymapp.model.domain.Workout;
import gymapp.utils.UserSession;

public class HistoryResource implements ResourceInterface<History>{

	private Firestore db = null;
	private String login = null;

	public HistoryResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
	}

	@Override
	public void save(History t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public History find(History t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<History> findAll() throws Exception {
		List<History> ret = new ArrayList<History>();
		login = UserSession.getInstance().getUser().getLogin();

		ApiFuture<QuerySnapshot> query = db.collection(gymapp.utils.Constants.USER_COLLECTION).whereEqualTo("login", login).get();
		
		QuerySnapshot querySnapshot = query.get();
		
		List<QueryDocumentSnapshot> usersDocuments = querySnapshot.getDocuments();

		for (QueryDocumentSnapshot historyDocumentSnapshot : usersDocuments) {
			History history = new History();
			history.setName(historyDocumentSnapshot.getString("name"));
			history.setLevel(historyDocumentSnapshot.getLong("level"));
			history.setEstimatedTime(historyDocumentSnapshot.getString("estimatedTime"));
			history.setTime(historyDocumentSnapshot.getString("time"));
			history.setVideoURL(historyDocumentSnapshot.getString("videoUrl"));
			history.setCompletionProgress(historyDocumentSnapshot.getString("completionProgress"));
			history.setDate(historyDocumentSnapshot.getString("date"));

			ret.add(history);
		}

		return ret;
	}

	@Override
	public void update(History t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(History t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
