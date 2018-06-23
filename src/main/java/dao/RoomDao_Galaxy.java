package dao;

import entity.Room_Galaxy;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public interface RoomDao_Galaxy {
    List<Room_Galaxy> list() throws SQLException;

    Room_Galaxy select_Galaxy(String rNum) throws SQLException;

    void setrState(String rNum) throws SQLException;

    boolean isRNum(String rNum) throws SQLException;

    void add_Galaxy(Room_Galaxy room_galaxy) throws SQLException;

    void edit_Galaxy(Room_Galaxy room_galaxy) throws SQLException;

    void del_Galaxy(String rNum) throws SQLException;
}
