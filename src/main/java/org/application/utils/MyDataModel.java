package org.application.utils;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;

/**
 * @author Sakura
 */
public class MyDataModel {
    public static JDBCDataModel myDataModel(){
        MysqlDataSource dataSource = new MysqlDataSource();
        JDBCDataModel dataModel = null;
        try{
            dataSource.setServerName("localhost");
            dataSource.setUser("root");
            dataSource.setPassword("123123");
            dataSource.setDatabaseName("graduationdesign");
            ConnectionPoolDataSource connectionPool=new ConnectionPoolDataSource(dataSource);
            dataModel = new MySQLJDBCDataModel(connectionPool,"userrating","userid","sceneryid","rating",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataModel;
    }
}