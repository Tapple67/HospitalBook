package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import model.dto.BookDto;

public class BookView {
    // 싱글톤
    private BookView(){}
    private static final BookView instance = new BookView();
    public static BookView getInstance(){
        return instance;
    }
    
    private BookController bc = BookController.getInstance();
    private Scanner scan = new Scanner(System.in);
    
    public void run(){
        while(true){
            try{
                System.out.println("\n[예약 관리 메뉴]");
                System.out.println("1.예약등록  2.삭제 3.수정 4.전체조회 5.처음으로");
                System.out.print("번호 입력: ");
                int ch = scan.nextInt();
                
                if(ch==1){
                    bookSave();
                }
                else if(ch==2){
                    bookDelete();
                }
                else if(ch==3){
                    bookUpdate();
                }
                else if(ch==4){
                    bookFindAll();
                }
                else if(ch==5){
                    return; // app.java로
                }
            }
            catch(Exception e){
                System.out.println("(경고) 잘못된 입력입니다. 다시 선택해 주세요.");
                scan.nextLine(); // 입력 버퍼 비우기
            }
        }//while end
    }//run() end

    // 1. 예약등록
    private void bookSave(){
        System.out.println("\n[예약 등록]");
        System.out.print("환자 이름: ");
        String rname = scan.next();
        System.out.print("접수 과: ");
        String rpart = scan.next();
        System.out.print("예약일(20XX-XX-XX): ");
        String rdate = scan.next();

        // DTO 객체 생성 후 전달
        BookDto bookDto = new BookDto(rname, rpart, rdate);
        boolean result = bc.bookSave(bookDto); 
        
        if(result)
            System.out.println("(안내) 예약등록 성공!");
        else
            System.out.println("(안내) 예약등록 실패!");
    }

    // 2. 삭제
    private void bookDelete(){
        System.out.println("\n[예약 삭제]");
        System.out.print("삭제할 예약 번호: ");
        int bno = scan.nextInt();
        
        boolean result = bc.bookDelete(bno);
        if(result)
            System.out.println("(안내) 예약삭제 성공!");
        else
            System.out.println("(안내) 예약삭제 실패!");
    }

    // 3. 수정
    private void bookUpdate(){
        System.out.println("\n[예약 수정]");
        System.out.print("수정할 예약 번호: ");
        int bno = scan.nextInt();
        System.out.print("변경 예약일(20XX-XX-XX): ");
        String rdate = scan.next();
        
        // DTO에 번호와 변경할 날짜 담기
        BookDto bookDto = new BookDto();
        bookDto.setBno(bno);
        bookDto.setBdate(rdate);
        
        boolean result = bc.bookUpdate(bookDto);
        if(result)
            System.out.println("(안내) 예약수정 성공!");
        else
            System.out.println("(안내) 예약수정 실패!");
    }

    // 4. 전체조회
    public void bookFindAll(){
        System.out.println("\n[예약 전체 조회]");
        ArrayList<BookDto> result = bc.bookFindAll();
        
        if(result.isEmpty()){
            System.out.println("(안내) 등록된 예약 정보가 없습니다.");
            return;
        }
        
        for( BookDto dto : result ){ 
            System.out.println( dto.getBno() + ". " + dto.getBname() + " : " + dto.getBpart() + " / 예약일: " + dto.getBdate() );
        }
    }
}