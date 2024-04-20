package org.application.service;

import org.application.entity.Admin;
import org.application.mapper.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sakura
 */
@Service("adminService")
public class AdminService {
    @Autowired
    public AdminDao adminDao;
    public Integer query(String username,String password){
        return adminDao.query(username,password);
    }
}