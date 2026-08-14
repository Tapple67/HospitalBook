package model.dao;

import java.util.ArrayList;

public abstract class PersonDao extends BaseDao {
    
    
    abstract boolean save(Object Dto);

    abstract ArrayList<Object> findAll();

    abstract boolean update(Object Dto);

    abstract boolean delete(String name);

}

