package gymapp;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import gymapp.model.domain.User;
import gymapp.model.resource.UserResource;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setAuthority("test");
		user.setBirthDate(new Date());
		user.setEmail("test");
		user.setLastName("test");
		user.setName("test");
		user.setPassword("test");

		try {
			new UserResource().save(user);
		} catch (InterruptedException | ExecutionException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
