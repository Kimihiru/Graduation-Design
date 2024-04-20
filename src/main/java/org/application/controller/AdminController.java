package org.application.controller;

import org.application.entity.AttractionInformation;
import org.application.entity.User;
import org.application.service.AttractionInformationService;
import org.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sakura
 * 用户管理
 */
@RestController
public class AdminController {
    @Autowired
    public UserService userService;
    @Autowired
    public AttractionInformationService attractionInformationService;

    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam String username, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<User> data=userService.selectPage(username,pageNum,pageSize);
        Integer total=userService.total(username);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @PostMapping("/saveOrUpdate")
    public Boolean saveOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user)==1;
    }

    @PostMapping("/delete")
    public Boolean deleteById(@RequestBody User user){
        return userService.del(user.getId())==1;
    }

    @GetMapping("/msgPage")
    public Map<String,Object> msgPage(@RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<AttractionInformation> data=attractionInformationService.selectPage(name,pageNum,pageSize);
        Integer total=attractionInformationService.total(name);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @GetMapping("/userPage")
    public Map<String,Object> userPage(@RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<AttractionInformation> data=attractionInformationService.userSelectPage(name,pageNum,pageSize);
        Integer total=attractionInformationService.total(name);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @PostMapping("/insertOrUpdate")
    public Boolean insertOrUpdate(@RequestBody AttractionInformation attractionInformation){
        return attractionInformationService.insertOrUpdate(attractionInformation)==1;
    }

    @PostMapping("/msgDelete")
    public Boolean msgDelete(@RequestBody AttractionInformation attractionInformation){
        return attractionInformationService.del(attractionInformation.getId())==1;
    }

    @GetMapping("/typePage")
    public Map<String,Object> typePage(@RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<AttractionInformation> data=attractionInformationService.typePage(name,pageNum,pageSize);
        Integer total=attractionInformationService.total(name);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @PostMapping("/typeSaveOrUpdate")
    public Boolean typeSaveOrUpdate(@RequestBody AttractionInformation attractionInformation){
        return attractionInformationService.typeSaveOrUpdate(attractionInformation)==1;
    }

    @GetMapping("/scorePage")
    public Map<String,Object> scorePage(@RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<AttractionInformation> data=attractionInformationService.scorePage(name,pageNum,pageSize);
        Integer total=attractionInformationService.total(name);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @PostMapping("/scoreSaveOrUpdate")
    public Boolean scoreSaveOrUpdate(@RequestBody AttractionInformation attractionInformation){
        return attractionInformationService.scoreSaveOrUpdate(attractionInformation)==1;
    }

    @GetMapping("/foodPage")
    public Map<String,Object> foodPage(@RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<AttractionInformation> data=attractionInformationService.foodPage(name,pageNum,pageSize);
        Integer total=attractionInformationService.total(name);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @PostMapping("/foodSaveOrUpdate")
    public Boolean foodSaveOrUpdate(@RequestBody AttractionInformation attractionInformation){
        return attractionInformationService.foodSaveOrUpdate(attractionInformation)==1;
    }
}