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
    private int compteurMsg;
    private int compteurStep;

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
            textAreaDestinataire.setText(textAreaDestinataire.getText() + "\n" + contenu);
        }
        else {
            afficheurTour.setText("Votre message : ");
            textAreaVous.setText(textAreaVous.getText() + "\n" + contenu);

        }
        message.clear();
    }

    public void afficheSite (ActionEvent event) throws  Exception{
        getHostServices().showDocument("https://cocalc.com/projects/0e93946c-ebbe-4141-986c-ff4daf439173/?session=default");
    }

    public void doNextStep (ActionEvent event) throws Exception {
        ArrayList<Integer> chaineDecoupee = ManipulateurDeString.decouperString(chaineInitiale.getText());;
        ArrayList<Integer> listeCodee = new ArrayList<Integer>();
        ArrayList<Integer> listeDecodee = new ArrayList<>();
        switch (compteurStep){
            case 0: {
                chaineSepareeAscii.setText(chaineDecoupee.toString());
                ++compteurStep;
                return;
            }
            case 1:{
                chaineGroupee.setText("Pas encore fait cette merde");
                ++compteurStep;
                return;
            }
            case 2:{
                for (int i = 0; i < chaineDecoupee.size(); i++) {
                    listeCodee.add(EncodeurDecodeur.coder(chaineDecoupee.get(i),19,187));
                }
                chaineCodee.setText(listeCodee.toString());
                ++compteurStep;
                return;
            }
            case 3:{ // IL FAUT SOIGNER CES CANCERS LA
                for (int i = 0; i < chaineDecoupee.size(); i++) {
                    listeCodee.add(EncodeurDecodeur.coder(chaineDecoupee.get(i),19,187));
                }
                // IL FAUT SOIGNER CES CANCERS LA
                listeDecodee = EncodeurDecodeur.decoder(listeCodee,59,187);
                chaineDecodee.setText(listeDecodee.toString());
                ++compteurStep;
                return;
            }
            case 4:{
                chaineDegroupee.setText("Cette merde non plus");
                ++compteurStep;
                return;
            }
            case 5:{// IL FAUT SOIGNER CES CANCERS LA
                for (int i = 0; i < chaineDecoupee.size(); i++) {
                    listeCodee.add(EncodeurDecodeur.coder(chaineDecoupee.get(i),19,187));
                }
                // IL FAUT SOIGNER CES CANCERS LA
                listeDecodee = EncodeurDecodeur.decoder(listeCodee,59,187);
                ManipulateurDeString.reformerString(listeDecodee);
                chaineReconstituee.setText(ManipulateurDeString.reformerString(listeDecodee));
                ++compteurStep;
                return;
            }
            case 6:{
                chaineRecue.setText("[" + LocalTime.now() + "] : " + chaineReconstituee.getText());
            }
            default:
                compteurStep = 0;
        }
    }

}
