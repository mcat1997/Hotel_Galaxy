package dao;

import java.sql.*;

/**
 * Created by a3899 on 2017/7/13.
 */
public class BaseDao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/Hotel_Galaxy?useUnicode=true&characterincoding=UTF-";
    private String user = "root";
    private String password = "385469721";
    private Connection conn = null;

    public BaseDao() {
    }

    public Connection getConnection() {
        if(this.conn == null) {
            try {
                Class.forName(this.driver);
                this.conn = DriverManager.getConnection(this.url, this.user, this.password);
            } catch (Exception var2) {
                var2.printStackTrace();
            }
        }

        return this.conn;
    }

    public void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }

        if(stmt != null) {
            try {
                stmt.close();
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

    }

}