package com.hwua.controller;

import com.hwua.pojo.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService=null;
    /**
     * 访问的时候跳转到登录页面
     * @return
     */
    /*@GetMapping({"/","index.html","login.html"})
    public String login()throws Exception{
        return "login";
    }*/

    @PostMapping("/user/login")
    public String login(User user, Map<String,Object> map, HttpSession session)throws Exception{
        user = userService.findUserByUser(user);
        if (user==null){
            map.put("info","用户名或密码错误");
            return "login";
        }else{
            session.setAttribute("user",user);
            return "redirect:/users";
        }
    }

    @GetMapping("/users")
    public String findAllUsers(Map<String,Object> map) throws Exception{
        List<User> users = userService.findAllUsers();
        map.put("users",users);
        return "main";
    }

    @DeleteMapping("/user/{id}")
    public String delUserById(@PathVariable("id") Long id)throws Exception{
        userService.delUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String findUserById(@PathVariable("id") Long id,Map<String,Object> map)throws Exception{
        User user = userService.findUserById(id);
        map.put("user",user);
        return "update_add";
    }

    @PutMapping("/user")
    public String updateUser(User user) throws Exception{
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/user")
    public String addUser(User user) throws Exception{
        userService.addUser(user);
        return "redirect:/users";
    }

    public void aa(){
        System.out.println("啦啦啦");
    }
}
