package servlet;

import dao.CheckInOutDao_Galaxy;
import dao.impl.CheckInOutDaoImpl_Galaxy;
import entity.CheckInOut_Galaxy;

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
public class CheckInOutServlet_Galaxy extends HttpServlet {
    public CheckInOutServlet_Galaxy(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        if (request.getSession().getAttribute("username") == null) {
            request.setAttribute("info", "请先登录");
            request.getRequestDispatcher("/login_galaxy.jsp").forward(request, response);
        } else{
            CheckInOutDao_Galaxy checkInOutDao_galaxy=new CheckInOutDaoImpl_Galaxy();
            List<CheckInOut_Galaxy> list=null;
            try {
               list=checkInOutDao_galaxy.list();
            }catch (SQLException e){
                e.printStackTrace();
            }

            request.setAttribute("checkinoutList",list);
            request.getRequestDispatcher("/checkinout_galaxy.jsp").forward(request, response);

        }
    }
}
