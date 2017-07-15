package dao;

import entity.CheckInOut_Galaxy;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public interface CheckInOutDao_Galaxy {
    void add_Galaxy(CheckInOut_Galaxy checkInOut_galaxy)throws SQLException;
    boolean check_Galaxy(CheckInOut_Galaxy checkInOut_galaxy)throws  SQLException;
    void change_Galaxy(CheckInOut_Galaxy checkInOut_galaxy)throws SQLException;
    CheckInOut_Galaxy select_Galaxy(String rNum)throws SQLException;
    List<CheckInOut_Galaxy> list()throws SQLException;
    boolean isDone_Galaxy(String cId)throws SQLException;
    void del_Galaxy(int id)throws SQLException;
}
