package gymapp.utils;

import gymapp.model.domain.User;

public class UserSession {

	public static UserSession instance = null;

	private User user = null;

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
}
