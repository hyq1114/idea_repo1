package com.hwua.mapper;

import com.hwua.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    public List<User> findAllUsers() throws Exception;
    public User findUserById(Long id) throws  Exception;
    public void delUserById(Long id) throws Exception;
    public void updateUser(User user) throws Exception;
    public void addUser(User user) throws Exception;
    public User findUserByUser(User user) throws Exception;
}
