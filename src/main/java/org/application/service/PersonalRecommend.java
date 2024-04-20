package org.application.service;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.application.utils.MyDataModel;
import java.util.List;

/**
 * @author Sakura
 * 个性化推荐
 * 热门景点推荐
 */
public class PersonalRecommend {
    /**
     * 基于物品
     * 个性化景点推荐
     */
    public List<RecommendedItem> recommendedItems(long userid, long itemId, int howMany) throws TasteException {
        DataModel dataModel = MyDataModel.myDataModel();
        ItemSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, similarity);
        return recommender.recommendedBecause(userid,itemId,howMany);
    }

    /**
     * 基于Logistics模型应用在协同过滤算法上
     * 热门景点推荐
     */
    public List<RecommendedItem> logistics(int howMany) throws TasteException{
        DataModel dataModel = MyDataModel.myDataModel();
        ItemSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, similarity);
        long userid = (long) (Math.random() * 300);
        long itemId = (long) (Math.random() * 150);
        return recommender.recommendedBecause(userid,itemId,howMany);
    }
}