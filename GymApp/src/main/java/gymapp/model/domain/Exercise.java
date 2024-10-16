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

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, rest, time);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
				&& Objects.equals(name, other.name) && Objects.equals(rest, other.rest)
				&& Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", description=" + description + ", time=" + time + ", rest="
				+ rest + "]";
	}

}
