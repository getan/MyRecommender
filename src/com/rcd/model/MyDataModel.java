package com.rcd.model;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.common.RandomUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataModel {

	public static JDBCDataModel myJDBCDataModel() {
		MysqlDataSource dataSource = new MysqlDataSource();
		JDBCDataModel dataModel = null;
		try {
			dataSource.setServerName("127.0.0.1");
			dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setDatabaseName("movie");
			// use JNDI
			dataModel = new MySQLJDBCDataModel(DataBaseUtil.getDataSource(),
					"movie_preferences", "userID", "movieID", "preference");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" database exception");
			e.printStackTrace();
		}
		return dataModel;
	}
	public static DataModel myFileDataModel(){
		RandomUtils.useTestSeed();
        String file = "/home/getan/git/MyRecommender/movie_preferences.txt";
        DataModel dataModel = null;
        try {
			dataModel = new FileDataModel(new File(file));
			return dataModel;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}//构造数据模型，File-based;
		return dataModel;
		
	}
	

}
