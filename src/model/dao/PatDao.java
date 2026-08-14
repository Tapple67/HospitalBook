package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.PatDto;

public class PatDao extends BaseDao {
    private PatDao(){}
    private static final PatDao instance = new PatDao();
    public static PatDao getInstance(){ return instance; }

    public boolean save( PatDto patDto ){
        try{             
            String sql = "insert into patient(pname, pphone) values( ? , ? )";
            PreparedStatement ps = conn.prepareStatement( sql ); 
            ps.setString(1, patDto.getPname() ); 
            ps.setString(2, patDto.getPphone() ); 
            
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
                patDto.setPname( rs.getString("pname") );
                patDto.setPphone( rs.getString("pphone") );
    
                list.add( patDto );
            }
        }catch( SQLException e ){ System.out.println(e); } 
        
        return list; 
    } 

    public boolean update(PatDto patDto) {
    try {String sql = "update patient set pphone = ? where pno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, patDto.getPphone());
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
}
    