package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by a3899 on 2017/7/10.
 */
public class Sql_Mgr_Galaxy {

    public int checkUser_Galaxy(String username,String password){

        Sql_Connect_Galaxy sql_connect_galaxy = new Sql_Connect_Galaxy();

        boolean has_username = false;
        boolean password_correct=false;
        ResultSet rs=null;
        try{
            rs = sql_connect_galaxy.execSQL_Galaxy("select * from address");
        }catch (SQLException e ){
            System.out.println("查询数据库出错");
            e.printStackTrace();
        }

        try{
            while(rs.next()){
                String temp_username = rs.getString("stu_name").trim();
                String temp_password = rs.getString("stu_num").trim();
                if(username.equals(temp_username)){
                    has_username=true;
                    if(password.equals(temp_password)){
                        password_correct=true;
                        return 0;
                    }
                    return 1;
                }
            }
        }catch (SQLException e){
            System.out.println("操作resultSet出错");
            e.printStackTrace();
        }
        sql_connect_galaxy.closeSQLConn_Galaxy();
        return 2;


    }
}
