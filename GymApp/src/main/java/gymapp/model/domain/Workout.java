package gymapp.model.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Workout implements Serializable {

	private static final long serialVersionUID = 3378306974356352821L;

	private String id = null;

	private String name = null;

	private Long level = null;

	private Instant time = null;

	private Instant estimatedTime = null;

	private Date date = null;

	private Date completitionDate = null;

	private String videoURL = null;

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

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public Instant getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Instant estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCompletitionDate() {
		return completitionDate;
	}

	public void setCompletitionDate(Date completitionDate) {
		this.completitionDate = completitionDate;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
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
		return Objects.hash(completitionDate, date, estimatedTime, exercises, id, level, name, time, videoURL);
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
		return Objects.equals(completitionDate, other.completitionDate) && Objects.equals(date, other.date)
				&& Objects.equals(estimatedTime, other.estimatedTime) && Objects.equals(exercises, other.exercises)
				&& Objects.equals(id, other.id) && Objects.equals(level, other.level)
				&& Objects.equals(name, other.name) && Objects.equals(time, other.time)
				&& Objects.equals(videoURL, other.videoURL);
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", name=" + name + ", level=" + level + ", time=" + time + ", estimatedTime="
				+ estimatedTime + ", date=" + date + ", completitionDate=" + completitionDate + ", videoURL=" + videoURL
				+ ", exercises=" + exercises + "]";
	}

}
