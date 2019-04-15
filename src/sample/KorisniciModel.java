package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {

    private ObservableList<Korisnik> korisnik = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<Korisnik>();


    public ObservableList<Korisnik> getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(ObservableList<Korisnik> korisnik) {
        this.korisnik = korisnik;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public void dodajKorisnika(){
        korisnik.add(new Korisnik());
    }

    void napuni (){
        korisnik.add(new Korisnik( "Vedran" , "Ljubovic" , " vljubovic1@etf.unsa.ba" , "vljubovic1", "password"));
        korisnik.add(new Korisnik( "Tarik" , "Sijarcic" , " tsijarcic1@etf.unsa.ba" , "tare", "passw"));
        korisnik.add(new Korisnik( "Harun" , "Hadzic" , " hhadzic3@etf.unsa.ba" , "hara", "harun(java)"));
        korisnik.add(new Korisnik());
    }



}
