package com.renguangli.jpa.controller;

import com.renguangli.jpa.entity.User;
import com.renguangli.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


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
    public Map<String, Object> listUsers(User user
            , @RequestParam(value = "page", defaultValue = "1") Integer page
            , @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        Pageable pageable = new PageRequest((page - 1) * limit, limit);
        Specification<User> specification = (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            String username = user.getUsername();
            if (username != null && !"".equals(username)){
                list.add(cb.like(root.get("username").as(String.class), username + "%"));
            }
            return cb.and(list.toArray(new Predicate[0]));
        };
        Page<User> userPage = userRepository.findAll(specification, pageable);

        Map<String, Object> data = new Hashtable<>();
        data.put("code", 0);
        data.put("msg", "success");
        data.put("data", userPage.getContent());
        data.put("count", userPage.getTotalElements());
        return data;
    }

    @GetMapping("/user")
    public boolean existsUser(Long userId) {
        return userRepository.exists(userId);
    }

    @PostMapping("/user")
    public boolean saveUser(User user) {
        user.setUsername(UUID.randomUUID().toString().replace("-", "").substring(0,15));
        user.setPassword(UUID.randomUUID().toString().replace("-", "").substring(0,11));
        if (new Random().nextInt(10) % 2 == 0) {
            user.setSex('男');
        } else {
            user.setSex('女');
        }
        user.setCreateTime(new Date());
        user.setAge(18);
        userRepository.save(user);
        return true;
    }

    @DeleteMapping("/user/{userId}")
    public boolean deleteUser(@PathVariable Long userId) {
        userRepository.delete(userId);
        return true;
    }

    @DeleteMapping("/users")
    public boolean deleteBatchUser(@RequestParam("userIds[]") Long[] userIds) {
        userRepository.deleteByUserIdIn(userIds);
        return true;
    }

    @PutMapping("/user")
    public boolean updateUser(User user) {
        userRepository.updateUser(user.getPassword(), user.getUsername());
        return true;
    }

}
