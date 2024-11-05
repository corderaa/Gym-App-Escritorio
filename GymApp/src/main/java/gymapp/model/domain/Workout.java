package gymapp.model.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Workout implements Serializable {

	private static final long serialVersionUID = 3378306974356352821L;

	private String id = null;

	private String name = null;

	private Long level = null;

	private Instant estimatedTime = null;

	private String videoURL = null;

	private String description = null;

	private List<Exercise> exercises = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public Instant getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Instant estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, estimatedTime, exercises, id, level, name, videoURL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Workout other = (Workout) obj;
		return Objects.equals(description, other.description) && Objects.equals(estimatedTime, other.estimatedTime)
				&& Objects.equals(exercises, other.exercises) && Objects.equals(id, other.id)
				&& Objects.equals(level, other.level) && Objects.equals(name, other.name)
				&& Objects.equals(videoURL, other.videoURL);
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", name=" + name + ", level=" + level + ", estimatedTime=" + estimatedTime
				+ ", videoURL=" + videoURL + ", description=" + description + ", exercises=" + exercises + "]";
	}

}
