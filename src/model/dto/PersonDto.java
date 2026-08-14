package model.dto;


public class PersonDto {
    private String name;
    private String phone;

    // 기본 생성자
    public PersonDto() {
    }

    // 전체 필드 생성자
    public PersonDto(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonDto{" +"name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
