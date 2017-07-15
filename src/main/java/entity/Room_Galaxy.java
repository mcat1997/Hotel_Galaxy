package entity;

/**
 * Created by a3899 on 2017/7/13.
 */
public class Room_Galaxy {
    private String rNum;
    private String rType;
    private float rPrice;
    private boolean rState;

    public Room_Galaxy(){super();}

    public Room_Galaxy(String rNum,String rType,float rPrice,boolean rState){
        this.rNum=rNum;
        this.rType=rType;
        this.rPrice=rPrice;
        this.rState=rState;
    }

    public String getrNum() {
        return rNum;
    }

    public void setrNum(String rNum) {
        this.rNum = rNum;
    }

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }

    public float getrPrice() {
        return rPrice;
    }

    public void setrPrice(float rPrice) {
        this.rPrice = rPrice;
    }

    public boolean isrState() {
        return rState;
    }

    public void setrState(boolean rState) {
        this.rState = rState;
    }
}
