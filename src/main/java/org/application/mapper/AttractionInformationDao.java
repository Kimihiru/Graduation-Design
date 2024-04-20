package org.application.mapper;

import org.apache.ibatis.annotations.*;
import org.application.entity.AttractionInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author Sakura
 * 景点管理接口
 */
@Repository
@Mapper
public interface AttractionInformationDao {
    @Transactional(rollbackFor = Exception.class)
    @Insert("insert into attractioninformation(id,name,opentime,line,price,address,hot,telephone,area) values(#{id},#{name},#{opentime},#{line},#{price},#{address},#{hot},#{telephone},#{area})")
    Integer insert(AttractionInformation attractionInformation);

    @Transactional(rollbackFor = Exception.class)
    @Delete("delete from attractioninformation where id=#{id}")
    Integer del(Integer id);

    @Transactional(rollbackFor = Exception.class)
    @Update("update attractioninformation set name=#{name},opentime=#{opentime},line=#{line},price=#{price},address=#{address},hot=#{hot},telephone=#{telephone},area=#{area} where id=#{id}")
    Integer update(AttractionInformation attractionInformation);

    @Select("select id,name,opentime,line,price,address,hot,telephone,area from attractioninformation where name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<AttractionInformation> selectPage(String name,Integer pageNum,Integer pageSize);

    @Select("select * from attractioninformation where name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<AttractionInformation> userSelectPage(String name,Integer pageNum,Integer pageSize);

    @Select("select count(*) from attractioninformation where name like concat('%',#{name},'%')")
    Integer total(String name);

    @Select("select id,name,type from attractioninformation where name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<AttractionInformation> typePage(String name,Integer pageNum,Integer pageSize);

    @Transactional(rollbackFor = Exception.class)
    @Insert("insert into attractioninformation(id,name,type) values(#{id},#{name},#{type})")
    Integer typeSave1(AttractionInformation attractionInformation);

    @Transactional(rollbackFor = Exception.class)
    @Update("update attractioninformation set name=#{name},type=#{type} where id=#{id}")
    Integer typeUpdate(AttractionInformation attractionInformation);

    @Select("select id,name,score from attractioninformation where name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<AttractionInformation> scorePage(String name,Integer pageNum,Integer pageSize);

    @Transactional(rollbackFor = Exception.class)
    @Insert("insert into attractioninformation(id,name,score) values(#{id},#{name},#{score})")
    Integer scoreSave1(AttractionInformation attractionInformation);

    @Transactional(rollbackFor = Exception.class)
    @Update("update attractioninformation set name=#{name},score=#{score} where id=#{id}")
    Integer scoreUpdate1(AttractionInformation attractionInformation);

    @Select("select id,name,food from attractioninformation where name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<AttractionInformation> foodPage(String name,Integer pageNum,Integer pageSize);

    @Transactional(rollbackFor = Exception.class)
    @Insert("insert into attractioninformation(id,name,food) values(#{id},#{name},#{food})")
    Integer foodSave11(AttractionInformation attractionInformation);

    @Transactional(rollbackFor = Exception.class)
    @Update("update attractioninformation set name=#{name},food=#{food} where id=#{id}")
    Integer foodUpdate1(AttractionInformation attractionInformation);

    /**
     *热门景点推荐
     */
    @Select("select * from attractioninformation order by hot desc limit #{pageNum},#{pageSize}")
    List<AttractionInformation> hotRecommend(Integer pageNum,Integer pageSize);

    @Select("select * from attractioninformation where id=#{id}")
    AttractionInformation selectOne(Integer id);
}