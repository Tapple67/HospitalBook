
import java.util.Scanner;
import view.BookView;
import view.DocView;
import view.PatView;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            try{
                System.out.println("[ 메뉴 선택 ]");
                System.out.println("1.환자정보 메뉴  2.의사정보 메뉴  3.예약 메뉴");
                System.out.print("번호 선택: ");
                int ch = scan.nextInt();
                if(ch==1)
                    PatView.getInstance().run( );
                else if (ch==2)
                    DocView.getInstance().run( );
                else if(ch==3)
                    BookView.getInstance().run( );
            }   
            catch(Exception e){
                System.out.println("잘못된 번호입니다.");
                scan.nextLine(); //에러원인 제거(버퍼 비우기)
            }
        }
    }
}