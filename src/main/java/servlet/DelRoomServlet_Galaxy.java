package servlet;

import dao.RoomDao_Galaxy;
import dao.impl.RoomDaoImpl_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/15.
 */
public class DelRoomServlet_Galaxy extends HttpServlet {

    public DelRoomServlet_Galaxy() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rNum = request.getParameter("rNum");

        RoomDao_Galaxy roomDao_galaxy = new RoomDaoImpl_Galaxy();

        try {
            roomDao_galaxy.del_Galaxy(rNum);
            request.setAttribute("info", "删除成功");
            request.getRequestDispatcher("/allert.jsp").forward(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("info", "删除失败");
            request.getRequestDispatcher("/allert.jsp").forward(request, response);
        }


    }
}
