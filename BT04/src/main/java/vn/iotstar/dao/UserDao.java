package vn.iotstar.dao;

import vn.iotstar.model.User;

public interface UserDao {

    User findById(int id);

    void update(User user);
}