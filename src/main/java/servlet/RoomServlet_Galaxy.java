package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by a3899 on 2017/7/12.
 */
public class RoomServlet_Galaxy extends HttpServlet {

    public RoomServlet_Galaxy(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {

        if (request.getSession().getAttribute("username") == null) {
            request.setAttribute("info", "请先登录");
            request.getRequestDispatcher("/login_galaxy.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/room_galaxy.jsp").forward(request, response);
        }
    }
}
