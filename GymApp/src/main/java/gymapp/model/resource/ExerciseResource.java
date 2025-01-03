package gymapp.model.resource;

import java.io.IOException;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import gymapp.model.Firebase;
import gymapp.model.domain.Exercise;

public class ExerciseResource implements ResourceInterface<Exercise> {

	private Firestore db = null;

	public ExerciseResource() throws IOException {
		this.db = Firebase.getInstance().getDb();
	}

	@Override
	public void save(Exercise t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Exercise find(Exercise t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exercise> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Exercise t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Exercise t) throws Exception {
		// TODO Auto-generated method stub

	}

	public Exercise findByReference(String ref) throws Exception {

		Exercise ret = new Exercise();

		DocumentSnapshot exerciseDoc = db.collection(gymapp.utils.Constants.EXERCISES_COLLECTION).document(ref).get()
				.get();

		if (exerciseDoc.exists()) {
			ret.setId(exerciseDoc.getId());
			ret.setName(exerciseDoc.getString("name"));
			ret.setDescription(exerciseDoc.getString("description"));
			ret.setRest(exerciseDoc.getLong("rest").intValue());
			ret.setImageUrl(exerciseDoc.getString("imageUrl"));
			ret.setRepetitions(exerciseDoc.getLong("repetitions"));
			ret.setSeries(exerciseDoc.getLong("series"));

		}

		return ret;

	}
}
