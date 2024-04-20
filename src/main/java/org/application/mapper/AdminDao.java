package org.application.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.application.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author Sakura
 * 管理员接口
 * 只负责检验登录信息
 */
@Repository
@Mapper
public interface AdminDao {
    @Select("select count(*) from admin where username=#{username} and password=#{password}")
    Integer query(String username,String password);
}