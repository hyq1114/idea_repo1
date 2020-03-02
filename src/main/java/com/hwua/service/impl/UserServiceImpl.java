package com.hwua.service.impl;

import com.hwua.mapper.UserMapper;
import com.hwua.pojo.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() throws Exception {
        return userMapper.findAllUsers();
    }

    @Override
    public User findUserById(Long id) throws Exception {
        return userMapper.findUserById(id);
    }

    @Override

    public void delUserById(Long id) throws Exception {
        userMapper.delUserById(id);
    }

    @Override

    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override

    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }

    @Override
    public User findUserByUser(User user) throws Exception {
        return userMapper.findUserByUser(user);
    }
}
