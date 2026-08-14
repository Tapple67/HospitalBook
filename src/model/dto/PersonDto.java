package model.dto;
import java.util.ArrayList;

public abstract class PersonDto {
    String name;
    String phone;


    abstract boolean save(Object Dto);

    abstract ArrayList<Object> findAll();

    abstract boolean update(Object Dto);

    abstract boolean delete(String name);

}
