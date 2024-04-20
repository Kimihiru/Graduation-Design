package org.application.service;

import org.application.entity.User;
import org.application.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sakura
 */
@Service("userService")
public class UserService {
    @Autowired
    public UserDao userDao;

    public void register(User user){
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userDao.register(user);
    }

    public Integer ifExist(String username,String password){
        return userDao.ifExist(username,password);
    }

    public Integer ifRegister(String username){
        return userDao.ifRegister(username);
    }

    public List<User> selectPage(String username,Integer pageNum,Integer pageSize){
        return userDao.selectPage(username,pageNum,pageSize);
    }

    public Integer del(Integer id){
        return userDao.delete(id);
    }

    public Integer saveOrUpdate(User user){
        if(user.getId()==null){
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            return userDao.save(user);
        }
        else{
            user.setId(user.getId());
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            return userDao.update(user);
        }
    }

    public Integer total(String username){
        return userDao.total(username);
    }
}