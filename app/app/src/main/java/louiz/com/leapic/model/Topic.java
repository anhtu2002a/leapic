package louiz.com.leapic.model;

public class Topic {
    private int iD,typeId;
    private String Name,Ex;
    private  byte[] pic,picClick;

    public Topic(int iD, int typeId, String name, String ex, byte[] pic, byte[] picClick) {
        this.iD = iD;
        this.typeId = typeId;
        Name = name;
        Ex = ex;
        this.pic = pic;
        this.picClick = picClick;
    }
    public Topic(int iD, int typeId, String name, byte[] pic) {
        this.iD = iD;
        this.typeId = typeId;
        Name = name;
        this.pic = pic;
        this.picClick = picClick;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEx() {
        return Ex;
    }

    public void setEx(String ex) {
        Ex = ex;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public byte[] getPicClick() {
        return picClick;
    }

    public void setPicClick(byte[] picClick) {
        this.picClick = picClick;
    }

}

