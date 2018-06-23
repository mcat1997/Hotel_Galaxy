package dao;

import entity.CheckInOut_Galaxy;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public interface CheckInOutDao_Galaxy {
    void add_Galaxy(CheckInOut_Galaxy checkInOut_galaxy) throws SQLException;//增加订单

    //    boolean check_Galaxy(CheckInOut_Galaxy checkInOut_galaxy)throws  SQLException;//查询客户是否有订单未完成
    void change_Galaxy(CheckInOut_Galaxy checkInOut_galaxy) throws SQLException;//完成订单

    CheckInOut_Galaxy select_Galaxy(String rNum) throws SQLException;//根据房号获取订单

    List<CheckInOut_Galaxy> list() throws SQLException;//获取全部订单

    boolean isDone_Galaxy(String cId) throws SQLException;//判断此用户身份证所在的订单是否全部完成

    void del_Galaxy(int id) throws SQLException;//根据订单id删除订单
}
