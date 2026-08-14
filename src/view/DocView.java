package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.DocController;
import model.dto.DocDto;

public class DocView {
    
    Scanner scan = new Scanner(System.in);
    
    private DocController dc = DocController.getInstance();

    public void run(){
        try{
        
            System.out.println("[ 의사정보메뉴 ]");
            System.out.println("1. 의사 등록  2. 의사 삭제  3. 의사정보 수정  4.전체조회");
            System.out.println("번호 입력: ");

            int ch = scan.nextInt();

            if(ch == 1){save();}
                else if(ch==2){delete();}
                else if(ch==3){update();}
                else if(ch==4){findAll();}

        } catch (InputMismatchException e) {
            scan = new Scanner(System.in); // 입력 했지만 타입에서 예외 이므로 입력 객체 초기화
            System.out.println("[다시입력]"+ e);
        }
    }
    


    public void save(){
        System.out.println("이름:"); String dname = scan.next();    //저장할 자료 입력
        System.out.println("전화번호:"); String dphone = scan.next();
        System.out.println("진료과목:"); String dpart = scan.next();

        DocDto docDto = new DocDto(0, dname, dphone, dpart);  //자료 객체화
        boolean result = dc.save(docDto);

    if (result) {
        System.out.println("등록 성공");
    }else{
        System.out.println("등록 실패");
    }
    }


    public void findAll(){
        ArrayList<DocDto> result = dc.findAll();
        for (DocDto dto:result){
            System.out.println( dto.getNo()+" / "+dto.getName()+" / " +dto.getPart() );
        }
    }
    
    public void update( ){
            System.out.print("수정할번호: ");   int dno = scan.nextInt();
            System.out.print("수정할전화번호: ");   String dphone = scan.next();
            DocDto docDto = new DocDto(dno, dphone); 
            boolean result = dc.update( docDto );
            if( result ){ System.out.println(">수정 성공"); }
            else{ System.out.println(">수정 실패"); }
        }

    public void delete( ){
            System.out.print("삭제할번호: ");   int dno = scan.nextInt();


            boolean result = dc.delete( dno );
            if( result ){ System.out.println(">삭제 성공"); }
            else{ System.out.println(">삭제 실패"); }
        }

}
