package model.dto;

public class BookDto {
    // 1. private 멤버 변수
    private int bno;
    private String bname;
    private String bpart;
    private String bdate;

    //기본 생성자
    public BookDto() {}

    //예약 등록용
    public BookDto(String bname, String bpart, String bdate) {
        this.bname = bname;
        this.bpart = bpart;
        this.bdate = bdate;
    }
    
    //예약 삭제 / 수정용 
    public BookDto(int bno, String bname, String bpart, String bdate) {
        this.bno = bno;
        this.bname = bname;
        this.bpart = bpart;
        this.bdate = bdate;
    }

    // 2. Getter / Setter
    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }
    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBpart() {
        return bpart;
    }
    public void setBpart(String bpart) {
        this.bpart = bpart;
    }

    public String getBdate() {
        return bdate;
    }
    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    // 3. toString()
    @Override
    public String toString() {
        return "BookDto [bno=" + bno + ", bname=" + bname + ", bpart=" + bpart + ", bdate=" + bdate + "]";
    }
}