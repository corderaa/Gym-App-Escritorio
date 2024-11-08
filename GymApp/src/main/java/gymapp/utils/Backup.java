package gymapp.utils;

import java.util.List;

import gymapp.model.domain.Exercise;
import gymapp.model.domain.User;
import gymapp.model.domain.Workout;

public class Backup {

	private static Backup instance = null;

	private List<Workout> workouts = null;
	private List<Exercise> exercises = null;
	private User user = null;

	public static Backup getInstance() {
		if (instance == null) {
			instance = new Backup();
		}
		return instance;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void loadData() {
		
	}
}
