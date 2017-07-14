package dao;

import entity.CheckInOut_Galaxy;

import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/13.
 */
public interface CheckInOutDao_Galaxy {
    void add_Galaxy(CheckInOut_Galaxy checkInOut_galaxy)throws SQLException;
    boolean check_Galaxy(CheckInOut_Galaxy checkInOut_galaxy)throws  SQLException;
}
