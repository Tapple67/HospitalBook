package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.BookDto;

public class BookDao extends BaseDao {
    
    // 싱글톤
    private BookDao(){}
    private static final BookDao instance = new BookDao();
    public static BookDao getInstance(){ return instance; }
    
    // [1] 등록 DAO (메소드명: bookSave)
    public boolean bookSave( BookDto bookDto ){
        try{ 
            // 1.1 SQL 작성 (순서: bname, bpart, bdate)
            String sql = "insert into book(bname, bpart, bdate) values(?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement( sql ); 
            
            // 1.3 와일드카드(?) 매개변수 대입 (순서 맞춰서 수정!)
            ps.setString(1, bookDto.getBname()); // 1번째 ? -> 환자 이름
            ps.setString(2, bookDto.getBpart()); // 2번째 ? -> 진료과
            ps.setString(3, bookDto.getBdate()); // 3번째 ? -> 예약일
            
            int result = ps.executeUpdate(); 
            if( result == 1 ) return true; 
            
        } catch( SQLException e ){ 
            System.out.println( e ); 
        }
        return false;
    } // 등록 end 
    
    // [2] 전체조회 DAO (메소드명: bookFindAll)
    public ArrayList<BookDto> bookFindAll(){
        ArrayList<BookDto> list = new ArrayList<>(); 
        try{
            String sql = "select * from book"; 
            PreparedStatement ps = conn.prepareStatement( sql ); 
            ResultSet rs = ps.executeQuery(); 
            
            while( rs.next() ){ 
                BookDto bookDto = new BookDto(); 
                bookDto.setBno( rs.getInt("bno") ); 
                bookDto.setBname( rs.getString("bname") );
                bookDto.setBpart( rs.getString("bpart") );
                bookDto.setBdate( rs.getString("bdate") );
                
                list.add( bookDto );
            }
        } catch( SQLException e ){ 
            System.out.println(e); 
        } 
        return list; 
    } // 전체조회 end 

    // [3] 개별수정 DAO
    public boolean bookUpdate(BookDto bookDto) {
        try {
            String sql = "update book set bdate = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookDto.getBdate()); // 첫 번째 ? -> 수정할 날짜
            ps.setInt(2, bookDto.getBno());     // 두 번째 ? -> 대상 예약번호
            
            int result = ps.executeUpdate();
            if (result == 1) return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    // [4] 개별삭제 DAO (메소드명: bookDelete, 테이블/컬럼명 수정)
    public boolean bookDelete( int bno ){
        try{ 
            String sql = "delete from book where bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1 , bno ); 
            
            int result = ps.executeUpdate();
            if( result == 1 ) return true;
        } catch( SQLException e ){ 
            System.out.println( e ); 
        }
        return false;
    }
} // CLASS END