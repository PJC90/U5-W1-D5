package pierpaolo.colasante.u5w1d5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pierpaolo.colasante.u5w1d5.entities.Utente;
@Repository
public interface UtenteDAO extends JpaRepository<Utente, Long> {
}
