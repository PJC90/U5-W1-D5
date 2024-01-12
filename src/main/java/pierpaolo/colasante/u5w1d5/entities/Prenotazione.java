package pierpaolo.colasante.u5w1d5.entities;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class Prenotazione {
    private LocalDate data;
    private Postazione postazione;
    private Utente utente;

    public Prenotazione(LocalDate data, Postazione postazione, Utente utente) {
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Stai impostando una data passata");
        }
        this.data = data;
        this.postazione = postazione;
        this.utente = utente;
        System.out.println("Prenotazione in data: " + data.toString() + " avvenuta con successo");
    }

}
