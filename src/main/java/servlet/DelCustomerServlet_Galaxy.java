package servlet;

import dao.CheckInOutDao_Galaxy;
import dao.CustomerDao_Galaxy;
import dao.impl.CheckInOutDaoImpl_Galaxy;
import dao.impl.CustomerDaoImpl_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * Created by a3899 on 2017/7/15.
 */
public class DelCustomerServlet_Galaxy extends HttpServlet {
    public DelCustomerServlet_Galaxy(){super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        if (request.getSession().getAttribute("username") == null) {
            request.setAttribute("info", "请先登录");
            request.getRequestDispatcher("/login_galaxy.jsp").forward(request, response);
        } else {
            String cId=request.getParameter("cId");
            try {
                CheckInOutDao_Galaxy checkInOutDao_galaxy=new CheckInOutDaoImpl_Galaxy();
                if(checkInOutDao_galaxy.isDone_Galaxy(cId)){
                    CustomerDao_Galaxy customerDao_galaxy=new CustomerDaoImpl_Galaxy();
                    customerDao_galaxy.del_Galaxy(cId);
                    request.setAttribute("info","删除成功");
                    request.getRequestDispatcher("/allert.jsp").forward(request,response);
                }else {
                    request.setAttribute("info","此人还有订单未完成");
                    request.setAttribute("info2","无法删除");
                    request.getRequestDispatcher("/allert.jsp").forward(request,response);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }




        }



    }
}
