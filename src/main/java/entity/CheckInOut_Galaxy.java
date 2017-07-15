package entity;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a3899 on 2017/7/13.
 */
public class CheckInOut_Galaxy {
    private String dateIn;
    private String dateOut;
    private String cId;
    private String rNum;
    private float sumPrice;
    private int id;

    public CheckInOut_Galaxy(){
        dateIn=null;
        dateOut=null;
        cId=null;
        rNum=null;
        sumPrice=0;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn){
        this.dateIn=dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut= dateOut;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getrNum() {
        return rNum;
    }

    public void setrNum(String rNum) {
        this.rNum = rNum;
    }
}
