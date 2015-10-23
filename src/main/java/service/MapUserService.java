package service;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUserService implements UserService {
    private static Map<Integer, User> users = new HashMap<Integer, User>();
    private static List<User> loginUsers = new ArrayList<User>();
    private static Map<User, Integer> visitingMap = new HashMap<User, Integer>();
    private static volatile int idCount = 1;

    @Override
    public boolean register(User user) {
        int id = idCount++;
        user.setId(id);
        users.put(id, user);
        return true;
    }

    @Override
    public User login(User user) {
        for (Map.Entry<Integer, User> userEntry : users.entrySet()) {
            String email = user.getEmail();
            String password = user.getPassword();
            if(userEntry.getValue().getEmail().equals(email) &&
                    userEntry.getValue().getPassword().equals(password)) {
                loginUsers.add(user);
                return userEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public void logout(User user) {
        loginUsers.remove(user);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }
}
