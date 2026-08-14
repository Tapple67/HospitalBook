package model.dto;

public class PatDto extends PersonDto {

    private int pno;

    public PatDto() {
    }

    public PatDto(int pno, String name, String phone) {

        super(name, phone);

        this.pno = pno;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }


    @Override
    public String toString() {
        return "PatDto [pno=" + pno + ", name=" + getName() + ", phone=" + getPhone() + "]";}
}