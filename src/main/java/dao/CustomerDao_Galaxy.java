package dao;

import entity.Customer_Galaxy;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by a3899 on 2017/7/13.
 */
public interface CustomerDao_Galaxy {
    void add_Galaxy(Customer_Galaxy customer_galaxy) throws SQLException;

    Customer_Galaxy select_Galaxy(String cId) throws SQLException;

    List<Customer_Galaxy> list() throws SQLException;

    void edit_Galaxy(Customer_Galaxy customer_galaxy) throws SQLException;

    void del_Galaxy(String cId) throws SQLException;
}
