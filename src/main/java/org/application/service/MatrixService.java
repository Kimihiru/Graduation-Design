package org.application.service;

import org.application.mapper.MatrixDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sakura
 */
@Service("matrixService")
public class MatrixService {
    @Autowired
    public MatrixDao matrixDao;
    public Integer panyu(String area){
        return matrixDao.panyu(area);
    }

    public Integer nansha(String area){
        return matrixDao.nansha(area);
    }

    public Integer liwan(String area){
        return matrixDao.liwan(area);
    }

    public Integer yuexiu(String area){
        return matrixDao.yuexiu(area);
    }

    public Integer haizhu(String area){
        return matrixDao.haizhu(area);
    }

    public Integer tianhe(String area){
        return matrixDao.tianhe(area);
    }

    public Integer baiyun(String area){
        return matrixDao.baiyun(area);
    }

    public Integer huangpu(String area){
        return matrixDao.huangpu(area);
    }

    public Integer huadu(String area){
        return matrixDao.huadu(area);
    }

    public Integer zengcheng(String area){
        return matrixDao.zengcheng(area);
    }

    public Integer conghua(String area){
        return matrixDao.conghua(area);
    }
}