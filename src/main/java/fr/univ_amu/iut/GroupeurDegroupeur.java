package fr.univ_amu.iut;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.StrictMath.log10;

/**
 * Created by l16000680 on 26/10/17.
 */
public class GroupeurDegroupeur {
    public ArrayList<Integer> grouperChaineAscii(ArrayList<Integer> chaineEnAscii) {
        ArrayList<Integer> listeGroupee = new ArrayList<Integer>();
        for (int i = 0; i < listeGroupee.size()-1; i++) {
            listeGroupee.set(i,chaineEnAscii.get(i));
            int j = i;
            while ((log10(listeGroupee.get(i)) + 1) < 4) {
                while (listeGroupee.get(j+1) == 0 && listeGroupee.get(j) != listeGroupee.get(listeGroupee.size()-1)) {
                    j = j + 1;
                if (listeGroupee.get(j) == listeGroupee.get(chaineEnAscii.get(chaineEnAscii.size()-1))) {

                }
                }

            }













        }

    }

}
