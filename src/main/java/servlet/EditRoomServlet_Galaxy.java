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
public class EditRoomServlet_Galaxy extends HttpServlet {

    public EditRoomServlet_Galaxy() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rNum = request.getParameter("rNum");
        String rType = request.getParameter("rType");
        float rPrice = Float.parseFloat(request.getParameter("rPrice"));
        boolean rState = true;

        Room_Galaxy room_galaxy = new Room_Galaxy(rNum, rType, rPrice, rState);

        RoomDao_Galaxy roomDao_galaxy = new RoomDaoImpl_Galaxy();

        try {
            roomDao_galaxy.edit_Galaxy(room_galaxy);
            request.setAttribute("info", "编辑成功");
            request.getRequestDispatcher("/allert.jsp").forward(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("info", "编辑失败");
            request.getRequestDispatcher("/allert.jsp").forward(request, response);
        }

    }

}
