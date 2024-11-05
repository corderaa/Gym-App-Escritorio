package gymapp.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import gymapp.model.domain.User;
import gymapp.model.resource.UserResource;
import gymapp.utils.Constants;
import gymapp.utils.DateUtils;

public class UserService implements ServiceInterface<User> {

	private UserResource userResource = null;

	public UserService() throws IOException {
		userResource = new UserResource();
	}

	@Override
	public void save(User user) throws Exception {
		if (!isUserPresent(user)) {
			userResource.save(user);
		}
	}

	@Override
	public User find(User user) throws Exception {
		return userResource.find(user);
	}

	@Override
	public List<User> findAll() throws Exception {
		return userResource.findAll();
	}

	@Override
	public void upodate(User user) throws Exception {
		userResource.update(user);
	}

	@Override
	public void delete(User user) throws Exception {
		userResource.delete(user);
	}

	public boolean isUserPresent(User user) throws Exception {
		if (find(user).getLogin() != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkCredentials(User user) throws Exception {
		User existingUser = null;
		if (isUserPresent(user)) {
			existingUser = find(user);
			if (existingUser.getLogin().equalsIgnoreCase(user.getLogin())
					&& existingUser.getPassword().equals(user.getPassword())) {
				return true;
			}
		}

		return false;
	}

	public User createUser(String name, String lastName, String login, String mail, String password, String birthDate)
			throws ParseException {
		User ret = new User();

		ret.setAuthority(Constants.USER_CLIENT_ROLE);
		ret.setName(name);
		ret.setLastName(lastName);
		ret.setLevel(Integer.toUnsignedLong(0));
		ret.setLogin(login);
		ret.setMail(mail);
		ret.setPassword(password);
		ret.setBirthDate(DateUtils.stringToDate(birthDate));

		return ret;
	}
}