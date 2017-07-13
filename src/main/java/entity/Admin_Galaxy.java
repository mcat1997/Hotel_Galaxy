package entity;

/**
 * Created by a3899 on 2017/7/13.
 */
public class Admin_Galaxy {
    private String username;
    private String password;

    public Admin_Galaxy(){

    }
    public Admin_Galaxy(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
