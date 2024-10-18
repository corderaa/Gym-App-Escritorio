package gymapp.model.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Exercise implements Serializable {

	private static final long serialVersionUID = 1006238012581469025L;

	private String id = null;

	private String name = null;

	private String description = null;

	private Instant time = null;

	private Instant rest = null;

	private String imageUrl = null;

	private Long repetitions = null;

	private Long series = null;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public Instant getRest() {
		return rest;
	}

	public void setRest(Instant rest) {
		this.rest = rest;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Long repetitions) {
		this.repetitions = repetitions;
	}

	public Long getSeries() {
		return series;
	}

	public void setSeries(Long series) {
		this.series = series;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, imageUrl, name, repetitions, rest, series, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Objects.equals(repetitions, other.repetitions) && Objects.equals(rest, other.rest)
				&& Objects.equals(series, other.series) && Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", description=" + description + ", time=" + time + ", rest="
				+ rest + ", imageUrl=" + imageUrl + ", repetitions=" + repetitions + ", series=" + series + "]";
	}

}
