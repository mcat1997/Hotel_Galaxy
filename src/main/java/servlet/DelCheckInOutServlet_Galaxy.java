package servlet;

import dao.CheckInOutDao_Galaxy;
import dao.impl.CheckInOutDaoImpl_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/15.
 */
public class DelCheckInOutServlet_Galaxy extends HttpServlet {
    public DelCheckInOutServlet_Galaxy() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int checkId = Integer.parseInt(request.getParameter("checkId"));
        CheckInOutDao_Galaxy checkInOutDao_galaxy = new CheckInOutDaoImpl_Galaxy();
        try {
            checkInOutDao_galaxy.del_Galaxy(checkId);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("info", "删除失败");
            request.getRequestDispatcher("/allert.jsp").forward(request, response);
        }
        request.setAttribute("info", "删除成功");
        request.getRequestDispatcher("/allert.jsp").forward(request, response);


    }
}
