package model.dao;

public class DocDao extends BaseDao{
    
    private DocDao(){}
    private static final DocDao instance = new DocDao();
    public static DocDao getInstance(){ return instance; }
}
