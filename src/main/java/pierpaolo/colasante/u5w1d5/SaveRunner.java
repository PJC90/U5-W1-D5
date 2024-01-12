package pierpaolo.colasante.u5w1d5;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import pierpaolo.colasante.u5w1d5.dao.EdificioService;
import pierpaolo.colasante.u5w1d5.dao.PostazioneService;
import pierpaolo.colasante.u5w1d5.dao.PrenotazioneService;
import pierpaolo.colasante.u5w1d5.dao.UtenteService;
import pierpaolo.colasante.u5w1d5.entities.Edificio;
import pierpaolo.colasante.u5w1d5.entities.Postazione;
import pierpaolo.colasante.u5w1d5.entities.Prenotazione;
import pierpaolo.colasante.u5w1d5.entities.Utente;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

@Component
public class SaveRunner implements CommandLineRunner {
    @Autowired
    UtenteService utenteService;
    @Autowired
    EdificioService edificioService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Override
    public void run(String... args) throws Exception {
        Faker fk = new Faker(Locale.ITALY);
        Random rm = new Random();
        int numCasuale = rm.nextInt(1000);
        String nomeEdificio = fk.gameOfThrones().house();
        String indirizzo = fk.address().streetAddress();
        String citta = fk.address().city();
        String baseName = fk.name().firstName();
        String username = baseName.toLowerCase() + fk.number().numberBetween(10, 99);
        String fullName = baseName + " " + fk.name().lastName();
        String email = username + "@hotmail.it";
        String randomPostazione = fk.pokemon().name();


        try {
//            SALVA UTENTI
            Utente utenteCreato = new Utente(username, fullName, email);
            utenteService.saveUtente(utenteCreato);

//            SALVA EDIFICI
            Edificio edificioCreato = new Edificio(nomeEdificio, indirizzo, citta);
            edificioService.saveEdificio(edificioCreato);

//            SALVA POSTAZIONI
            Postazione postazioneCreata = new Postazione(randomPostazione,edificioCreato);
            postazioneService.savepostazione(postazioneCreata);

//            SALVA PRENOTAZIONI
            Prenotazione prenotazioneCreata = new Prenotazione(LocalDate.now().plusDays(numCasuale), postazioneCreata, utenteCreato);
            prenotazioneService.savePrenotazione(prenotazioneCreata);

//            SALVA PRENOTAZIONI dello stesso UTENTE nello stesso giorno (darà errore)
//              per ora non ho ancora dei metodo findById quindi faccio questo controllo duplicando prenotazioneCreata

            Prenotazione prenotazioneCreata2 = new Prenotazione(LocalDate.now().plusDays(numCasuale), postazioneCreata, utenteCreato);
            prenotazioneService.savePrenotazione(prenotazioneCreata2);

//            SALVA PRENOTAZIONE dello stesso UTENTE MA CON DATA DIVERSA
            Prenotazione prenotazioneCreata3 = new Prenotazione(LocalDate.now().plusDays(18), postazioneCreata, utenteCreato);
            prenotazioneService.savePrenotazione(prenotazioneCreata3);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
