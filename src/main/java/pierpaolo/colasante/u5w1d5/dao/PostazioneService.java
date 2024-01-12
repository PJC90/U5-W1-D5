package pierpaolo.colasante.u5w1d5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pierpaolo.colasante.u5w1d5.entities.Postazione;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void savepostazione(Postazione postazione){
        postazioneDAO.save(postazione);
        System.out.println("Postazione " + postazione.getDescrizione() + " salvata nel db!!!");
    }
}
