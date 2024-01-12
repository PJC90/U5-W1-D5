package pierpaolo.colasante.u5w1d5.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pierpaolo.colasante.u5w1d5.entities.Utente;

@Service
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    public void saveUtente(Utente utente){
        if(utente.getUsername().length() < 2) throw new RuntimeException("Il nome non può essere più corto di 2 caratteri!!!");
        utenteDAO.save(utente);
        System.out.println("Utente "+ utente.getNomeCognome() +" salvato nel db!!!");
    }
}
