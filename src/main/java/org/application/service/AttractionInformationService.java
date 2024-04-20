package org.application.service;

import org.application.entity.AttractionInformation;
import org.application.mapper.AttractionInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sakura
 */
@Service("attractionInformationService")
public class AttractionInformationService {
    @Autowired
    public AttractionInformationDao attractionInformationDao;

    public Integer del(Integer id){
        return attractionInformationDao.del(id);
    }

    public Integer insertOrUpdate(AttractionInformation attractionInformation){
        if(attractionInformation.getId()==null){
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setOpentime(attractionInformation.getOpentime());
            attractionInformation.setLine(attractionInformation.getLine());
            attractionInformation.setPrice(attractionInformation.getPrice());
            attractionInformation.setAddress(attractionInformation.getAddress());
            attractionInformation.setHot(attractionInformation.getHot());
            attractionInformation.setTelephone(attractionInformation.getTelephone());
            attractionInformation.setArea(attractionInformation.getArea());
            return attractionInformationDao.insert(attractionInformation);
        }
        else {
            attractionInformation.setId(attractionInformation.getId());
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setOpentime(attractionInformation.getOpentime());
            attractionInformation.setLine(attractionInformation.getLine());
            attractionInformation.setPrice(attractionInformation.getPrice());
            attractionInformation.setAddress(attractionInformation.getAddress());
            attractionInformation.setHot(attractionInformation.getHot());
            attractionInformation.setTelephone(attractionInformation.getTelephone());
            attractionInformation.setArea(attractionInformation.getArea());
            return attractionInformationDao.update(attractionInformation);
        }
    }

    public List<AttractionInformation> selectPage(String name,Integer pageNum,Integer pageSize){
        return attractionInformationDao.selectPage(name,pageNum,pageSize);
    }

    public List<AttractionInformation> userSelectPage(String name,Integer pageNum,Integer pageSize){
        return attractionInformationDao.userSelectPage(name,pageNum,pageSize);
    }

    public Integer total(String name){
        return attractionInformationDao.total(name);
    }

    public List<AttractionInformation> typePage(String name,Integer pageNum,Integer pageSize){
        return attractionInformationDao.typePage(name,pageNum,pageSize);
    }

    public Integer typeSaveOrUpdate(AttractionInformation attractionInformation){
        if (attractionInformation.getId()==null){
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setType(attractionInformation.getType());
            return attractionInformationDao.typeSave1(attractionInformation);
        }
        else{
            attractionInformation.setId(attractionInformation.getId());
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setType(attractionInformation.getType());
            return attractionInformationDao.typeUpdate(attractionInformation);
        }
    }

    public List<AttractionInformation> scorePage(String name,Integer pageNum,Integer pageSize){
        return attractionInformationDao.scorePage(name,pageNum,pageSize);
    }

    public Integer scoreSaveOrUpdate(AttractionInformation attractionInformation){
        if(attractionInformation.getId()==null){
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setScore(attractionInformation.getScore());
            return attractionInformationDao.scoreSave1(attractionInformation);
        }
        else{
            attractionInformation.setId(attractionInformation.getId());
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setScore(attractionInformation.getScore());
            return attractionInformationDao.scoreUpdate1(attractionInformation);
        }
    }

    public List<AttractionInformation> foodPage(String name,Integer pageNum,Integer pageSize){
        return attractionInformationDao.foodPage(name,pageNum,pageSize);
    }

    public Integer foodSaveOrUpdate(AttractionInformation attractionInformation){
        if(attractionInformation.getId()==null){
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setFood(attractionInformation.getFood());
            return attractionInformationDao.foodSave11(attractionInformation);
        }
        else {
            attractionInformation.setId(attractionInformation.getId());
            attractionInformation.setName(attractionInformation.getName());
            attractionInformation.setFood(attractionInformation.getFood());
            return attractionInformationDao.foodUpdate1(attractionInformation);
        }
    }

    public List<AttractionInformation> hotRecommend(Integer pageNum,Integer pageSize){
        return attractionInformationDao.hotRecommend(pageNum,pageSize);
    }

    public AttractionInformation selectOne(Integer id){
        return attractionInformationDao.selectOne(id);
    }
}