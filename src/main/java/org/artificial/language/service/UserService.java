package org.artificial.language.service;

import org.artificial.language.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
