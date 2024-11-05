package gymapp.model.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import gymapp.model.Firebase;
import gymapp.model.domain.Workout;

public class WorkoutResource implements ResourceInterface<Workout> {

	private Firestore db = null;

	public WorkoutResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
	}

	@Override
	public void save(Workout t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Workout find(Workout t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Workout> findAll() throws Exception {
		List<Workout> ret = new ArrayList<Workout>();

		List<QueryDocumentSnapshot> workoutDocuments = db.collection(gymapp.utils.Constants.WORKOUTS_COLLECTION).get()
				.get().getDocuments();

		for (QueryDocumentSnapshot workoDocumentSnapshot : workoutDocuments) {
			Workout workout = new Workout();
			workout.setName(workoDocumentSnapshot.getString("name"));
			// workout.setExercises(workoDocumentSnapshot.get("exercises"));
			workout.setLevel(workoDocumentSnapshot.getLong("level"));
			workout.setDescription(workoDocumentSnapshot.getString("description"));
			workout.setVideoURL(workoDocumentSnapshot.getString("videoUrl"));
			ret.add(workout);
		}
		return ret;
	}

	@Override
	public void update(Workout t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Workout t) throws Exception {
		// TODO Auto-generated method stub

	}
}
