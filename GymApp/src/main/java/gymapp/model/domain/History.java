package gymapp.model.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class History implements Serializable{

	private static final long serialVersionUID = -362419998920090751L;

	private String name = null;

	private Long level = null;

	private String estimatedTime = null;
	
	private String time = null;

	private String videoURL = null;

	private String completionProgress = null;
	
	private String date = null;

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

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getCompletionProgress() {
		return completionProgress;
	}

	public void setCompletionProgress(String completionProgress) {
		this.completionProgress = completionProgress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "History [name=" + name + ", level=" + level + ", estimatedTime=" + estimatedTime
				+ ", time=" + time + ", videoURL=" + videoURL + ", completionProgress=" + completionProgress + ", date="
				+ date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(completionProgress, date, estimatedTime, level, name, time, videoURL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		return Objects.equals(completionProgress, other.completionProgress) && Objects.equals(date, other.date)
				&& Objects.equals(estimatedTime, other.estimatedTime)
				&& Objects.equals(level, other.level) && Objects.equals(name, other.name)
				&& Objects.equals(time, other.time) && Objects.equals(videoURL, other.videoURL);
	}

	
}