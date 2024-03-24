package com.ceudev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        return userService.updateUser(id, user);
    }

    @PutMapping("/follow")
    public User follow(@RequestParam Long userId, @RequestParam Long followerId) throws Exception {
        return userService.follow(userId, followerId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
    }
}