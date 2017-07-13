package dao;

import entity.Admin_Galaxy;

import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/13.
 */
public interface AdminDao_Galaxy {
    int checkUser_Galaxy(Admin_Galaxy admin_galaxy) throws SQLException;
}
