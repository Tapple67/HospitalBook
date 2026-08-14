package model.dto;

public class BookDto {
    // 1. 데이터베이스 표에서 (CRUD) 사용할 자료들을 private 멤버변수로 구성
    private int no;
    private String content;
    private String writer;
    // 2. 기본생성자, 전체매개변수생성자
    public BoardDto() { }
    public BoardDto(int no, String content, String writer) {
        this.no = no;
        this.content = content;
        this.writer = writer;
    }
    // 3. setter and getter , toString 
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    @Override
    public String toString() {
        return "BoardDto [no=" + no + ", content=" + content + ", writer=" + writer + "]";
    }
} // CLASS END 

}
