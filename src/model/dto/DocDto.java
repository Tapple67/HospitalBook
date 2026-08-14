package model.dto;

public class DocDto extends PersonDto{
    int dno;
    String dpart;

   


    public DocDto() {
    }


    public DocDto(int no, String name, String phone , String part) {
        super(name, phone);
        this.dno = no;
        this.dpart = part;
    }


    public DocDto(int dno, String phone) {
        super();
        this.dno = dno;
    }


    public int getNo() {
        return dno;
    }


    public void setNo(int no) {
        this.dno = no;
    }


    public String getPart() {
        return dpart;
    }


    public void setPart(String part) {
        this.dpart = part;
    }


    @Override
    public String toString() {
        return "DocDto [part=" + dpart + ", getName()=" + getName() + ", getPhone()=" + getPhone() + "]";
    }

    


}
