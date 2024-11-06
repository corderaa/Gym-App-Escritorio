package gymapp.model.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import gymapp.model.Firebase;
import gymapp.model.domain.Exercise;
import gymapp.model.domain.Workout;

public class WorkoutResource implements ResourceInterface<Workout> {

	private Firestore db = null;
	private ExerciseResource exerciseResource = null;

	public WorkoutResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
		this.exerciseResource = new ExerciseResource();

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

		for (QueryDocumentSnapshot workoutDocumentSnapshot : workoutDocuments) {
			Workout workout = new Workout();
			workout.setName(workoutDocumentSnapshot.getString("name"));
			// workout.setExercises((List<Exercise>)
			// workoutDocumentSnapshot.get("exercises"));
			List<DocumentReference> exercisesReference = (List<DocumentReference>) workoutDocumentSnapshot
					.get("exercises");

			workout.setLevel(workoutDocumentSnapshot.getLong("level"));
			workout.setDescription(workoutDocumentSnapshot.getString("description"));
			workout.setVideoURL(workoutDocumentSnapshot.getString("videoUrl"));

			List<Exercise> exercises = new ArrayList<>();

			for (DocumentReference exerciseRef : exercisesReference) {

				Exercise exercise = exerciseResource.findByReference(exerciseRef.getId());
				exercises.add(exercise);
			}
			workout.setExercises(exercises);

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
