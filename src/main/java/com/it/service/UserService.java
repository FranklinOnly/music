package com.it.service;

import com.it.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    User findUserByUserName(String username);

    int addUser(User user);
    int delUser(int id);

}
