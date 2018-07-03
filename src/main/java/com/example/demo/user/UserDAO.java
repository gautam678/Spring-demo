package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("gautam", 1, "1641 International drive"));
		users.add(new User("Vishal", 2, "1641 International drive"));
		users.add(new User("Mat", 3, "1641 International drive"));
	};
	static int counter = 3;

	public List<User> getusers() {
		return users;
	}

	public User getOneUser(int id) {
		return users.get(id);
	}

	public User setUser(User user) {
		if (user.getId() == null) {
			user.setId(++counter);
		}
		users.add(user);
		return user;
	}

	public User deleteUser(int id) {
		User toDelete = users.get(id);
		if (toDelete == null) {
			return null;
		} else {
			users.remove(id);
			return toDelete;
		}
	}

}
