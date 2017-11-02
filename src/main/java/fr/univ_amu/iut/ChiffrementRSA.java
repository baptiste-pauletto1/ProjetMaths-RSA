package fr.univ_amu.iut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by p16005334 on 20/10/17.
 */
public class ChiffrementRSA {
    public static void main(String[] args){
        String message = menu();
        ManipulateurDeString manipulateurDeString = new ManipulateurDeString();
        ArrayList<Integer> tmp = ManipulateurDeString.decouperString(message);
        System.out.println(tmp);

        EncodeurDecodeur encodeurDecodeur = new EncodeurDecodeur();
        Calculateur calculateur = new Calculateur(11,17);
        System.out.println(calculateur.getE() + " " +calculateur.getN());
        ArrayList<Integer> listeCodee = new ArrayList<Integer>();
        for (int i = 0; i < tmp.size(); i++) {
            listeCodee.add(EncodeurDecodeur.coder(tmp.get(i),calculateur.getE(),calculateur.getN()));
        }
        System.out.println(listeCodee);
        ArrayList<Integer> listeDecodee;
        listeDecodee = EncodeurDecodeur.decoder(listeCodee,calculateur.getD(),calculateur.getN());

        System.out.println(ManipulateurDeString.reformerString(listeDecodee));


    }

    public static String menu() {
        String choix = " ";
        System.out.println("Tapez la string que vous souhaitez transmettre");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = (in.readLine());
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }
}
