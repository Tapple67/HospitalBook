package hospitalbook.src.controller;

import java.util.ArrayList;
import hospitalbook.src.model.dao.BookDao;

public class BookController {
    private BookController(){}
    private static final BookController instance = new BookController();
    public static BookController getInstance(){
        return instance;
    }
    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private BookDao bd = BookDao.getInstance();
}	
    // [1] 등록 Controller
    public boolean save( BookDto bookDto ){
        boolean result = bd.booksave( bookDto ); // view에게 전달받은 매개변수을 dao에게전달
        return result; // dao에게 받은 결과을 view 반환
    }
    
    // [2] 전체조회 Controller 
    public ArrayList<BookDto> bookFindAll( ){
        ArrayList<BookDto> result = bd.bookFindAll();
        return result;
    }
 	
    // [3] 개별수정 Controller 
    public boolean bookUpdate( BookDto bookDto ){
        return bd.bookUpdate( bookDto );
    }

    // [4] 개별삭제 Controller
    public boolean bookDelete( int no ){
        return bd.bookDelete( no );
    }
}
