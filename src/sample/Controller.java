package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    public ListView<Korisnik> LIspis;
    public TextField tfIme;
    public TextField tfPrezime;
    public TextField tfMail;
    public TextField tfKorsIme;
    public TextField tfLozinka;
    public Button dodaj;
    public Button kraj;
    private KorisniciModel model;



    @FXML
    public void kraj(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void dodaj(ActionEvent actionEvent) {

        model.dodajKorisnika();
        setTextPropetryUnBind();
        LIspis.refresh();
        LIspis.requestFocus();
        LIspis.getSelectionModel().selectLast();
    }

    public Controller(KorisniciModel m) {
        model = m;
    }

    @FXML
    public void initialize(){
        LIspis.requestFocus();
        model.setTrenutniKorisnik(model.getKorisnik().get(0));
        setTextPropetryBind();
        LIspis.setItems(model.getKorisnik());
        LIspis.getFocusModel().focus(0);
        setTextPropetryUnBind();

        LIspis.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnikOld, Korisnik korisnikNew) {
                if (korisnikOld != null) {
                    setTextPropetryUnBind();
                }
                if (korisnikNew == null) {
                    tfIme.setText("");
                    tfPrezime.setText("");
                    tfMail.setText("");
                    tfKorsIme.setText("");
                    tfLozinka.setText("");
                }
                else {
                    updateKorisnika();
                }
                LIspis.refresh();
            }

        });
    }

    private void updateKorisnika() {
        Korisnik korisnik = (Korisnik) LIspis.getSelectionModel().getSelectedItem();
        setTextPropetryUnBind();
        model.setTrenutniKorisnik(korisnik);
        setTextPropetryBind();
        LIspis.refresh();
    }

    private void setTextPropetryBind() {
        tfIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        tfPrezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        tfMail.textProperty().bindBidirectional(model.getTrenutniKorisnik().mailProperty());
        tfKorsIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        tfLozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
    }

    private void setTextPropetryUnBind() {
        tfIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
        tfPrezime.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        tfMail.textProperty().unbindBidirectional(model.getTrenutniKorisnik().mailProperty());
        tfKorsIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        tfLozinka.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
    }


}
