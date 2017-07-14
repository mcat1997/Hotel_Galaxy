package dao.impl;

import dao.BaseDao;
import dao.CheckInOutDao_Galaxy;
import entity.CheckInOut_Galaxy;

import java.sql.*;
import java.text.ParseException;

/**
 * Created by a3899 on 2017/7/13.
 */
public class CheckInOutDaoImpl_Galaxy extends BaseDao implements CheckInOutDao_Galaxy {
    public boolean check_Galaxy(CheckInOut_Galaxy checkInOut_galaxy) throws SQLException {
        boolean is=true;
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="SELECT * from checkinout";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                if(rs.getString("cId").equals(checkInOut_galaxy.getCustomer_galaxy().getcId())){
                    if(rs.getInt("sumPrice")==0){
                        is=false;
                    }
                }

            }
        }catch (SQLException e){
            is=false;
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }


        return is;
    }

    public void add_Galaxy(CheckInOut_Galaxy checkInOut_galaxy)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="Insert into checkinout Values(?,?,?,?,?)";
        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setDate(1, new java.sql.Date( checkInOut_galaxy.getDateIn().getTime()));
            if(checkInOut_galaxy.getDateOut()!=null){
            pstmt.setDate(2, new java.sql.Date( checkInOut_galaxy.getDateOut().getTime()));
            }else {
                pstmt.setDate(2,null);
            }
            pstmt.setString(3,checkInOut_galaxy.getCustomer_galaxy().getcId());
            pstmt.setString(4,checkInOut_galaxy.getRoom_galaxy().getRnum());
            pstmt.setFloat(5,checkInOut_galaxy.getSumPrice());
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
    }
}
