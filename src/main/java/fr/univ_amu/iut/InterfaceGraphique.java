package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Baptiste on 30/10/2017.
 */
public class InterfaceGraphique extends Application{
    private static Stage primStage;
    private int compteurMsg, compteurStep = 0;
    ArrayList<Integer> chaineDecoupee, listeCodee, listeDecodee;
    Calculateur calculateur;

    @FXML
    private TextField afficheurTour;
    @FXML
    private TextField message;
    @FXML
    private TextArea textAreaVous;
    @FXML
    private TextArea textAreaDestinataire;
    @FXML
    private Button voirEtapeParEtape;
    @FXML
    private TextField chaineInitiale;
    @FXML
    private TextField chaineSepareeAscii;
    @FXML
    private TextField chaineGroupee;
    @FXML
    private TextField chaineCodee;
    @FXML
    private TextField chaineDecodee;
    @FXML
    private TextField chaineDegroupee;
    @FXML
    private TextField chaineReconstituee;
    @FXML
    private TextField chaineRecue;
    @FXML
    private TextField textFieldp;
    @FXML
    private TextField textFieldq;
    @FXML
    private TextField textFieldClefPrivee;


    public static Stage getPrimaryStage() {
        return primStage;
    }

    public static void setPrimaryStage(Stage stage) {
        primStage = stage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/InterfaceGraphique.fxml"));
        setPrimaryStage(primaryStage);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Chat RSA");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void ModeEtape(ActionEvent event) throws Exception {
        if (!voirEtapeParEtape.isPressed()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/InterfaceEtapes.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(loader.getRoot());
            getPrimaryStage().setScene(scene);
            getPrimaryStage().show();
        }
    }

    public void afficherMessage (ActionEvent event) throws Exception{
        String contenu = message.getText();
        ++compteurMsg;
        if (compteurMsg%2 !=0) {
            afficheurTour.setText("Le message de votre interlocuteur : ");
            textAreaDestinataire.setText( textAreaDestinataire.getText() + "[" + LocalTime.now() + "] : " + contenu  + "\n");
        }
        else {
            afficheurTour.setText("Votre message : ");
            textAreaVous.setText(  textAreaVous.getText() + "[" + LocalTime.now() + "] : " + contenu + "\n");

        }
        message.clear();
    }

    public void afficheSite (ActionEvent event) throws  Exception{
        getHostServices().showDocument("https://cocalc.com/projects/0e93946c-ebbe-4141-986c-ff4daf439173/?session=default");
    }

    public void doNextStep (ActionEvent event) throws Exception {
        switch (compteurStep){
            case 0:{
                while(Calculateur.testPrimalite(Integer.parseInt(textFieldp.getText())) != true)  {
                        textFieldp.clear();
                        textFieldp.setPromptText("P doit être premier");
                }
                while(Calculateur.testPrimalite(Integer.parseInt(textFieldq.getText())) != true)   {
                        textFieldq.clear();
                        textFieldq.setPromptText("Q doit être premier");
                }
                ++compteurStep;
                chaineInitiale.setEditable(true);
                return;
            }
            case 1: {
                calculateur = new Calculateur(Integer.parseInt(textFieldp.getText()),Integer.parseInt(textFieldq.getText()));
                chaineDecoupee = ManipulateurDeString.decouperString(chaineInitiale.getText());
                chaineSepareeAscii.setText(chaineDecoupee.toString());
                ++compteurStep;
                return;
            }
            case 2:{
                chaineGroupee.setText("Pas encore fait cette merde");
                ++compteurStep;
                return;
            }
            case 3:{
                listeCodee = new ArrayList<>();
                for (int i = 0; i < chaineDecoupee.size(); i++) {
                    listeCodee.add(EncodeurDecodeur.coder(chaineDecoupee.get(i),calculateur.getE(),calculateur.getN()));
                }
                chaineCodee.setText(listeCodee.toString());
                ++compteurStep;
                return;
            }
            case 4:{
                textFieldClefPrivee.setText("(" + calculateur.getD() + "," + calculateur.getN() + ")");
                listeDecodee = EncodeurDecodeur.decoder(listeCodee,calculateur.getD(),calculateur.getN());
                chaineDecodee.setText(listeDecodee.toString());
                ++compteurStep;
                return;
            }
            case 5:{
                chaineDegroupee.setText("Cette merde non plus");
                ++compteurStep;
                return;
            }
            case 6:{
                ManipulateurDeString.reformerString(listeDecodee);
                chaineReconstituee.setText(ManipulateurDeString.reformerString(listeDecodee));
                ++compteurStep;
                return;
            }
            case 7:{
                chaineRecue.setText("[" + LocalTime.now() + "] : " + chaineReconstituee.getText());
                ++compteurStep;
                return;
            }
            default:
                compteurStep = 0;
                chaineInitiale.clear();
                chaineReconstituee.clear();
                chaineDecodee.clear();
                chaineRecue.clear();
                chaineSepareeAscii.clear();
                chaineGroupee.clear();
                chaineCodee.clear();
        }
    }

}
