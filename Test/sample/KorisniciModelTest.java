package sample;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {

    private static KorisniciModel model = null;

    @BeforeAll
    static void setup(){
        model = new KorisniciModel();
        model.napuni();

    }

    @Test
    void newKorisnik(){

        ObservableList<Korisnik> n = model.getKorisnik();

        n.add(new Korisnik("Ilma","Kulovac","ikulovac1@etf.unsa.ba","ikulovac1","ilmich"));
        assertEquals(4,n.size());
    }



}