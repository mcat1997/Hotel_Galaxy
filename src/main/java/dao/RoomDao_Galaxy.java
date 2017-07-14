package dao;

import entity.Room_Galaxy;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public interface RoomDao_Galaxy {
    List<Room_Galaxy> list()throws SQLException;
    Room_Galaxy select_Galaxy(String rNum)throws SQLException;
    void setrState(Room_Galaxy room_galaxy)throws SQLException;
    boolean isRNum(String rNum)throws SQLException;
}
