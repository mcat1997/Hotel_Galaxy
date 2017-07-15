package dao.impl;

import dao.BaseDao;
import dao.CheckInOutDao_Galaxy;
import dao.CustomerDao_Galaxy;
import dao.RoomDao_Galaxy;
import entity.CheckInOut_Galaxy;
import entity.Customer_Galaxy;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                if(rs.getString("cId").equals(checkInOut_galaxy.getcId())){
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
        String sql ="Insert into checkinout(dateIn, dateOut, cId, rNum, sumPrice)Values(?,?,?,?,?)";
        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setDate(1,java.sql.Date.valueOf(checkInOut_galaxy.getDateIn()));
            if(checkInOut_galaxy.getDateOut()!=null){
            pstmt.setDate(2, java.sql.Date.valueOf(checkInOut_galaxy.getDateOut()));
            }else {
                pstmt.setDate(2,null);
            }
            pstmt.setString(3,checkInOut_galaxy.getcId());
            pstmt.setString(4,checkInOut_galaxy.getrNum());
            pstmt.setFloat(5,checkInOut_galaxy.getSumPrice());
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
    }

    public void change_Galaxy(CheckInOut_Galaxy checkInOut_galaxy) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="UPDATE checkinout SET dateOut = ?, sumPrice = ? WHERE cId = ? AND sumPrice = ?";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setDate(1,java.sql.Date.valueOf(checkInOut_galaxy.getDateOut()));
            pstmt.setFloat(2,checkInOut_galaxy.getSumPrice());
            pstmt.setString(3,checkInOut_galaxy.getcId());
            pstmt.setFloat(4,0);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("存储checkinout失败");
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
    }

    public CheckInOut_Galaxy select_Galaxy(String rNum) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="SELECT * FROM checkinout WHERE rNum = ?";

        CheckInOut_Galaxy checkInOut_galaxy=new CheckInOut_Galaxy();

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1,rNum);
            rs=pstmt.executeQuery();
            RoomDao_Galaxy roomDao_galaxy = new RoomDaoImpl_Galaxy();
            CustomerDao_Galaxy customerDao_galaxy=new CustomerDaoImpl_Galaxy();
            while (rs.next()){
                if(rs.getFloat("sumPrice")==0){
                    checkInOut_galaxy.setDateIn(rs.getDate("dateIn").toString());
                    if(rs.getDate("dateOut")!=null){
                        checkInOut_galaxy.setDateOut(rs.getDate("dateOut").toString());
                    }
                    checkInOut_galaxy.setrNum(rNum);
                    checkInOut_galaxy.setcId(rs.getString("cId"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return checkInOut_galaxy;
    }

    public List<CheckInOut_Galaxy> list() throws SQLException {
        List<CheckInOut_Galaxy> list=new ArrayList<CheckInOut_Galaxy>();
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="select * from checkinout";
        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                CheckInOut_Galaxy checkInOut_galaxy=new CheckInOut_Galaxy();

                checkInOut_galaxy.setDateIn(rs.getDate("DateIn").toString());
                if(rs.getDate("DateOut")!=null) {
                    checkInOut_galaxy.setDateOut(rs.getDate("DateOut").toString());
                }
                checkInOut_galaxy.setcId(rs.getString("cId"));
                checkInOut_galaxy.setrNum(rs.getString("rNum"));
                checkInOut_galaxy.setSumPrice(rs.getFloat("sumPrice"));
                checkInOut_galaxy.setId(rs.getInt("id"));
                list.add(checkInOut_galaxy);

            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.closeAll(conn,pstmt,rs);
        }
        return list;
    }

    public boolean isDone_Galaxy(String cId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="SELECT * FROM checkinout";
        boolean is=false;
        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            boolean is_cId=false;
            boolean is_sumPrice=false;

            while (rs.next()){
                if(rs.getString("cId").equals(cId)){
                    is_cId=true;
                    if(rs.getFloat("sumPrice")!=0){
                        is_sumPrice=true;
                    }
                }
            }
            is=(!is_cId)||is_sumPrice;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }



        return is;
    }

    public void del_Galaxy(int id)throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="DELETE FROM checkinout WHERE id=?";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
    }


}
