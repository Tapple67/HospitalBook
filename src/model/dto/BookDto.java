package model.dto;

public class BookDto {
    // 1. 데이터베이스 표에서 (CRUD) 사용할 자료들을 private 멤버변수로 구성
    private int rpno;
    private String rname;
    private String rpart;
    private String rdate;
    // 2. 기본생성자, 전체매개변수생성자
    public BookDto() { }
    public BookDto(int rpno, String rname, String rpart, String rdate) {
        this.rpno = rpno;
        this.rname = rname;
        this.rpart = rpart;
        this.rdate = rdate;
    }
    // 3. setter and getter , toString
    public String getRname() {
        return rname;
    }
    public void setRname(String rname) {
        this.rname = rname;
    }
    public String getRpart() {
        return rpart;
    }
    public void setRpart(String rpart) {
        this.rpart = rpart;
    }
    public String getRdate() {
        return rdate;
    }
    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
    @Override
    public String toString() {
        return "BookDto [rname=" + rname + ", rpart=" + rpart + ", rdate=" + rdate + "]";
    }
} // CLASS END 