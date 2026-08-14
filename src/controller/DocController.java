package controller;

import java.time.DayOfWeek;
import java.util.ArrayList;

import model.dao.DocDao;
import model.dto.DocDto;
import model.dto.PatDto;

public class DocController {
    private DocController(){}
    private static final DocController instance = new DocController();
    public static  DocController getInstance(){ return instance; }

    private DocDao dd = DocDao.getInstance();

    public boolean save(DocDto patDto) {
        boolean result = dd.save(patDto);
        return result;
    }

    public ArrayList<DocDto> findAll( ){
        ArrayList<DocDto> result = dd.findAll();
        return result;
    }

    public boolean update( DocDto DocDto ){
        return dd.update( DocDto );
    }
    
    public boolean delete( int dno ){
        return dd.delete( dno );
    }
}
