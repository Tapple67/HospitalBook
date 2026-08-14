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
            DocDto docDto = (DocDto)Dto;
            
            String sql = "select into doctor values(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, docDto.getName());
            ps.setString(2, docDto.getPhone());
            ps.setString(3, docDto.getPart());

            int result = ps.executeUpdate();
            if( result == 1){
                return true;
            } //성공 반환
            
        } catch (SQLException e) {
            System.out.println(e);
            
        }
        return false;

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

        
        try {
            DocDto docDto = (DocDto)Dto;

            String url = "update doctor set dno = ? where dphone = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, docDto.getNo());
            ps.setString(2, docDto.getPhone());

            int result = ps.executeUpdate();
            if(result == 1){ return true;}
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    };

    public boolean delete(int no){
        try {
            String url = "delete from doctor where dno = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, no);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    };
        
}
