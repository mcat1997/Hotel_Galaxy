package entity;

/**
 * Created by a3899 on 2017/7/13.
 */
public class Customer_Galaxy {
    private String cId;
    private String cName;
    private String cSex;
    private String cPhone;

    public Customer_Galaxy(){
        super();
    }
    public Customer_Galaxy(String cId,String cName,String cSex,String cPhone){
        this.cId=cId;
        this.cName=cName;
        this.cPhone=cPhone;
        this.cSex=cSex;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
}
