package org.application.service;

import org.application.mapper.FeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sakura
 * areaName to area`s fee
 */
@Service("feeService")
public class FeeService {
    @Autowired
    public FeeDao feeDao;
    public Integer panyu(String area){
        return feeDao.panyu(area);
    }

    public Integer nansha(String area){
        return feeDao.nansha(area);
    }

    public Integer liwan(String area){
        return feeDao.liwan(area);
    }

    public Integer yuexiu(String area){
        return feeDao.yuexiu(area);
    }

    public Integer haizhu(String area){
        return feeDao.haizhu(area);
    }

    public Integer tianhe(String area){
        return feeDao.tianhe(area);
    }

    public Integer baiyun(String area){
        return feeDao.baiyun(area);
    }

    public Integer huangpu(String area){
        return feeDao.huangpu(area);
    }

    public Integer huadu(String area){
        return feeDao.huadu(area);
    }

    public Integer zengcheng(String area){
        return feeDao.zengcheng(area);
    }

    public Integer conghua(String area){
        return feeDao.conghua(area);
    }
}