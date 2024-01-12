package pierpaolo.colasante.u5w1d5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pierpaolo.colasante.u5w1d5.entities.Postazione;
import pierpaolo.colasante.u5w1d5.entities.Prenotazione;
import pierpaolo.colasante.u5w1d5.entities.Utente;

import java.time.LocalDate;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
    boolean existsByDataAndUtenteAndPostazione(LocalDate data, Utente utente, Postazione postazione);
}
