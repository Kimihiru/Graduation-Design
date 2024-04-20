package org.application.controller;

import org.application.entity.Admin;
import org.application.entity.User;
import org.application.service.AdminService;
import org.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sakura
 * 登录及注册
 */
@RestController
public class LoginController {
    @Autowired
    public AdminService adminService;
    @Autowired
    public UserService userService;
    @PostMapping("/adminLogin")
    public Boolean adminLogin(@RequestBody Admin admin){
        return adminService.query(admin.getUsername(),admin.getPassword())==1;
    }
    @PostMapping("/userLogin")
    public Boolean userLogin(@RequestBody User user){
        return userService.ifExist(user.getUsername(),user.getPassword())==1;
    }
    @PostMapping("/register")
    public Boolean register(@RequestBody User user){
        if (userService.ifRegister(user.getUsername())==1||"".equals(user.getUsername())||"".equals(user.getPassword())){
            return true;
        }
        else {
            userService.register(user);
            return false;
        }
    }
}