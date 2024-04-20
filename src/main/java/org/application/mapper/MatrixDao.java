package org.application.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Sakura
 */
@Repository
@Mapper
public interface MatrixDao {
    @Select("select panyu from matrix where area=#{area}")
    Integer panyu(String area);

    @Select("select nansha from matrix where area=#{area}")
    Integer nansha(String area);

    @Select("select liwan from matrix where area=#{area}")
    Integer liwan(String area);

    @Select("select yuexiu from matrix where area=#{area}")
    Integer yuexiu(String area);

    @Select("select haizhu from matrix where area=#{area}")
    Integer haizhu(String area);

    @Select("select tianhe from matrix where area=#{area}")
    Integer tianhe(String area);

    @Select("select baiyun from matrix where area=#{area}")
    Integer baiyun(String area);

    @Select("select huangpu from matrix where area=#{area}")
    Integer huangpu(String area);

    @Select("select huadu from matrix where area=#{area}")
    Integer huadu(String area);

    @Select("select zengcheng from matrix where area=#{area}")
    Integer zengcheng(String area);

    @Select("select conghua from matrix where area=#{area}")
    Integer conghua(String area);
}