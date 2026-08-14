package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatDao extends BaseDao {
    private patDao(){}
    private static final PatDao instance = new patDao();
    public static patDao getInstance(){ return instance; }

    