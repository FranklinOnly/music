package com.it.service.impl;

import com.it.domain.User;
import com.it.mapper.UserMapper;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceIml implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUser() {
        List<User> list=userMapper.findAllUser();
        return list;
    }

    public User findUserByUserName(String username) {
        User user=userMapper.findUserByUserName(username);
        return user;
    }
    public int addUser(User user) {
        int i = userMapper.addUser(user);
        return i;
    }

    public int delUser(int id) {
        int i=userMapper.delUser(id);
        return i;
    }
}
