package org.application.controller;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.application.entity.AttractionInformation;
import org.application.service.AttractionInformationService;
import org.application.service.PersonalRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sakura
 * 热门景点推荐
 * 个性化推荐
 */
@RestController
public class RecommendController {
    @Autowired
    public AttractionInformationService attractionInformationService;
    @GetMapping("/hotRecommend")
    public Map<String,Object> hotRecommend() throws TasteException {
        List<AttractionInformation> list=new ArrayList<>();
        PersonalRecommend logistics=new PersonalRecommend();
        int total=10;
        List<RecommendedItem> hotModel=logistics.logistics(total);
        for (int i=0;i<total;i++){
            Integer id=Integer.parseInt(String.valueOf(hotModel.get(i).getItemID()));
            AttractionInformation attractionInformation=attractionInformationService.selectOne(id);
            list.add(attractionInformation);
        }
        Map<String,Object> res=new HashMap<>();
        res.put("data",list);
        res.put("total",total);
        return res;
    }

    @GetMapping("/personalRecommend")
    public Map<String,Object> personalRecommend() throws TasteException {
        long userid= (long) (Math.random() * 300);
        long itemId= (long) (Math.random() * 150);
        int howMany=5;
        List<AttractionInformation> data=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        PersonalRecommend personalRecommend=new PersonalRecommend();
        List<RecommendedItem> recommendedItems=personalRecommend.recommendedItems(userid,itemId,howMany);
        for (int i=0;i<howMany;i++){
            Integer id=Integer.parseInt(String.valueOf(recommendedItems.get(i).getItemID()));
            AttractionInformation attractionInformation=attractionInformationService.selectOne(id);
            data.add(attractionInformation);
        }
        map.put("data",data);
        map.put("total",howMany);
        return map;
    }
}