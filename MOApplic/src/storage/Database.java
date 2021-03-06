package storage;

import java.util.ArrayList;

public class Database {

	private static Database INSTANCE;
	private ArrayList<User> users;

	public Database() {
		if (INSTANCE == null) {
			users = new ArrayList<User>();
			users.add(new User("dev","pass","dev@gmail.com"));
			INSTANCE = this;
		}
	}

	public boolean isEmpty() {
		if (users != null && !users.isEmpty())
			return false;
		return true;
	}

	public void add(User user) {
		users.add(user.getId(), user);// the position of the user will be it's
		// unique id so that it will be easy to find
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public static Database getINSTANCE() {
		return INSTANCE;
	}
}
