package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a3899 on 2017/7/13.
 */
public class CheckInOut_Galaxy {
    private Date dateIn;
    private Date dateOut;
    private Customer_Galaxy customer_galaxy;
    private Room_Galaxy room_galaxy;
    private float sumPrice;

    public CheckInOut_Galaxy(){
        dateIn=null;
        dateOut=null;
        customer_galaxy=null;
        room_galaxy=null;
        sumPrice=0;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateIn(String dateIn) throws ParseException {

        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateIn=sd.parse(dateIn);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public void setDateOut(String dateOut)throws ParseException{
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateOut=sd.parse(dateOut);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Customer_Galaxy getCustomer_galaxy() {
        return customer_galaxy;
    }

    public void setCustomer_galaxy(Customer_Galaxy customer_galaxy) {
        this.customer_galaxy = customer_galaxy;
    }

    public Room_Galaxy getRoom_galaxy() {
        return room_galaxy;
    }

    public void setRoom_galaxy(Room_Galaxy room_galaxy) {
        this.room_galaxy = room_galaxy;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }
}
