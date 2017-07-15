package servlet;

import dao.AdminDao_Galaxy;
import dao.impl.AdminDaoImpl_Galaxy;
import entity.Admin_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/10.
 */
public class LoginServlet_Galaxy extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

//        String rnum = req.getParameter("rnum");
//        System.out.println(rnum);

        Admin_Galaxy admin_galaxy=new Admin_Galaxy(username,password);
        AdminDao_Galaxy adminDao_galaxy=new AdminDaoImpl_Galaxy();
        int re = 0;
        try {
            re = adminDao_galaxy.checkUser_Galaxy(admin_galaxy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(re==0){
            req.getSession(true).setAttribute("username",username);
            req.getSession().setMaxInactiveInterval(600);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else if(re==1){
            req.setAttribute("info","没有此用户名");
            req.getRequestDispatcher("/login_galaxy.jsp").forward(req,resp);
        }else if(re==2){
            req.setAttribute("info","密码错误");
            req.getRequestDispatcher("/login_galaxy.jsp").forward(req,resp);
        }
    }
}
