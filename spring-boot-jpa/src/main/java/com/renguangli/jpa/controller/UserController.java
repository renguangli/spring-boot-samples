package com.renguangli.jpa.controller;

import com.renguangli.jpa.entity.User;
import com.renguangli.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * Created by renguangli at 2018/10/15 20:03
 * @since JDK1.8
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Map<String, Object> listUsers() {
        List<User> users = userRepository.findAll();
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("data", users);
        data.put("count", userRepository.count());
        data.put("message", "success");
        return data;
    }

    @GetMapping("/user")
    public boolean existsUser(Long userId) {
        return userRepository.exists(userId);
    }

    @PostMapping("/user")
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user")
    public Long deleteUser(Long userId) {
        userRepository.delete(userId);
        return userId;
    }

    @PutMapping("/user")
    public User updateUser(User user) {
        return userRepository.updateUser(user.getPassword(), user.getUsername());
    }
}
