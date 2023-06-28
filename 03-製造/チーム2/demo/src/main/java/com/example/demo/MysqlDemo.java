package com.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
 * 连接Mysql数据的工具类
 * 前提：pom.xml文件中添加：mysql驱动包
 * */
public class MysqlDemo {
    private static String driver;   // mysql的驱动类：com.mysql.jdbc.Driver
    private static String url;      // url：我们要访问的数据库的地址
    private static String username; // username：要连接的数据库的用户名
    private static String password; // password：要连接的数据库的密码
    private static Connection conn; // mysql数据库的连接对象。注意：Connection是一个接口（interface）
    static {
    	try {
            // 通过IO流的输入流（InputStream）读取外部的db.properties文件。
            InputStream is  = MysqlDemo.class.getClassLoader().getResourceAsStream("db.properties");
            // 创建Properties对象
            Properties properties = new Properties();
            properties.load(is);// 加载is对象
            driver = properties.getProperty("driver");// 根据db.properties文件中的key去获取对应的值，并将获取到的值赋值给我们定义的变量
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 自定义方法（getConnction）：获取（返回）数据库的连接对象
    public static Connection getConnction(){
        try {
            Class.forName(driver);// 通过反射加载驱动类
            conn = DriverManager.getConnection(url,username,password);
    
    } catch (SQLException e) {
        e.printStackTrace();
    }
     catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return conn;
}
// 自定义方法（release）：释放资源【关闭连接回收资源】
public static void release(Connection conn, Statement st, ResultSet rs)  {
    try{
        if(rs!=null) {
            rs.close();
        }
        if(st!=null) {
            st.close();
        }
        if(conn!=null) {
            conn.close();
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
}
public static void main(String[] args){

    System.out.println(getConnction() == null);// true :表示连接数据库失败 false：表示连接数据库成功
}

}