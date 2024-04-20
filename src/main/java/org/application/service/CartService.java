package org.application.service;

import org.application.entity.Cart;
import org.application.mapper.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sakura
 */
@Service("cartService")
public class CartService {
    @Autowired
    public CartDao cartDao;
    public List<Cart> selectPage(Integer pageNum,Integer pageSize){
        return cartDao.selectPage(pageNum,pageSize);
    }
    public Integer total(){
        return cartDao.total();
    }
    public Integer add(Cart cart){
        cart.setName(cart.getName());
        cart.setArea(cart.getArea());
        return cartDao.add(cart);
    }
    public Integer delete(Integer id){
        return cartDao.delete(id);
    }

    public List<Cart> queryAll(){
        return cartDao.queryAll();
    }

    public void truncate(){
        cartDao.truncate();
    }
}