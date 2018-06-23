package dao.impl;

import dao.BaseDao;
import dao.CustomerDao_Galaxy;
import entity.Customer_Galaxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public class CustomerDaoImpl_Galaxy extends BaseDao implements CustomerDao_Galaxy {
    public void add_Galaxy(Customer_Galaxy customer_galaxy) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from customer";

        boolean has_id = false;

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("cId").equals(customer_galaxy.getcId())) {
                    has_id = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }


        if (has_id) {
            sql = "UPDATE customer SET cName=?,cSex=?,cPhone=? WHERE cId=?";
            try {
                conn = this.getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, customer_galaxy.getcName());
                pstmt.setString(2, customer_galaxy.getcSex());
                pstmt.setString(3, customer_galaxy.getcPhone());
                pstmt.setString(4, customer_galaxy.getcId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.closeAll(conn, pstmt, rs);
            }

        } else {
            sql = "INSERT INTO customer(cId,cName,cSex,cPhone) VALUES(?,?,?,?)";
            try {
                conn = this.getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, customer_galaxy.getcId());
                pstmt.setString(2, customer_galaxy.getcName());
                pstmt.setString(3, customer_galaxy.getcSex());
                pstmt.setString(4, customer_galaxy.getcPhone());
                pstmt.executeUpdate();
                System.out.println("增加用户信息成功");
            } catch (SQLException e) {
                System.out.println("增加用户信息失败");
                e.printStackTrace();
            } finally {
                this.closeAll(conn, pstmt, rs);
            }
        }
    }

    public Customer_Galaxy select_Galaxy(String cId) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from customer";
        Customer_Galaxy customer_galaxy = new Customer_Galaxy();

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (cId.equals(cId)) {
                    customer_galaxy.setcSex(rs.getString("cSex"));
                    customer_galaxy.setcPhone(rs.getString("cPhone"));
                    customer_galaxy.setcName(rs.getString("cName"));
                    customer_galaxy.setcId(cId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }

        return customer_galaxy;
    }

    public List<Customer_Galaxy> list() {
        List<Customer_Galaxy> list = new ArrayList<Customer_Galaxy>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from customer";

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer_Galaxy customer_galaxy = new Customer_Galaxy();
                customer_galaxy.setcId(rs.getString("cId"));
                customer_galaxy.setcName(rs.getString("cName"));
                customer_galaxy.setcSex(rs.getString("cSex"));
                customer_galaxy.setcPhone(rs.getString("cPhone"));
                list.add(customer_galaxy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }

        return list;
    }

    public void edit_Galaxy(Customer_Galaxy customer_galaxy) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "UPDATE customer SET cName=?,cSex=?,cPhone=? WHERE cId=?";

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer_galaxy.getcName());
            pstmt.setString(2, customer_galaxy.getcSex());
            pstmt.setString(3, customer_galaxy.getcPhone());
            pstmt.setString(4, customer_galaxy.getcId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }


    }

    public void del_Galaxy(String cId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "DELETE FROM customer WHERE cId=?";

        try {
            conn = this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cId);
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }

    }
}
