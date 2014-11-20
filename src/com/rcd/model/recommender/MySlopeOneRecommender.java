package com.rcd.model.recommender;

import java.util.List;

import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import com.rcd.model.MyDataModel;

public class MySlopeOneRecommender {
	public List<RecommendedItem> mySlopeOneRecommender(long userID,int size){
		List<RecommendedItem> recommendations = null;
		try {
			DataModel model = MyDataModel.myFileDataModel();
			Recommender recommender = new CachingRecommender(new SlopeOneRecommender(model));//构造推荐引擎
			recommendations = recommender.recommend(userID, size);//得到推荐结果
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recommendations;
	}

}
