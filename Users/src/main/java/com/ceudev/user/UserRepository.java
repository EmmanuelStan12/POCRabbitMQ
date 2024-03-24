package com.ceudev.user;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<Long, User> userMap = new HashMap<>();
    private long nextUserId = 1;

    // Save a user to the in-memory storage
    public User save(User user) {
        if (user.getId() == null) {
            // If the user doesn't have an ID, assign one
            user.setId(nextUserId++);
        }
        userMap.put(user.getId(), user);
        return user;
    }

    // Retrieve a user by ID
    public Optional<User> findById(Long id) {
        User user = userMap.get(id);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    // Retrieve all users
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    // Delete a user by ID
    public void deleteById(Long id) {
        userMap.remove(id);
    }

    public void follow(User user, Long followerId) {
        user.getFollowerIds().add(followerId);
    }
}
