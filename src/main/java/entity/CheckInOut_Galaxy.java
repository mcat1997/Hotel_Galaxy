package entity;

/**
 * Created by a3899 on 2017/7/13.
 */
public class CheckInOut_Galaxy {
    private int checkId;
    private String dateIn;
    private String dateOut;
    private String cId;
    private String rNum;
    private float sumPrice;

    public CheckInOut_Galaxy() {
        dateIn = null;
        dateOut = null;
        checkId = 0;
        cId = null;
        rNum = null;
        sumPrice = 0;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
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
