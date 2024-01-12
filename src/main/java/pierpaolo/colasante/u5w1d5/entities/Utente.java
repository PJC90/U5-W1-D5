package pierpaolo.colasante.u5w1d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
@Getter
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String nomeEcognome;
    private String email;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String nomeEcognome, String email) {
        this.username = username;
        this.nomeEcognome = nomeEcognome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nomeEcognome='" + nomeEcognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
