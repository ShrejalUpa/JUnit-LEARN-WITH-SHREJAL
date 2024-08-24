package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void addUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
        }
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public void changePassword(String username, String newPassword) {
        User user = users.get(username);
        if (user != null) {
            user.setPassword(newPassword);
        }
    }
}
