package fr.univ_amu.iut;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.StrictMath.log10;
import static java.lang.StrictMath.sqrt;

/**
 * Created by l16000680 on 26/10/17.
 */
public class GroupeurDegroupeur {
    public ArrayList<String> grouperChaineAscii(ArrayList<String> chaineEnAscii) {
        ArrayList<String> listeGroupee = new ArrayList<String>();
        int j = 0;
        /*boolean sortie = false; */
        for (int i = 0; i < chaineEnAscii.size()-1; i++) {
            /*if (sortie == true)
                break; */
            listeGroupee.add(chaineEnAscii.get(i));
            while (listeGroupee.get(j).length() < 4) {
                while (chaineEnAscii.get(i+1).equals("") && i+1 != (chaineEnAscii.size()-1 ))  {
                    ++i;
                }
                if (chaineEnAscii.get(i+1).equals("") && i+1 == (chaineEnAscii.size()-1)) {
                    ++i;
                    break;
                }
                listeGroupee.set(j, listeGroupee.get(j) + chaineEnAscii.get(i + 1).substring(0, 1));
                chaineEnAscii.set(i + 1, chaineEnAscii.get(i + 1).substring(1));
                /*System.out.println("Chaine ascii : " + chaineEnAscii);
                System.out.println("liste groupée : " + listeGroupee); */
            }
            ++j;
        }
        listeGroupee.add(chaineEnAscii.get(chaineEnAscii.size()-1));
        if (listeGroupee.get(listeGroupee.size()-1).equals("")) {
            listeGroupee.remove("");
        }
        /*String chainetmp = listeGroupee.get(listeGroupee.size() - 1);
        while (chainetmp.length() < 4) {
            chainetmp = "0" + chainetmp;
        }
        listeGroupee.set(listeGroupee.size() - 1, chainetmp); */
        return listeGroupee;
    }

    public ArrayList<String> decouperChaineEn3 (ArrayList<String> listeDechiffree) {
        ArrayList<String> listeDecoupee = new ArrayList<String>();
        int j = 0;
        listeDecoupee.add("");
        for ( int i = 0; i < listeDechiffree.size(); i++) {
            while (listeDechiffree.get(i).length() > 0) {
                /*if (listeDecoupee.get(j) == "000")
                    listeDecoupee.set(j, ""); */
                if (listeDecoupee.get(j).length() == 3) {
                    ++j;
                    listeDecoupee.add("");
                }
                listeDecoupee.set(j, listeDecoupee.get(j) + listeDechiffree.get(i).substring(0, 1));
                listeDechiffree.set(i, listeDechiffree.get(i).substring(1));
            }
        }
        /*String chainetmp = listeDecoupee.get(listeDecoupee.size()-1);
        while (chainetmp.length() < 3) {
            chainetmp = "0" + chainetmp;
        }
        listeDecoupee.set(listeDecoupee.size()-1, chainetmp); */
        return listeDecoupee;
    }
}