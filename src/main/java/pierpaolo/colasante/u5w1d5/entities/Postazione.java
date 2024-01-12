package pierpaolo.colasante.u5w1d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@Entity
@NoArgsConstructor
@Getter
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int codice;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int numMaxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, Edificio edificio) {
        Random rm = new Random();
        this.descrizione = descrizione;
        this.codice = rm.nextInt(10000000);
        this.edificio = edificio;

        TipoPostazione[] tipiPostaz = TipoPostazione.values();
        this.tipo = tipiPostaz[rm.nextInt(tipiPostaz.length)];

        switch (this.tipo) {
            case PRIVATO -> this.numMaxOccupanti = 2;
            case OPEN_SPACE -> this.numMaxOccupanti = 10;
            case SALA_RIUNIONI -> this.numMaxOccupanti = 25;
        }
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", codice='" + codice + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", numMaxOccupanti=" + numMaxOccupanti +
                '}';
    }
}
