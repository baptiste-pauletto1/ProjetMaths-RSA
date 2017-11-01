package fr.univ_amu.iut;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.StrictMath.log10;

/**
 * Created by l16000680 on 26/10/17.
 */
public class GroupeurDegroupeur {
    public ArrayList<String> grouperChaineAscii(ArrayList<String> chaineEnAscii) {
        ArrayList<String> listeGroupee = new ArrayList<String>();
        for (int i = 0; i < chaineEnAscii.size() - 1; i++) {
            listeGroupee.add(i, chaineEnAscii.get(i));
            int j = i;
            while (listeGroupee.get(i).length() < 4) {
                while (chaineEnAscii.get(j+1).equals(" ")  && j != (listeGroupee.size() - 1))  {
                    System.out.println("On incrémente j = " + j );
                    ++j;
                    System.out.println(j);
                }
                /*if (listeGroupee.get(j) == listeGroupee.get(listeGroupee.size() - 1)) {
                    break;
                } */
                listeGroupee.set(i, listeGroupee.get(i) + chaineEnAscii.get(j + 1).substring(0, 1));
                chaineEnAscii.set(j + 1, chaineEnAscii.get(j + 1).substring(1));
                System.out.println("liste groupée " + listeGroupee);
                System.out.println("liste d'avant : " + chaineEnAscii);
            }
        }
        while (listeGroupee.get(listeGroupee.size() - 1).equals(" ")) {
            listeGroupee.remove(" ");
        }
        String chainetmp = listeGroupee.get(listeGroupee.size() - 1);
        while (chainetmp.length() < 4) {
            chainetmp = "0" + chainetmp;
        }
        listeGroupee.set(listeGroupee.size() - 1, chainetmp);
        return listeGroupee;
    }
}
