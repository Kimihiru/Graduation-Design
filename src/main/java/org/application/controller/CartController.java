package org.application.controller;

import org.application.entity.Cart;
import org.application.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sakura
 */
@RestController
public class CartController {
    @Autowired
    public CartService cartService;

    @GetMapping("/cartPage")
    public Map<String,Object> selectPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<Cart> data=cartService.selectPage(pageNum,pageSize);
        Integer total=cartService.total();
        Map<String,Object> map=new HashMap<>();
        map.put("data",data);
        map.put("total",total);
        return map;
    }

    @PostMapping("/addToCart")
    public Boolean add(@RequestBody Cart cart){
        return cartService.add(cart)==1;
    }

    @PostMapping("/deleteFromCart")
    public Boolean delete(@RequestBody Cart cart){
        return cartService.delete(cart.getId())==1;
    }

    @PostMapping("/truncate")
    public void truncate(){
        cartService.truncate();
    }
}