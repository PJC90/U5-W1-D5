package pierpaolo.colasante.u5w1d5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pierpaolo.colasante.u5w1d5.entities.Postazione;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
}
