package com.example.simpleapp.service;

import com.example.simpleapp.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private final Map<Integer, User> userMap = new HashMap<>();
    private int nextId = 1;

    public User addUser(String name, String email) {
        User user = new User(nextId++, name, email);
        userMap.put(user.getId(), user);
        return user;
    }

    public List<User> listUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User findById(int id) {
        return userMap.get(id);
    }

    public boolean deleteById(int id) {
        return userMap.remove(id) != null;
    }

    public List<User> searchByName(String query) {
        List<User> result = new ArrayList<>();
        for (User u : userMap.values()) {
            if (u.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(u);
            }
        }
        return result;
    }
}
