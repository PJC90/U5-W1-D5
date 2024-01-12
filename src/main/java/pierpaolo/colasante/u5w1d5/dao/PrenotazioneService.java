package pierpaolo.colasante.u5w1d5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pierpaolo.colasante.u5w1d5.entities.Prenotazione;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){
        prenotazioneDAO.save(prenotazione);
        System.out.println("Prenotazione in data: "+ prenotazione.getData() +" effettuata con successo!!!");
    }
}
