package model.dao;

import java.util.ArrayList;

import model.dto.PatDto;

public abstract class PersonDao extends BaseDao {
    
    
    abstract boolean save(Object Dto);

    abstract ArrayList<PatDto> findAll();

    abstract boolean update(Object Dto);

    abstract boolean delete(int no);

}
