package controller;

import java.util.ArrayList;
import model.dao.BookDao;
import model.dto.BookDto;

public class BookController {
    
    // 싱글톤 패턴
    private BookController(){}
    private static final BookController instance = new BookController();
    public static BookController getInstance(){
        return instance;
    }
    
    // [*] MVC패턴 흐름의 dao 싱글톤 호출
    private BookDao bd = BookDao.getInstance();

    // [1] 등록 Controller
    public boolean bookSave( BookDto bookDto ){
        boolean result = bd.bookSave( bookDto ); // view에게 받은 DTO를 DAO로 전달
        return result; // DAO에게 받은 결과를 view로 반환
    }
    
    // [2] 전체조회 Controller 
    public ArrayList<BookDto> bookFindAll(){
        ArrayList<BookDto> result = bd.bookFindAll();
        return result;
    }
    
    // [3] 개별수정 Controller 
    public boolean bookUpdate( BookDto bookDto ){
        return bd.bookUpdate( bookDto );
    }

    // [4] 개별삭제 Controller
    public boolean bookDelete( int bno ){
        return bd.bookDelete( bno );
    }
}
