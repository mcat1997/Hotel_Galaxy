package sql;

import java.sql.*;

/**
 * Created by a3899 on 2017/7/10.
 */
public class Sql_Connect_Galaxy {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/MyFirstSQL";
    public static final String DBUSER = "root";
    public static final String DBPASS = "385469721";
    private Connection conn = null;

    public Sql_Connect_Galaxy(){
        //连接驱动
        try {
            Class.forName(DBDRIVER).newInstance();
            System.out.println("加载驱动成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("数据库驱动加载失败");
        }
        try {
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("获取数据库链接失败");
        }
    }

    //执行sql语句的方法
    public ResultSet execSQL_Galaxy(String sql, Object... args)throws SQLException {
        PreparedStatement pStmt = conn.prepareStatement(sql);

        for(int i=0;i<args.length;i++){
            pStmt.setObject(i+1,args[i]);
        }

        pStmt.execute();
        return pStmt.getResultSet();
    }

    //关闭数据库连接
    public void closeSQLConn_Galaxy(){
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e ){
                e.printStackTrace();
            }
        }
    }
}
