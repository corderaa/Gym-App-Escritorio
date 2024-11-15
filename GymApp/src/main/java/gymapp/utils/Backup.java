package gymapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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

	public void setExercises() throws IOException, ClassNotFoundException {
		ProcessBuilder processBuilder = new ProcessBuilder(Constants.PROCESS_NAME, "/c",
				Constants.READ_BACKUP_EXERCISES_COMMAND);
		Process process = processBuilder.start();

		ObjectInputStream objectInputStream = new ObjectInputStream(process.getInputStream());

		this.exercises = (List<Exercise>) objectInputStream.readObject();

		objectInputStream.close();
	}

	public void setWorkouts() throws IOException, ClassNotFoundException {
		ProcessBuilder processBuilder = new ProcessBuilder(Constants.PROCESS_NAME, "/c",
				Constants.READ_BACKUP_WORKOUTS_COMMAND);
		Process process = processBuilder.start();

		ObjectInputStream objectInputStream = new ObjectInputStream(process.getInputStream());

		this.workouts = (List<Workout>) objectInputStream.readObject();

		System.out.println(workouts);

		objectInputStream.close();
		process.destroy();
	}

	public void backupExercises(List<Exercise> exercises) throws FileNotFoundException, IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(new File(Constants.EXERCISE_BACKUP_FILE_NAME), true));

		objectOutputStream.writeObject(exercises);
		objectOutputStream.close();
	}

	public void backupWorkouts(List<Workout> workouts) throws FileNotFoundException, IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new FileOutputStream(new File(Constants.WORKOUT_BACKUP_FILE_NAME), true));

		objectOutputStream.writeObject(workouts);
		objectOutputStream.close();
	}
}
