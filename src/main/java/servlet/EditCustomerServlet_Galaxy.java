package servlet;

import dao.CustomerDao_Galaxy;
import dao.RoomDao_Galaxy;
import dao.impl.CustomerDaoImpl_Galaxy;
import dao.impl.RoomDaoImpl_Galaxy;
import entity.Customer_Galaxy;
import entity.Room_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/15.
 */
public class EditCustomerServlet_Galaxy extends HttpServlet {
    public EditCustomerServlet_Galaxy(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        if (request.getSession().getAttribute("username") == null) {
            request.setAttribute("info", "请先登录");
            request.getRequestDispatcher("/login_galaxy.jsp").forward(request, response);
        } else {
            String cId = request.getParameter("cId");
            String cName = request.getParameter("cName");
            String cSex=request.getParameter("cSex");
            String cPhone=request.getParameter("cPhone");

            Customer_Galaxy customer_galaxy=new Customer_Galaxy(cId,cName,cSex,cPhone);

            CustomerDao_Galaxy customerDao_galaxy=new CustomerDaoImpl_Galaxy();

            try {

                customerDao_galaxy.edit_Galaxy(customer_galaxy);
                request.setAttribute("info","编辑成功");
                request.getRequestDispatcher("/allert.jsp").forward(request,response);


            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("info","编辑失败");
                request.getRequestDispatcher("/allert.jsp").forward(request,response);
            }

        }
    }

}
