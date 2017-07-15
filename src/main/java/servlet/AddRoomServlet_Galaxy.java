package servlet;

import dao.RoomDao_Galaxy;
import dao.impl.RoomDaoImpl_Galaxy;
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
public class AddRoomServlet_Galaxy extends HttpServlet {

    public AddRoomServlet_Galaxy(){super();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        if (request.getSession().getAttribute("username") == null) {
            request.setAttribute("info", "请先登录");
            request.getRequestDispatcher("/login_galaxy.jsp").forward(request, response);
        } else {
            String rNum = request.getParameter("rNum");
            String rType = request.getParameter("rType");
            float rPrice = Float.parseFloat(request.getParameter("rPrice"));
            boolean rState = true;

            Room_Galaxy room_galaxy = new Room_Galaxy(rNum, rType, rPrice, rState);

            RoomDao_Galaxy roomDao_galaxy = new RoomDaoImpl_Galaxy();

            try {
                if (!roomDao_galaxy.isRNum(rNum)) {
                    roomDao_galaxy.add_Galaxy(room_galaxy);
                    request.setAttribute("info","添加成功");
                    request.getRequestDispatcher("/allert.jsp").forward(request,response);
                } else {
                    request.setAttribute("info","已有此房间");
                    request.getRequestDispatcher("/room_add_galaxy,jsp").forward(request,response);
                }


            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("info","添加失败");
                request.getRequestDispatcher("/room_add_galaxy.jsp").forward(request,response);
            }

        }

    }
}
