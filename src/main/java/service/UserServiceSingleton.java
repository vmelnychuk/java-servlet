package service;

public class UserServiceSingleton {
    private static UserService userService = new MapUserService();

    public static UserService getInstance() {
        return userService;
    }

    private UserServiceSingleton() {
    }
}
