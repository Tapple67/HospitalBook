package model.dto;

public class PatDto {
    private int pno;
    private String pname;
    private String pphone;
    
    public PatDto() { }
    public PatDto(int pno, String pname, String pphone) {
        this.pno = pno;
        this.pname = pname;
        this.pphone = pphone;
    }
    // 3. setter and getter , toString 
    public int getPno() {
        return pno;
    }
    public void setPno(int pno) {
        this.pno = pno;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPphone() {
        return pphone;
    }
    public void setPphone(String pphone) {
        this.pphone = pphone;
    }
    @Override
    public String toString() {
        return "BoardDto [no=" + pno + ", pname=" + pname + ", pphone=" + pphone + "]";
    }
}
