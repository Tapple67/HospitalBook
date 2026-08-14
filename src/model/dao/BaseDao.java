package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
    //1. 연동 정보
    private String url = "jdbc:mysql://127.0.0.1:3306/mydb0813";
    private String user = "root";
    private String password = "1324";

    //2.연동인터페이스
    protected Connection conn;
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(url,user,password);

        } catch (Exception e) {
            System.out.println("DB연동실패" + e);

        }
    }
    //기본 생성자에 연동 메소드 실행

    protected BaseDao(){connect();}


}
