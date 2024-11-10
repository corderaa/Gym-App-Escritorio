package gymapp.model.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import gymapp.model.Firebase;
import gymapp.model.domain.History;
import gymapp.utils.UserSession;

public class HistoryResource implements ResourceInterface<History> {

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

		ApiFuture<QuerySnapshot> query = db.collection(gymapp.utils.Constants.USER_COLLECTION)
				.whereEqualTo("login", login).get();
		
		QuerySnapshot querySnapshot = query.get();

		List<QueryDocumentSnapshot> usersDocuments = querySnapshot.getDocuments();
		if (usersDocuments != null && !usersDocuments.isEmpty()) {
			DocumentReference userRef = usersDocuments.get(0).getReference();
		    ApiFuture<QuerySnapshot> historyQuery = userRef.collection(gymapp.utils.Constants.HISTORY_COLLECTION).orderBy("level", Query.Direction.DESCENDING).get();
		    QuerySnapshot historySnapshot = historyQuery.get();
		    List<QueryDocumentSnapshot> historyDocuments = historySnapshot.getDocuments();
			
			for (QueryDocumentSnapshot historyDocumentSnapshot : historyDocuments) {
				History history = new History();
				history.setName(historyDocumentSnapshot.getString("name"));
				history.setLevel(historyDocumentSnapshot.getLong("level"));
				history.setEstimatedTime(historyDocumentSnapshot.getString("estimatedTime"));
				history.setTime(historyDocumentSnapshot.getString("time"));
				history.setVideoURL(historyDocumentSnapshot.getString("videoURL"));
				history.setCompletionProgress(historyDocumentSnapshot.getString("completionProgress"));
				history.setDate(historyDocumentSnapshot.getString("date"));

				ret.add(history);
			}
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
