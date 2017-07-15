package servlet;

import dao.CheckInOutDao_Galaxy;
import dao.RoomDao_Galaxy;
import dao.impl.CheckInOutDaoImpl_Galaxy;
import dao.impl.RoomDaoImpl_Galaxy;
import entity.CheckInOut_Galaxy;
import entity.Room_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by a3899 on 2017/7/14.
 */
public class LeaveRoomServlet_Galaxy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String cId=request.getParameter("cId");
        String rNum=request.getParameter("rNum");
        String dateOut=request.getParameter("dateOut");

        //判断房号是否正确
        RoomDao_Galaxy roomDao_galaxy=new RoomDaoImpl_Galaxy();
        try {
            if(roomDao_galaxy.isRNum(rNum)){
                //获取房间信息
                Room_Galaxy room_galaxy=roomDao_galaxy.select_Galaxy(rNum);
                if(!room_galaxy.isRstate()){
                    CheckInOutDao_Galaxy checkInOutDao_galaxy=new CheckInOutDaoImpl_Galaxy();
                    CheckInOut_Galaxy checkInOut_galaxy = checkInOutDao_galaxy.select_Galaxy(rNum);
                    float sumPrice=0;
                    try {
                        checkInOut_galaxy.setDateOut(dateOut);
                    }catch (ParseException e) {
                        e.printStackTrace();
                        request.setAttribute("info", "日期格式错误");
                        request.getRequestDispatcher("/leaveRoom_Galaxy.jsp").forward(request, response);
                    }
                    sumPrice=(checkInOut_galaxy.getDateOut().getTime()-checkInOut_galaxy.getDateIn().getTime())*checkInOut_galaxy.getRoom_galaxy().getRprice()/(24*60*60*1000);
                    checkInOut_galaxy.setSumPrice(sumPrice);
                    System.out.println(checkInOut_galaxy.getSumPrice());
                    checkInOutDao_galaxy.change_Galaxy(checkInOut_galaxy);
                    roomDao_galaxy.setrState(checkInOut_galaxy.getRoom_galaxy());
                    request.setAttribute("info","退房成功");
                    request.setAttribute("info2","房价为"+checkInOut_galaxy.getSumPrice()+"元");
                    request.getRequestDispatcher("/allert.jsp").forward(request,response);

                }else {
                    request.setAttribute("info","此房间未订出");
                    request.getRequestDispatcher("/leaveRoom_Galaxy.jsp").forward(request,response);
                }

            }else {
                request.setAttribute("info","房号错误");
                request.getRequestDispatcher("/leaveRoom_Galaxy.jsp").forward(request,response);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
