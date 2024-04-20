package org.application.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Sakura
 * areaName to area`s distance
 */
@Repository
@Mapper
public interface DistanceDao {
    @Select("select panyu from distance where area=#{area}")
    Integer panyu(String area);

    @Select("select nansha from distance where area=#{area}")
    Integer nansha(String area);

    @Select("select liwan from distance where area=#{area}")
    Integer liwan(String area);

    @Select("select yuexiu from distance where area=#{area}")
    Integer yuexiu(String area);

    @Select("select haizhu from distance where area=#{area}")
    Integer haizhu(String area);

    @Select("select tianhe from distance where area=#{area}")
    Integer tianhe(String area);

    @Select("select baiyun from distance where area=#{area}")
    Integer baiyun(String area);

    @Select("select huangpu from distance where area=#{area}")
    Integer huangpu(String area);

    @Select("select huadu from distance where area=#{area}")
    Integer huadu(String area);

    @Select("select zengcheng from distance where area=#{area}")
    Integer zengcheng(String area);

    @Select("select conghua from distance where area=#{area}")
    Integer conghua(String area);
}