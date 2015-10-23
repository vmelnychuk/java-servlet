package service;

import model.User;

public interface UserService {
    boolean register(User user);
    User login(User user);
    void logout(User user);
    User getById(int id);
}
