package org.application.service;

import org.application.mapper.DistanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sakura
 * areaName to area`s distance
 */
@Service("distanceService")
public class DistanceService {
    @Autowired
    public DistanceDao distanceDao;
    public Integer panyu(String area){
        return distanceDao.panyu(area);
    }

    public Integer nansha(String area){
        return distanceDao.nansha(area);
    }

    public Integer liwan(String area){
        return distanceDao.liwan(area);
    }

    public Integer yuexiu(String area){
        return distanceDao.yuexiu(area);
    }

    public Integer haizhu(String area){
        return distanceDao.haizhu(area);
    }

    public Integer tianhe(String area){
        return distanceDao.tianhe(area);
    }

    public Integer baiyun(String area){
        return distanceDao.baiyun(area);
    }

    public Integer huangpu(String area){
        return distanceDao.huangpu(area);
    }

    public Integer huadu(String area){
        return distanceDao.huadu(area);
    }

    public Integer zengcheng(String area){
        return distanceDao.zengcheng(area);
    }

    public Integer conghua(String area){
        return distanceDao.conghua(area);
    }
}