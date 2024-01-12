package pierpaolo.colasante.u5w1d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@Getter
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name="postazione_id")
    private Postazione postazione;

    public Prenotazione(LocalDate data, Postazione postazione, Utente utente) {
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Stai impostando una data passata");
        }
        this.data = data;
        this.postazione = postazione;
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", data=" + data +
                ", utente=" + utente +
                ", postazione=" + postazione +
                '}';
    }
}
