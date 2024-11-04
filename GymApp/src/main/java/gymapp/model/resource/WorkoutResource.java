package gymapp.model.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.Firestore;

import gymapp.model.Firebase;
import gymapp.model.domain.Workout;
import gymapp.utils.UserSession;

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
		// TODO Auto-generated method stub
		return null;
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
