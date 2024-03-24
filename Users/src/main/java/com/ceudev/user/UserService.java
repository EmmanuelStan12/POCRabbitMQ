package com.ceudev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found with id " + id));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) throws Exception {
        getUserById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) throws Exception {
        getUserById(id); // Check if the user exists
        userRepository.deleteById(id);
    }

    public User follow(Long userId, Long followerId) throws Exception {
        User user = getUserById(userId);
        getUserById(followerId);
        userRepository.follow(user, followerId);
        return user;
    }
}