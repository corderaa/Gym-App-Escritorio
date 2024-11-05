package gymapp.service;

import java.io.IOException;
import java.util.List;
import gymapp.model.domain.Workout;
import gymapp.model.resource.WorkoutResource;
import gymapp.utils.UserSession;

public class WorkoutService implements ServiceInterface<Workout> {

	private WorkoutResource workoutResource = null;

	public WorkoutService() throws IOException {
		this.workoutResource = new WorkoutResource();
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
		return workoutResource.findAll();
	}

	@Override
	public void upodate(Workout t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Workout t) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<Workout> getfilteredWorkouts() throws Exception {
		List<Workout> ret = null;
		ret = findAll();
		ret.removeIf((workout -> !(workout.getLevel() <= UserSession.getInstance().getUser().getLevel())));

		return ret;
	}
}
