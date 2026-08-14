package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.DocDto;

public class DocDao extends PersonDao{
    
    
    private DocDao(){}
    private static final DocDao instance = new DocDao();
    public static DocDao getInstance(){ return instance; }


    ArrayList<Object> list = new ArrayList<>();

    public boolean save(Object Dto){

        try {
            String sql = "select into doctor values(? : ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            int result = ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    };

    public ArrayList<Object> findAll(){
        try {
        String sql = "select * from doctor";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            DocDto docDto = new DocDto();
            docDto.setNo(rs.getInt("dno"));
            docDto.setName(rs.getString("dname"));
            docDto.setPart(rs.getString("dpart"));

            list.add(docDto);
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    };

    public boolean update(Object Dto){

    };

    public boolean delete(){

    };
        
}
