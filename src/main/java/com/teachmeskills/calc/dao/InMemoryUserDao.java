package com.teachmeskills.calc.dao;

import com.teachmeskills.calc.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserDao implements UserDao {
    private static List<User> users = new ArrayList<>();
    private static long id = 1;
    private static UserDao instance;

    private InMemoryUserDao() {
    }

    public static UserDao getInstance(){
        if (instance == null){
            instance = new InMemoryUserDao();
        }
        return instance;
    }

    public List<User> get() {
        return new ArrayList<>(users);
    }

    public void save(User user) {
        user.setId(id++);
        users.add(user);
    }


    public boolean contains(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean contains(String username, String password){
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserByUsername(String username)  {
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
