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
import java.util.List;

/**
 * Created by a3899 on 2017/7/12.
 */
public class RoomServlet_Galaxy extends HttpServlet {

    public RoomServlet_Galaxy() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RoomDao_Galaxy roomDao_galaxy = new RoomDaoImpl_Galaxy();
        List<Room_Galaxy> list = null;
        try {
            list = roomDao_galaxy.list();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("roomList", list);
        request.getRequestDispatcher("/room_galaxy.jsp").forward(request, response);

    }
}
