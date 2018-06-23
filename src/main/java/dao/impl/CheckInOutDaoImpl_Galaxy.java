package dao.impl;

import dao.BaseDao;
import dao.CheckInOutDao_Galaxy;
import dao.CustomerDao_Galaxy;
import dao.RoomDao_Galaxy;
import entity.CheckInOut_Galaxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public class CheckInOutDaoImpl_Galaxy extends BaseDao implements CheckInOutDao_Galaxy {
//    public boolean check_Galaxy(CheckInOut_Galaxy checkInOut_galaxy) throws SQLException {
//        //查询订单是否存在
//        boolean is = true;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        String sql = "SELECT checkId from checkinout";
//
//        try {
//            conn = this.getConnection();
//            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                if (checkInOut_galaxy.getCheckId() == rs.getInt("checkId")) {
//                    is = false;
//                }
//
//            }
//        } catch (SQLException e) {
//            is = false;
//            e.printStackTrace();
//        } finally {
//            this.closeAll(conn, pstmt, rs);
//        }
//
//
//        return is;
//    }

    public void add_Galaxy(CheckInOut_Galaxy checkInOut_galaxy) {
        //增加订单
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "Insert into checkinout(dateIn, dateOut, cId, rNum,sumPrice)Values(?,?,?,?,?)";
        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf(checkInOut_galaxy.getDateIn()));
            if (checkInOut_galaxy.getDateOut() != null) {
                pstmt.setDate(2, java.sql.Date.valueOf(checkInOut_galaxy.getDateOut()));
            } else {
                pstmt.setDate(2, null);
            }
            pstmt.setString(3, checkInOut_galaxy.getcId());
            pstmt.setString(4, checkInOut_galaxy.getrNum());
            pstmt.setFloat(5, checkInOut_galaxy.getSumPrice());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
    }

    public void change_Galaxy(CheckInOut_Galaxy checkInOut_galaxy) {
        //完成订单
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "UPDATE checkinout SET dateOut = ?,sumPrice = ? WHERE checkId=?";

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf(checkInOut_galaxy.getDateOut()));
            pstmt.setFloat(2, checkInOut_galaxy.getSumPrice());
            pstmt.setInt(3, checkInOut_galaxy.getCheckId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("存储checkinout失败");
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
    }

    public CheckInOut_Galaxy select_Galaxy(String rNum) {
        //根据房号获取未完成订单
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM checkinout WHERE rNum = ?";

        CheckInOut_Galaxy checkInOut_galaxy = new CheckInOut_Galaxy();

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rNum);
            rs = pstmt.executeQuery();
            RoomDao_Galaxy roomDao_galaxy = new RoomDaoImpl_Galaxy();
            CustomerDao_Galaxy customerDao_galaxy = new CustomerDaoImpl_Galaxy();
            while (rs.next()) {
                if (rs.getFloat("sumPrice") == 0) {
                    checkInOut_galaxy.setDateIn(rs.getDate("dateIn").toString());
                    if (rs.getDate("dateOut") != null) {
                        checkInOut_galaxy.setDateOut(rs.getDate("dateOut").toString());
                    }
                    checkInOut_galaxy.setrNum(rNum);
                    checkInOut_galaxy.setcId(rs.getString("cId"));
                    checkInOut_galaxy.setCheckId(rs.getInt("checkId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkInOut_galaxy;
    }

    public List<CheckInOut_Galaxy> list() {
        //获取全部订单
        List<CheckInOut_Galaxy> list = new ArrayList<CheckInOut_Galaxy>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from checkinout";
        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CheckInOut_Galaxy checkInOut_galaxy = new CheckInOut_Galaxy();

                checkInOut_galaxy.setDateIn(rs.getDate("DateIn").toString());
                if (rs.getDate("DateOut") != null) {
                    checkInOut_galaxy.setDateOut(rs.getDate("DateOut").toString());
                }
                checkInOut_galaxy.setcId(rs.getString("cId"));
                checkInOut_galaxy.setrNum(rs.getString("rNum"));
                checkInOut_galaxy.setSumPrice(rs.getFloat("sumPrice"));
                checkInOut_galaxy.setCheckId(rs.getInt("checkId"));
                list.add(checkInOut_galaxy);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return list;
    }

    public boolean isDone_Galaxy(String cId) {
        //判断此用户身份证所在的订单是否全部完成
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT cId,sumPrice FROM checkinout";
        boolean is = true;
        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            //boolean is_cId = false;
            //boolean is_sumPrice = false;

            while (rs.next()) {
                if (rs.getString("cId").equals(cId)) {
                    //is_cId = true;
                    if (rs.getFloat("sumPrice") == 0) {
                        //is_sumPrice = true;
                        is = false;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }


        return is;
    }

    public void del_Galaxy(int checkId) {
        //根据订单id删除订单
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "DELETE FROM checkinout WHERE checkId=?";

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, checkId);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
    }


}
