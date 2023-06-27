package dao;

import java.sql.*;
import java.util.*;

public class AttendanceApprovalDao {
	public class PracticeDao {
    //接続用の情報をフィールドに定数として定義
    private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://153.127.34.246:13306/mysql";
    private static String USER = "root";
    private static String PASS = "password";
    //データベース接続を行うメソッド
    public static Connection getConnection(){
        try{
            Class.forName(RDB_DRIVE);
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        }catch(Exception e){
            throw new IllegalStateException(e);
        }
    }
    //データベースから全てのデータの検索を行うメソッド
    public ArrayList<PracticeInfo> selectAll(){
        //変数宣言
        Connection con = null;
        Statement  smt = null;
        //return用オブジェクトの生成
        ArrayList<PracticeInfo> list = new ArrayList<PracticeInfo>();
        //SQL文
        String sql = "SELECT * FROM practice_table";

        try{
            con = getConnection();
            smt = con.createStatement();
            //SQLをDBへ発行
            ResultSet rs = smt.executeQuery(sql);
            //検索結果を配列に格納
            while(rs.next()){
                PracticeInfo info =new PracticeInfo();
                info.setId(rs.getString("id"));
                info.setName(rs.getString("name"));
                info.setPrice(rs.getInt("price"));
                info.setAuthor(rs.getString("author"));
                info.setComment(rs.getString("comment"));
                list.add(info);
            }
        }catch(Exception e){
            throw new IllegalStateException(e);
        }finally{
            //リソースの開放
            if(smt != null){
                try{smt.close();}catch(SQLException ignore){}
            }
            if(con != null){
                try{con.close();}catch(SQLException ignore){}
            }
        }
        return list;
    }
    //データベースから指定された1件のデータの検索を行うメソッド
    public PracticeInfo selectById(String id){
        //変数宣言
        Connection con = null;
        Statement  smt = null;
        //return用オブジェクトを宣言
        PracticeInfo info =new PracticeInfo();
        //SQL文
        String sql = "SELECT * FROM practice_table WHERE id = '" + id + "'";
        try{
            con = getConnection();
            smt = con.createStatement();
            //SQLをDBへ発行
            ResultSet rs = smt.executeQuery(sql);
            //取得した結果をreturn用オブジェクトに格納する
            if(rs.next()){
                info.setId(rs.getString("id"));
                info.setName(rs.getString("name"));
                info.setPrice(rs.getInt("price"));
                info.setAuthor(rs.getString("author"));
                info.setComment(rs.getString("comment"));
            }
        }catch(Exception e){
            throw new IllegalStateException(e);
        }finally{
            //リソースの開放
            if(smt != null){
                try{smt.close();}catch(SQLException ignore){}
            }
            if(con != null){
                try{con.close();}catch(SQLException ignore){}
            }
        }
        return info;
    }
  }
}
