package fr.univ_amu.iut;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.StrictMath.log10;

/**
 * Created by l16000680 on 26/10/17.
 */
public class GroupeurDegroupeur {
    public ArrayList<String> grouperChaineAscii(ArrayList<String> chaineEnAscii) {
        ArrayList<String> listeGroupee = new ArrayList<String>();
        for (int i = 0; i < listeGroupee.size() - 1; i++) {
            listeGroupee.set(i, chaineEnAscii.get(i));
            int j = i;
            while (listeGroupee.get(i).length() < 4) {
                while (listeGroupee.get(j + 1).equals(" ") && listeGroupee.get(j) != listeGroupee.get(listeGroupee.size() - 1)) {
                    ++j;
                }
                if (listeGroupee.get(j) == listeGroupee.get(listeGroupee.size() - 1)) {
                    break;
                }
                listeGroupee.add(i, chaineEnAscii.get(j + 1).substring(0, 1));
                chaineEnAscii.set(j + 1, chaineEnAscii.get(j + 1).substring(chaineEnAscii.get(j + 1).length() - 1));
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

    public static void main(String[] args) {
        String chainetmp = new String();
        chainetmp = "01";
        chainetmp = "0" + chainetmp;
        System.out.println(chainetmp);
    }
}
