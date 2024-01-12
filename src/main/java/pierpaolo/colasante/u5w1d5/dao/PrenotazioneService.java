package pierpaolo.colasante.u5w1d5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pierpaolo.colasante.u5w1d5.entities.Prenotazione;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){

        boolean controlloPrenotaz = prenotazioneDAO.existsByDataAndUtenteAndPostazione(prenotazione.getData(), prenotazione.getUtente(), prenotazione.getPostazione());

        if(controlloPrenotaz){
            System.err.println("Peccato " + prenotazione.getUtente().getNomeCognome() + " hai già una prenotazione in questa data e in questa postazione!");
        } else{
            prenotazioneDAO.save(prenotazione);
            System.out.println("Prenotazione in data: "+ prenotazione.getData() +" effettuata con successo!!!");
        }
    }
}
