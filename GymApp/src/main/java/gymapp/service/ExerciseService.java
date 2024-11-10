package gymapp.service;

import java.util.List;
import gymapp.model.domain.Exercise;
import gymapp.model.domain.Workout;
import gymapp.model.resource.ExerciseResource;
import gymapp.utils.UserSession;

public class ExerciseService implements ServiceInterface<Exercise> {
	private ExerciseResource exerciseResource = null;

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
		return exerciseResource.findAll();
	}

	@Override
	public void upodate(Exercise t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Exercise t) throws Exception {
		// TODO Auto-generated method stub

	}

}
