package com.it.mapper;

import com.it.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUser();
    User findUserByUserName(String username);
    int addUser(User user);
    int delUser(int id);
}
