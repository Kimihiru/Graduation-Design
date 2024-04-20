package org.application.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.application.entity.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sakura
 */
@Repository
@Mapper
public interface CartDao {
    @Select("select * from cart limit #{pageNum},#{pageSize}")
    List<Cart> selectPage(Integer pageNum,Integer pageSize);

    @Select("select count(*) from cart")
    Integer total();

    @Transactional(rollbackFor = Exception.class)
    @Insert("insert into cart values(#{id},#{name},#{area})")
    Integer add(Cart cart);

    @Transactional(rollbackFor = Exception.class)
    @Delete("delete from cart where id=#{id}")
    Integer delete(Integer id);

    @Select("select * from cart")
    List<Cart> queryAll();

    @Delete("truncate cart")
    void truncate();
}