package servlet;

import sql.Sql_Connect_Galaxy;
import sql.Sql_Mgr_Galaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by a3899 on 2017/7/10.
 */
public class LoginServlet_Galaxy extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Sql_Mgr_Galaxy sql_mgr_galaxy = new Sql_Mgr_Galaxy();
        int re = sql_mgr_galaxy.checkUser_Galaxy(username,password);
        if(re==0){
            req.getSession(true).setAttribute("username",username);
            req.getSession().setMaxInactiveInterval(60);
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
