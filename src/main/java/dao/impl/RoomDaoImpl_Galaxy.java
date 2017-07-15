package dao.impl;

import dao.BaseDao;
import dao.RoomDao_Galaxy;
import entity.Room_Galaxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public class RoomDaoImpl_Galaxy extends BaseDao implements RoomDao_Galaxy {
    public List<Room_Galaxy> list() throws SQLException {
        List<Room_Galaxy> list=new ArrayList<Room_Galaxy>();

        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="select * from room";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement) conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Room_Galaxy room_galaxy=new Room_Galaxy();
                room_galaxy.setRnum(rs.getString("rNum").trim());
                room_galaxy.setRprice(rs.getFloat("rPrice"));
                room_galaxy.setRstate(rs.getBoolean("rState"));
                room_galaxy.setRtype(rs.getString("rType").trim());
                list.add(room_galaxy);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }

        return list;
    }

    public Room_Galaxy select_Galaxy(String rNum) throws SQLException {
        Room_Galaxy room_galaxy=new Room_Galaxy();
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="select * from room";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement) conn.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            rs=pstmt.executeQuery();
            while (rs.next()){
                if(rs.getString("rNum").equals(rNum)){
                    room_galaxy.setRnum(rNum);
                    room_galaxy.setRtype(rs.getString("rType"));
                    room_galaxy.setRprice(rs.getFloat("rPrice"));
                    room_galaxy.setRstate(rs.getBoolean("rState"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }

        return room_galaxy;
    }

    public void setrState(Room_Galaxy room_galaxy) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="UPDATE room SET rState=? where rNum=?";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setBoolean(1,!room_galaxy.isRstate());
            pstmt.setString(2,room_galaxy.getRnum());
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
    }

    public boolean isRNum(String rNum)throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="select * from room";
        boolean is=false;

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                if(rs.getString("rNum").equals(rNum)){
                    is=true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }

        return is;
    }

    public void add_Galaxy(Room_Galaxy room_galaxy) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="Insert into room Values(?,?,?,?)";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1,room_galaxy.getRnum());
            pstmt.setString(2,room_galaxy.getRtype());
            pstmt.setFloat(3,room_galaxy.getRprice());
            pstmt.setBoolean(4,room_galaxy.isRstate());
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
    }

    public void edit_Galaxy(Room_Galaxy room_galaxy) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql ="UPDATE room SET rType=? , rPrice=? WHERE rNum=?";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1,room_galaxy.getRtype());
            pstmt.setFloat(2,room_galaxy.getRprice());
            pstmt.setString(3,room_galaxy.getRnum());
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }





    }

    public void del_Galaxy(String rNum) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        String sql="DELETE FROM room WHERE rNum=?";

        try {
            conn=this.getConnection();
            pstmt=(PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1,rNum);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }


    }
}
