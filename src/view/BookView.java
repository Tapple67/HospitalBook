package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.DocController;
import controller.PatController;
import controller.BookController;
import model.dto.PatDto;
import model.dto.DocDto;
import model.dto.BookDto;
public class BookView {
    //싱글톤!!
    //생성자
    private BookView(){}
    //인스턴스
    private static final BookView instance = new BookView();
    //간접접근메소드 (get)
    public static BookView getInstance(){
        return instance;
    }
    private BookController bc = BookController.getInstance();
    private Scanner scan = new Scanner(System.in);
    
    public void run(){
        while(true){
            try{
                System.out.println("[예약 관리 메뉴]");
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
                    return; //app.java로
                }
            }
            catch(Exception e){
                System.out.println("잘못된 번호입니다.");
                scan.nextLine();
            }
        }//while end
    }//run() end

    //1.예약등록
    private boolean bookSave(){
            System.out.println("[예약 등록]");
            System.out.print("환자 이름: ");
            String rname = scan.next();
            System.out.print("접수 과: ");
            String rpart = scan.next();
            System.out.print("예약일(20XX-XX-XX): ");
            String rdate = scan.next();

            BookDto bookDto = new BookDto(rname, rpart, rdate);
            boolean result = bc.bookSave (bookDto); //컨트롤러에 전달하고 결과 값 true/false
            if(result)
                System.out.println("(안내) 예약등록 성공!");
            else
                System.out.println("(안내) 예약등록 실패!");
    }

    //2. 삭제
    private void bookDelete(){
        System.out.println("[예약 삭제]");
        System.out.print("환자 번호: ");
        int rpno = scan.nextInt();
        boolean result = bc.bookDelete(rpno);
        if(result)
            System.out.println("(안내) 예약삭제 성공!");
        else
            System.out.println("(안내) 예약삭제 실패!");
    }

    //3.수정
    private void bookUpdate(){
        System.out.println("[예약 수정]");
        System.out.print("환자 번호: ");
        int rpno = scan.nextInt();
        System.out.print("변경 예약일(20XX-XX-XX): ");
        String rdate = scan.next();
        boolean result = bc.bookUpdate(rpno,rdate);
        if(result)
            System.out.println("(안내) 예약수정 성공!");
        else
            System.out.println("(안내) 예약수정 실패!");
    }

    //4.전체조회
    public void bookFindAll( ){
        ArrayList<BookDto> result = bc.bookFindAll();// 1. 컨트롤러에게 요청하고 모든 게시물정보 들을 받는다.
        for( BookDto dto : result ){// 2. 반복문 이용하여 게시물정보들을 출력 
            System.out.println( dto.getNo()+". "+dto.getRname()+" : " + dto.getRpart() + " / 예약일: " + dto.getRdate() );
        }
    }
}
