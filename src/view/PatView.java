package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.PatController;
import model.dao.PatDao;
import model.dto.PatDto;

public class PatView {
    private PatView(){} 
    private static final PatView instance = new PatView(); 
    public static PatView getInstance( ){ return instance; } 
  
    private PatController bc = PatController.getInstance();

    private Scanner scan = new Scanner(System.in);
   
    public void run( ){
        while( true ){
            try{  
                System.out.println("[환자정보메뉴]");
                System.out.println("1. 환자 등록 2. 환자 정보 조회 3. 환자정보 수정 4. 환자 삭제");
                System.out.print("번호 입력: ");

                int ch = scan.nextInt();
                if( ch == 1 ){ save(); }
                else if( ch == 2 ){ findAll(); }
                else if( ch == 3 ){ update(); }
                else if( ch == 4 ){ delete(); }
            }catch( InputMismatchException e ){
                
                scan = new Scanner( System.in );
                System.out.println("[다시입력]" + e);
            }
        } 
    } 

    // [1] 환자 등록 VIEW
    public void save( ){
        
        System.out.println("[환자등록]");
        System.out.print("환자 이름: "); String pname = scan.next();
        System.out.print("환자 전화번호: "); String pphone = scan.next();
        PatDto patDto = new PatDto(0, pname, pphone); 
        boolean result = bc.save( patDto ); 
        if( result ){ System.out.println("(안내) 등록완료!");} 
        else{ System.out.println("(안내) 등록실패!"); }
    }

    // [2] 환자 전체조회 VIEW
    public void findAll( ){
        System.out.println("[환자 정보 조회]");
        ArrayList<PatDto> result = bc.findAll();
        for( PatDto dto : result ){
            System.out.println( dto.getPno()+" / "+dto.getPname()+" / " +dto.getPphone() );
        }
    }

    // [3] 환자정보 수정 VIEW
    public void update( ){
        System.out.println("[환자정보 수정]");
        System.out.print("환자 번호: "); int pno = scan.nextInt();
        System.out.print("수정할 전화번호: "); String pphone = scan.next();
        PatDto patDto = new PatDto(pno, pphone, pphone);
        boolean result = bc.update(patDto);
        if(result) {System.out.println("(안내) 수정완료!");}
        else {System.out.println("(안내) 수정실패!");}
    }

    // [4] 환자 삭제 VIEW
    public void delete() {
        System.out.println("===== 환자 삭제 =====");
        System.out.print("환자 번호: "); int pno = scan.nextInt();
        boolean result = bc.delete(pno);
        if (result) {System.out.println("(안내) 삭제완료!");} 
        else {System.out.println("(안내) 삭제실패!");}
    }
}
