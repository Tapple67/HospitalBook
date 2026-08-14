package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.PatDto;

public class PatDao extends PersonDao {
    private PatDao(){}
    private static final PatDao instance = new PatDao();
    public static PatDao getInstance(){ return instance; }

    ArrayList<Object> list = new ArrayList<>();
    
    public boolean save( PatDto patDto ){
        try{             
            String sql = "insert into patient(pname, pphone) values( ? , ? )";
            PreparedStatement ps = conn.prepareStatement( sql ); 
            ps.setString(1, patDto.getName() ); 
            ps.setString(2, patDto.getPhone() ); 
            
            int result = ps.executeUpdate(); 
            if( result == 1 ) return true; 
        }catch( SQLException e ){ System.out.println( e ); }
        
        return false; 
    } 

    public ArrayList<PatDto> findAll( ){
        ArrayList<PatDto> list = new ArrayList<>(); 
        try{
            String sql = "select * from patient"; 
            PreparedStatement ps = conn.prepareStatement( sql ); 
            
            ResultSet rs =  ps.executeQuery(); 
           
            while( rs.next() ){ 
                PatDto patDto = new PatDto(); 
                patDto.setPno( rs.getInt("pno") ); 
                patDto.setName( rs.getString("pname") );
                patDto.setPhone( rs.getString("pphone") );
    
                list.add( patDto );
            }
        }catch( SQLException e ){ System.out.println(e); } 
        
        return list; 
    } 

    public boolean update(PatDto patDto) {
    try {String sql = "update patient set pphone = ? where pno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, patDto.getPhone());
        ps.setInt(2, patDto.getPno());

        int result = ps.executeUpdate();
        if(result == 1) return true;
    }catch(SQLException e) {System.out.println(e);}
    return false;
    }

   public boolean delete(int pno) {
    try {String sql = "delete from patient where pno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, pno);

        int result = ps.executeUpdate();
        if(result == 1) return true;
    }catch(SQLException e) {System.out.println(e);}
    return false;
    }

   @Override
   boolean save(Object Dto) {
    if(Dto instanceof PatDto) {
        return save((PatDto) Dto);
    }
    return false;
   }

   @Override
   boolean update(Object Dto) {
    if(Dto instanceof PatDto) {
        return update((PatDto) Dto);
    }
    return false;
   }
}
    