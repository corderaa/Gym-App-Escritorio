package gymapp.utils;

import gymapp.model.domain.Exercise;
import gymapp.model.domain.User;
import gymapp.model.domain.Workout;

public class UserSession {

	public static UserSession instance = null;

	private User user = null;
	private Exercise selectedExercise = null;
	private Workout selectedWorkout = null;

	public static UserSession getInstance() {
		if (instance == null) {
			instance = new UserSession();
		}
		return instance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exercise getSelectedExecise() {
		return selectedExercise;
	}

	public void setSelectedExecise(Exercise selectedExercise) {
		this.selectedExercise = selectedExercise;
	}
	public Workout getSelectedWorkout() {
		return selectedWorkout;
	}

	public void getSelectedWorkout(Workout selectedWorkout) {
		this.selectedWorkout = selectedWorkout;
	}
}
