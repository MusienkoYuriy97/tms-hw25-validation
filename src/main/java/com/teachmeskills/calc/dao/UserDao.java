package com.teachmeskills.calc.dao;

import com.teachmeskills.calc.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<User> get();
    void save(User user) ;
    boolean contains(String username);
    boolean contains(String username, String password);
    User getUserByUsername(String username);
}
