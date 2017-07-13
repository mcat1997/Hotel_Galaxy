package dao.impl;

import dao.AdminDao_Galaxy;
import dao.BaseDao;
import entity.Admin_Galaxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/13.
 */
public class AdminDaoImpl_Galaxy extends BaseDao implements AdminDao_Galaxy {

    public int checkUser_Galaxy(Admin_Galaxy admin_galaxy) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt =null;
        ResultSet rs = null;
        Admin_Galaxy admin_galaxy1=null;
        String sql ="select * from admin";

        boolean has_username = false;
        boolean password_correct=false;

        try {
            conn=this.getConnection();
            stmt=conn.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            rs=stmt.getResultSet();
            while (rs.next()){
                String temp_username = rs.getString("username").trim();
                String temp_password = rs.getString("password").trim();
                if(admin_galaxy.getUsername().equals(temp_username)){
                    has_username=true;
                    if(admin_galaxy.getPassword().equals(password_correct)){
                        password_correct=true;
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,stmt,rs);
        }

        if(has_username==true){
            if(password_correct==true){
                return 0;
            }else {
                return 1;
            }
        }else {
            return 2;
        }

    }
}
