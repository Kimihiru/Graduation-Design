package org.application.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Sakura
 * areaName to area`s fee
 */
@Repository
@Mapper
public interface FeeDao {
    @Select("select panyu from fee where area=#{area}")
    Integer panyu(String area);

    @Select("select nansha from fee where area=#{area}")
    Integer nansha(String area);

    @Select("select liwan from fee where area=#{area}")
    Integer liwan(String area);

    @Select("select yuexiu from fee where area=#{area}")
    Integer yuexiu(String area);

    @Select("select haizhu from fee where area=#{area}")
    Integer haizhu(String area);

    @Select("select tianhe from fee where area=#{area}")
    Integer tianhe(String area);

    @Select("select baiyun from fee where area=#{area}")
    Integer baiyun(String area);

    @Select("select huangpu from fee where area=#{area}")
    Integer huangpu(String area);

    @Select("select huadu from fee where area=#{area}")
    Integer huadu(String area);

    @Select("select zengcheng from fee where area=#{area}")
    Integer zengcheng(String area);

    @Select("select conghua from fee where area=#{area}")
    Integer conghua(String area);
}