package servlet;

import dao.CheckInOutDao_Galaxy;
import dao.CustomerDao_Galaxy;
import dao.RoomDao_Galaxy;
import dao.impl.CheckInOutDaoImpl_Galaxy;
import dao.impl.CustomerDaoImpl_Galaxy;
import dao.impl.RoomDaoImpl_Galaxy;
import entity.CheckInOut_Galaxy;
import entity.Customer_Galaxy;
import entity.Room_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/14.
 */
public class BookRoomServlet_Galaxy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cId = request.getParameter("cId");
        String cName = request.getParameter("cName");
        String cSex = request.getParameter("cSex");
        String cPhone = request.getParameter("cPhone");
        String rNum = request.getParameter("rNum");
        String dateIn = request.getParameter("dateIn");
        System.out.println(rNum);

        //判断房号是否正确
        RoomDao_Galaxy roomDao_galaxy = new RoomDaoImpl_Galaxy();
        try {
            if (roomDao_galaxy.isRNum(rNum)) {
                //获取房间信息
                Room_Galaxy room_galaxy = roomDao_galaxy.select_Galaxy(rNum);
                if (room_galaxy.isrState()) {

                    //添加客户信息
                    Customer_Galaxy customer_galaxy = new Customer_Galaxy();
                    customer_galaxy.setcId(cId);
                    customer_galaxy.setcName(cName);
                    customer_galaxy.setcPhone(cPhone);
                    customer_galaxy.setcSex(cSex);
                    CustomerDao_Galaxy customerDao_galaxy = new CustomerDaoImpl_Galaxy();
                    try {
                        customerDao_galaxy.add_Galaxy(customer_galaxy);
                    } catch (SQLException e) {
                        request.setAttribute("info", "客户信息添加失败");
                        request.getRequestDispatcher("/bookRoom_Galaxy.jsp").forward(request, response);
                        e.printStackTrace();
                    }//try customerDao_galaxy.add_Galaxy(customer_galaxy);

                    //添加订单信息
                    CheckInOut_Galaxy checkInOut_galaxy = new CheckInOut_Galaxy();
                    checkInOut_galaxy.setDateIn(dateIn);
                    checkInOut_galaxy.setcId(cId);
                    checkInOut_galaxy.setrNum(rNum);
                    checkInOut_galaxy.setSumPrice(0);

                    //存储订单信息
                    try {
                        CheckInOutDao_Galaxy checkInOutDao_galaxy = new CheckInOutDaoImpl_Galaxy();
                        if (checkInOutDao_galaxy.isDone_Galaxy(cId)) {
                            checkInOutDao_galaxy.add_Galaxy(checkInOut_galaxy);
                            roomDao_galaxy.setrState(room_galaxy.getrNum());
                            request.setAttribute("info", "订房成功");
                            request.getRequestDispatcher("/allert.jsp").forward(request, response);
                        } else {
                            request.setAttribute("info", "您已订过房间，请退房后再进行订房");
                            request.getRequestDispatcher("/bookRoom_Galaxy.jsp").forward(request, response);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        request.setAttribute("info", "存储信息失败");
                        request.getRequestDispatcher("/bookRoom_Galaxy.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("info", "此房间已订出");
                    request.getRequestDispatcher("/bookRoom_Galaxy.jsp").forward(request, response);
                }//if(room_galaxy.isRstate())
            } else {
                request.setAttribute("info", "房号错误");
                request.getRequestDispatcher("/bookRoom_Galaxy.jsp").forward(request, response);
            }//if(roomDao_galaxy.isRNum(rNum))
        } catch (SQLException e) {
            request.setAttribute("info", "数据库操作出错");
            request.getRequestDispatcher("/bookRoom_Galaxy.jsp").forward(request, response);
            e.printStackTrace();
        }//最外层try

    }//doPost


}
