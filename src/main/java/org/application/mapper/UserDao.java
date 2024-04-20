package org.application.mapper;

import org.apache.ibatis.annotations.*;
import org.application.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Sakura
 * 用户信息
 * 增删改查接口
 */
@Repository
@Mapper
public interface UserDao {
    @Transactional(rollbackFor = Exception.class)
    @Insert("insert into user values(#{id},#{username},#{password})")
    void register(User user);

    @Select("select count(*) from user where username=#{username} and password=#{password}")
    Integer ifExist(String username,String password);

    @Select("select count(*) from user where username=#{username}")
    Integer ifRegister(String username);

    @Select("select * from user where username like concat('%',#{username},'%') limit #{pageNum},#{pageSize}")
    List<User> selectPage(String username,Integer pageNum,Integer pageSize);

    @Select("select count(*) from user where username like concat('%',#{username},'%')")
    Integer total(String username);

    @Transactional(rollbackFor = Exception.class)
    @Delete("delete from user where id=#{id}")
    Integer delete(Integer id);

    @Transactional(rollbackFor = Exception.class)
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    Integer update(User user);

    @Transactional(rollbackFor = Exception.class)
    @Insert("insert into user values(#{id},#{username},#{password})")
    Integer save(User user);
}