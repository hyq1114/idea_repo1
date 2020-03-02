package com.hwua.service;


import com.hwua.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUsers() throws Exception;
    public User findUserById(Long id) throws  Exception;
    public void delUserById(Long id) throws Exception;
    public void updateUser(User user) throws Exception;
    public void addUser(User user) throws Exception;
    public User findUserByUser(User user) throws Exception;

}
