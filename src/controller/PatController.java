package controller;

import java.util.ArrayList;

import model.dao.PatDao;
import model.dto.DocDto;
import model.dto.PatDto;

public class PatController {
    private PatController(){}
    private static final PatController instance = new PatController();
    public static  PatController getInstance(){ return instance; }

    private PatDao bd = PatDao.getInstance();

    public boolean save(PatDto patDto) {
        boolean result = bd.save(patDto);
        return result;
    }

    public ArrayList<PatDto> findAll( ){
        ArrayList<PatDto> result = new ArrayList<>();
        for(Object obj:bd.findAll())
            if(obj instanceof PatDto){
                result.add((PatDto)obj);
            }
        return result;
    }

    public boolean update( PatDto patDto ){
        return bd.update( patDto );
    }
    
    public boolean delete( int pno ){
        return bd.delete( pno );
    }

}
