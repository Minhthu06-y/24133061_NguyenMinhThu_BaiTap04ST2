package vn.iotstar.service;

import vn.iotstar.model.User;

public interface UserService {
	
	User findById(int id);
	
	void update(User user);

}
