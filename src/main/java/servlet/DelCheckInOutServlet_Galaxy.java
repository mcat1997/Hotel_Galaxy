package servlet;

import dao.CheckInOutDao_Galaxy;
import dao.CustomerDao_Galaxy;
import dao.RoomDao_Galaxy;
import dao.impl.CheckInOutDaoImpl_Galaxy;
import dao.impl.CustomerDaoImpl_Galaxy;
import dao.impl.RoomDaoImpl_Galaxy;
import entity.CheckInOut_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a3899 on 2017/7/15.
 */
public class DelCheckInOutServlet_Galaxy extends HttpServlet {
    public DelCheckInOutServlet_Galaxy(){super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        if (request.getSession().getAttribute("username") == null) {
            request.setAttribute("info", "请先登录");
            request.getRequestDispatcher("/login_galaxy.jsp").forward(request, response);
        } else {
            int id=Integer.parseInt(request.getParameter("id"));
            CheckInOutDao_Galaxy checkInOutDao_galaxy=new CheckInOutDaoImpl_Galaxy();
            try {
                checkInOutDao_galaxy.del_Galaxy(id);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("info","删除失败");
                request.getRequestDispatcher("/allert.jsp").forward(request,response);
            }
            request.setAttribute("info","删除成功");
            request.getRequestDispatcher("/allert.jsp").forward(request,response);

        }




    }
}
