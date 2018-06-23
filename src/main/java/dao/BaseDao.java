package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by a3899 on 2017/7/13.
 */
public class BaseDao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/HotelRoomManager?useSSL=false&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Hongkong";
    private String user = "root";
    private String password = "385469721";
    private Connection conn = null;

    public BaseDao() {
    }

    public Connection getConnection() {
        try {
            if (this.conn == null || this.conn.isClosed()) {
                Class.forName(this.driver);
                this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return this.conn;
    }

    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

    }

}
