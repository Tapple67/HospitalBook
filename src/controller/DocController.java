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

    public boolean save(DocDto docDto) {
        boolean result = dd.save(docDto);
        return result;
    }

    public ArrayList<DocDto> findAll( ){
        ArrayList<DocDto> result = new ArrayList<>();
        for(Object obj:dd.findAll())
            if(obj instanceof DocDto){
                result.add((DocDto)obj);
            }
        return result;
    }

    public boolean update( DocDto DocDto ){
        return dd.update( DocDto );
    }
    
    public boolean delete( int dno ){
        return dd.delete( dno );
    }
}
