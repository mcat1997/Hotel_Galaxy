package servlet;

import dao.CustomerDao_Galaxy;
import dao.impl.CustomerDaoImpl_Galaxy;
import entity.Customer_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by a3899 on 2017/7/14.
 */
public class CustomerServlet_Galaxy extends HttpServlet {
    public CustomerServlet_Galaxy() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao_Galaxy customerDao_galaxy = new CustomerDaoImpl_Galaxy();
        List<Customer_Galaxy> list = null;
        try {
            list = customerDao_galaxy.list();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("customerList", list);
        request.getRequestDispatcher("/customer_galaxy.jsp").forward(request, response);

    }
}
