package pierpaolo.colasante.u5w1d5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pierpaolo.colasante.u5w1d5.entities.Edificio;

@Service
public class EdificioService {
    @Autowired
    private  EdificioDAO edificioDAO;

    public void saveEdificio(Edificio edificio){
        edificioDAO.save(edificio);
        System.out.println("Edificio "+ edificio.getNome() +" salvato nel db!!!");
    }
}
